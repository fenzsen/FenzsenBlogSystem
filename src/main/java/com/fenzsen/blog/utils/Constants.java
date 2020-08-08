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
    }

    interface Setiings{
        String MANAGE_ACCOUNT_INIT_SATE = "manage_account_init_sate";
    }


}
