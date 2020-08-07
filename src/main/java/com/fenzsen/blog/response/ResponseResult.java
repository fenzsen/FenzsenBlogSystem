package com.fenzsen.blog.response;

/* 返回结果类 */
public class ResponseResult {

    private boolean success;    // 是否成功
    private int code;   // 状态码
    private String message;     // 提示信息
    private Object data;      // 返回的具体数据

    public ResponseResult(ResponseState responseState) {
        this.success = responseState.isSuccess();
        this.code = responseState.getCode();
        this.message = responseState.getMessage();
    }

    // 成功
    public static ResponseResult SUCCESS(){
        return new ResponseResult(ResponseState.SUCCESS);
    }

    // 失败
    public static ResponseResult FAILED(){
        return new ResponseResult(ResponseState.FAILED);
    }
    // 成功：自定义信息
    public static ResponseResult SUCCESS(String message){
        ResponseResult result = new ResponseResult(ResponseState.SUCCESS);
        result.setMessage(message);
        return result;
    }

    // 失败：自定义信息
    public static ResponseResult FAILED(String message){
        ResponseResult result = new ResponseResult(ResponseState.FAILED);
        result.setMessage(message);
        return result;
    }

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

    public Object getData() {
        return data;
    }

    public ResponseResult setData(Object data) {
        this.data = data;
        return this;
    }
}
