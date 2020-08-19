package com.fenzsen.blog.services;

import com.fenzsen.blog.pojo.FenUser;
import com.fenzsen.blog.response.ResponseResult;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Description: 用户相关服务
 * Date: 2020/8/8
 */
public interface IUserService {

    ResponseResult initManagerAccount(FenUser user, HttpServletRequest request);

    void createCaptcha(HttpServletResponse response, String captchaKey) throws Exception;

    ResponseResult sendEali(HttpServletRequest request, String emailAddress);

    ResponseResult register(FenUser user);
}
