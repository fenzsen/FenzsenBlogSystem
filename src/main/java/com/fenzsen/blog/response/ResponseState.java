package com.fenzsen.blog.response;

/* 状态封装类 */
public enum ResponseState {
    // enum 枚举
    SUCCESS(true,20000,"数据操作成功"),
    FAILED(false,40000,"服务器繁忙");

    ResponseState(boolean success, int code, String message){
        this.success = success;
        this.code = code;
        this.message = message;
    }

    private boolean success;    // 是否成功
    private int code;   // 状态码
    private String message;     // 提示信息

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
