package com.fenzsen.blog.utils;

import java.util.regex.Pattern;

/**
 * Description: 文字检查工具类
 * Date: 2020/8/8
 */
public class TextUtils {

    public static boolean isEmpty(String text){
        return text == null || text.length() == 0;
    }

    public static boolean isEmailAddressOk(String text){
        String regEx = "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";
        Pattern p = Pattern.compile(regEx);
        return p.matcher(text).matches();
    }

}
