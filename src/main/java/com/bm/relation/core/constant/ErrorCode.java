package com.bm.relation.core.constant;

import com.bm.relation.core.exception.WebApplicationExceptionMessage;
import com.bm.relation.core.domain.BusinessException;
import com.google.common.collect.Maps;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.text.MessageFormat;
import java.util.Map;

/**
 * 异常码
 * @author : zyg
 * @since : 2022/07/19
 **/
public enum ErrorCode {
    // http 异常信息 4XX 5XX
    HTTP_NOT_FOUND("404", "该资源不存在"),

    //参数检查相关 200xxx
    USER_ID_NOT_NULL("200001", "用户ID不能为空"),
    USER_LOGIN_ERROR("200002", "用户登录信息错误"),
    ;

    private final static Map<String, ErrorCode> ERROR_CODE_MAP;

    static {
        ERROR_CODE_MAP = Maps.newHashMap();
        for (ErrorCode errorCode : ErrorCode.values()) {
            if (ERROR_CODE_MAP.containsKey(errorCode.code)) {
                throw new RuntimeException("Error code duplicate. code: ".concat(errorCode.code));
            }
            ERROR_CODE_MAP.put(errorCode.code, errorCode);
        }
    }

    /**
     * 错误编码
     */
    private String code;
    /**
     * 错误消息
     */
    private String message;
    /**
     * 是否为系统级别异常
     */
    private boolean system;

    ErrorCode(String code, String message) {
        this.code = code;
        this.message = message;
        this.system = false;
    }

    ErrorCode(String code, String message, boolean system) {
        this.code = code;
        this.message = message;
        this.system = system;
    }

    public static ErrorCode from(String code) {
        ErrorCode errorCode = ERROR_CODE_MAP.get(code);
        if (errorCode == null) {
            throw new RuntimeException("Invalid error code.");
        }
        return errorCode;
    }

    public String code() {
        return code;
    }

    public String message() {
        return message;
    }

    public boolean isSystem() {
        return system;
    }

    public void triggerException() {
        throw new BusinessException(code, message);
    }

    public void triggerException(Object... args) {
        throw new BusinessException(code, MessageFormat.format(message, args));
    }

    public ResponseEntity errorResult() {
        WebApplicationExceptionMessage errorResult = WebApplicationExceptionMessage.from(code, message);
        return ResponseEntity.badRequest().contentType(MediaType.APPLICATION_JSON).body(errorResult);
    }


}