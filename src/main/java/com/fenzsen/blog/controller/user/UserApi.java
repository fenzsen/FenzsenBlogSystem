package com.fenzsen.blog.controller.user;

import com.fenzsen.blog.pojo.FenUser;
import com.fenzsen.blog.response.ResponseResult;
import com.fenzsen.blog.services.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Date: 2020/8/8
 * Description: 用户相关API
 */

@Slf4j
@RestController
@RequestMapping("/user")
public class UserApi {

    @Autowired
    private IUserService userService;


    /**
    * Description: 初始化管理员账号
    */
    @PostMapping("/admin_account")
    public ResponseResult initManagerAccount(@RequestBody FenUser user, HttpServletRequest request){
        log.info("userName："+ user.getUserName());
        log.info("password："+ user.getPassword());
        log.info("email："+ user.getEmail());
        return userService.initManagerAccount(user,request);
    }

    /**
    * Description: 注册
    */
    @PostMapping
    public ResponseResult register(@RequestBody FenUser user){
        return userService.register(user);
    }

    /**
    * Description: 登录
    */
    @PostMapping("/{captcha}")
    public ResponseResult login(@PathVariable String captcha,@RequestBody FenUser user){
        log.info("captcha："+ captcha);
        log.info("userName："+ user.getUserName());
        log.info("password："+ user.getPassword());
        log.info("email："+ user.getEmail());
        return ResponseResult.SUCCESS();
    }



    /**
     * Description: 获取图灵验证码
     */
    @GetMapping("/captcha")
    public void getCaptcha(HttpServletResponse response, @RequestParam("captcha_key") String captchaKey) throws Exception {
        userService.createCaptcha(response,captchaKey);
    }

    /**
     * Description: 发送邮件
     */
    @GetMapping("/verify_code")
    public ResponseResult sendVerifyCode(HttpServletRequest request,@RequestParam("email")String emailAddress){
        log.info("emailAddress："+emailAddress);
        return userService.sendEali(request,emailAddress);
    }

    /**
    * Description: 修改密码
    * Date: 2020/8/8
    */
    @PutMapping("/password/{userId}")
    public ResponseResult updatePassword(@RequestBody FenUser user, @PathVariable String userId){
        return null;
    }

    /**
     * Description: 获取作者信息
     */
    @GetMapping("/{userId}")
    public ResponseResult getUserInfo(@PathVariable String userId){
        log.info("emailAddress："+userId);
        return null;
    }


    /**
     * Description: 修改密码
     * Date: 2020/8/8
     */
    @PutMapping("{userId}")
    public ResponseResult updateUserInfo(@RequestBody FenUser user, @PathVariable String userId){
        return null;
    }


    /**
     * Description: 获取用户列表
     * Date: 2020/8/8
     */
    @GetMapping("/list")
    public ResponseResult listUser(@RequestParam("page")int page,@RequestParam("size")int size){
        return null;
    }

    /**
     * Description: 删除用户
     * Date: 2020/8/8
     */
    @DeleteMapping("{userId}")
    public ResponseResult deleteUser(@PathVariable String userId){
        return null;
    }



}
