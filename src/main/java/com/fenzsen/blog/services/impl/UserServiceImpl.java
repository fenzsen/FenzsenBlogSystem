package com.fenzsen.blog.services.impl;

import com.fenzsen.blog.dao.SetiingDao;
import com.fenzsen.blog.dao.UserDao;
import com.fenzsen.blog.pojo.FenUser;
import com.fenzsen.blog.pojo.Setting;
import com.fenzsen.blog.response.ResponseResult;
import com.fenzsen.blog.services.IUserService;
import com.fenzsen.blog.utils.*;
import com.wf.captcha.ArithmeticCaptcha;
import com.wf.captcha.GifCaptcha;
import com.wf.captcha.SpecCaptcha;
import com.wf.captcha.base.Captcha;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.Random;

/**
 * Description: 用户接口服务实现类
 * Date: 2020/8/8
 */
@Slf4j
@Service    // @Service 标注业务层组件
@Transactional  // 数据库事务管理
public class UserServiceImpl implements IUserService {

    // 雪花算法 ID
    @Autowired
    private IdWorker idWorker;
    // UserDao 数据库
    @Autowired
    private UserDao userDao;
    // SetiingDao 数据库
    @Autowired
    private SetiingDao setiingDao;
    // BCryptPasswordEncoder 密码加密
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    // RedisUtil 缓存
    @Autowired
    private RedisUtil redisUtil;
    // TaskSercice 处理异步任务
    @Autowired
    private TaskSercice taskSercice;


    /**
    * Description: 初始化管理员账号实现
    * Date: 2020/8/9
    */
    @Override
    public ResponseResult initManagerAccount(FenUser user, HttpServletRequest request) {
        // 检查是否初始化
        Setting oneByKey = setiingDao.findOneByKey(Constants.Setiings.MANAGE_ACCOUNT_INIT_SATE);
        if (oneByKey != null) return ResponseResult.FAILED("管理员账号已经初始化");
        // 检查数据
        if (TextUtils.isEmpty(user.getUserName())) {
            return ResponseResult.FAILED("用户名不能为空");
        }
        if (TextUtils.isEmpty(user.getPassword())) {
            return ResponseResult.FAILED("密码不能为空");
        }
        if (TextUtils.isEmpty(user.getEmail())) {
            return ResponseResult.FAILED("邮箱不能为空");
        }
        // 补充数据
        user.setId(String.valueOf(idWorker.nextId()));
        user.setRoles(Constants.User.ROLE_ADMIN);
        user.setAvatar(Constants.User.DEFAULT_AVATAR);
        user.setState(Constants.User.DEFAULT_STATE);
        user.setLoginIp(request.getRemoteAddr());
        user.setSign("自先沉稳");
        user.setRegIp(request.getLocalAddr());
        user.setUpdateTime(new Date());
        user.setCreateTime(new Date());
        // 加密密码
        String encode = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(encode);
        // 保存数据
        userDao.save(user);
        Setting setting = new Setting();
        setting.setId(String.valueOf(idWorker.nextId()));
        setting.setCreateTime(new Date());
        setting.setUpdateTime(new Date());
        setting.setKey(Constants.Setiings.MANAGE_ACCOUNT_INIT_SATE);
        setting.setValue(1);
        setiingDao.save(setting);
        return ResponseResult.SUCCESS("管理员账号初始化成功");
    }

    public static final int[] captcha_font_type = {
            Captcha.FONT_1,Captcha.FONT_2, Captcha.FONT_3,Captcha.FONT_4, Captcha.FONT_5,
            Captcha.FONT_6, Captcha.FONT_7,Captcha.FONT_8, Captcha.FONT_9,Captcha.FONT_10,
    };

    /**
    * Description: 获取图灵验证码
    * Date: 2020/8/19
    */
    @Override
    public void createCaptcha(HttpServletResponse response, String captchaKey) throws Exception {
        if (TextUtils.isEmpty(captchaKey) || captchaKey.length() < 13) return;
        long key = Long.parseLong(captchaKey);

        // 设置请求头为输出图片类型
        response.setContentType("image/gif");
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);

