package com.fenzsen.blog.services.impl;

import com.fenzsen.blog.pojo.FenUser;
import com.fenzsen.blog.response.ResponseResult;
import com.fenzsen.blog.services.IUserService;
import com.fenzsen.blog.utils.TextUtils;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

/**
 * Description: 用户接口服务实现类
 * Date: 2020/8/8
 */
@Service
@Transactional
public class UserServiceImpl implements IUserService {

    @Override
    public ResponseResult initManagerAccount(FenUser user, HttpServletRequest request) {
        // 检查是否初始化
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


        return null;
    }
}
