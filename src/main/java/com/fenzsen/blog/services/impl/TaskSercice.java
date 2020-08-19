package com.fenzsen.blog.services.impl;

import com.fenzsen.blog.utils.EmailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * Description: 处理异步任务
 * Date: 2020/8/20
 */
@Service
public class TaskSercice {

    /**
    * Description: 异步发送邮件
    * Date: 2020/8/20
    */
    @Async
    public void sendRegisterVerifyCode(String code,String emailAddress) throws Exception{
        EmailSender.sendRegisterVerifyCode(code,emailAddress);
    }

}
