package com.bm.relation.core.exception;

/**
 * 全局异常消息实体
 * @author : zyg
 * @since : 2022/07/19
 **/
public class WebApplicationExceptionMessage {

    public static WebApplicationExceptionMessage SERVER_BUSY = from("SYSTEM", "服务器正忙，请稍候重试。");
    private String code;
    private String message;

    public static WebApplicationExceptionMessage from(String code, String message) {
        WebApplicationExceptionMessage exceptionMessage = new WebApplicationExceptionMessage();
        exceptionMessage.code = code;
        exceptionMessage.message = message;
        return exceptionMessage;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
