package com.fenzsen.blog.utils;

/**
 * Description: 常量管理接口
 * Date: 2020/8/8
 */
public interface Constants {

    int DEFAULT_SIZE = 20;

    interface User{
        String ROLE_ADMIN = "role_admin";   // 管理员角色
        String DEFAULT_AVATAR = "https://cdn.sunofbeaches.com/images/default_avatar.png";   // 默认头像地址
        String DEFAULT_STATE = "1";    // 默认状态
        String KEY_CAPTCHA_CONTENT = "key_captcha_content_";    // 图灵验证码
        String KEY_EMAIL_SEND_IP = "key_email_send_ip_";    // 发送ip
        String KEY_EMAIL_SEND_ADDRESS = "key_email_send_address_";    // 邮箱地址
        String KEY_EMAIL_SEND_CONTENT = "key_email_send_content_";    // 邮箱验证码

    }

    interface Setiings{
        String MANAGE_ACCOUNT_INIT_SATE = "manage_account_init_sate";
    }


}