        Random random = new Random();
        int captchaType = random.nextInt(3);
        int index = random.nextInt(captcha_font_type.length);
        log.info("captchaType ==>" + captchaType);
        log.info("index ==>" + index);

        Captcha targetCapcha = null;
        if (captchaType == 0){
            // 三个参数分别为宽、高、位数
            targetCapcha = new SpecCaptcha(130, 48, 5);
        }else if(captchaType == 1){
            targetCapcha = new GifCaptcha(130,48);
        }else {
            targetCapcha = new ArithmeticCaptcha(130,48);
            targetCapcha.setLen(2);
        }

        // 设置字体
        // specCaptcha.setFont(new Font("Verdana", Font.PLAIN, 32));  // 有默认字体，可以不用设置
        targetCapcha.setFont(captcha_font_type[index]);  // 有默认字体，可以不用设置
        // 设置类型，纯数字、纯字母、字母数字混合
        targetCapcha.setCharType(Captcha.TYPE_NUM_AND_UPPER);

        // 验证码结果
        String constent = targetCapcha.text().toLowerCase();
        log.info("constent==>" + constent);


        // 验证码存入session
        // request.getSession().setAttribute("captcha", specCaptcha.text().toLowerCase());
        redisUtil.set(Constants.User.KEY_CAPTCHA_CONTENT+key,constent,60*10);

        // 输出图片流
        targetCapcha.out(response.getOutputStream());
    }

    /**
    * Description: 发送邮件
    * Date: 2020/8/19
    */
    @Override
    public ResponseResult sendEali(HttpServletRequest request, String emailAddress) {
        // ip 地址
        String remoteAddr = request.getRemoteAddr();
        log.info("Email=>ip==>" + remoteAddr);
        if (remoteAddr != null) remoteAddr = remoteAddr.replaceAll(":","_");

        // 同一个IP，一小时内发送验证码超过 10 次
        Integer ipSendTime = (Integer) redisUtil.get(Constants.User.KEY_EMAIL_SEND_IP + remoteAddr);
        log.info("ipSendTime ==>" + ipSendTime);

        if (ipSendTime != null && ipSendTime > 10) return ResponseResult.FAILED("验证码发送过于频繁！");

        // 同一个邮箱，一分钟内只能发一次
        Object hasEmailSend = redisUtil.get(Constants.User.KEY_EMAIL_SEND_ADDRESS + emailAddress);
        if (hasEmailSend != null) return ResponseResult.FAILED("验证码发送过于频繁,请一分钟后重试！");

        // 校验邮箱格式
        boolean emailAddressOk = TextUtils.isEmailAddressOk(emailAddress);
        if (!emailAddressOk) return ResponseResult.FAILED("验证码错误！");

        Random random = new Random();
        int code = random.nextInt(999999);
        if (code<100000) code+=100000;

        // 发送验证码
        try {
            // 异步发送
            taskSercice.sendRegisterVerifyCode(String.valueOf(code),emailAddress);
        } catch (Exception e) {
            return ResponseResult.FAILED("验证码发送失败，请稍后重试");
        }

        if (ipSendTime == null){
            ipSendTime = 0;
        }
        ipSendTime ++;
        // 保存记录,有效期
        redisUtil.set(Constants.User.KEY_EMAIL_SEND_IP+remoteAddr,ipSendTime,60*60);
        redisUtil.set(Constants.User.KEY_EMAIL_SEND_ADDRESS+emailAddress,"true",60);

        // 保存验证码
        redisUtil.set(Constants.User.KEY_EMAIL_SEND_CONTENT,String.valueOf(code),60*10);

        return ResponseResult.SUCCESS("验证码发送成功");
    }

    @Override
    public ResponseResult register(FenUser user) {
        //  验证当前用户名是否已经注册
        //  验证邮箱格式是否正确
        //  验证邮箱是否已经注册
        //  验证邮箱验证码是否正确
        //  验证图灵验证码是否正确
        //  对密码进行加密
        //  补全数据
        //  保存到数据库
        //  返回数据
        return null;
    }


}
