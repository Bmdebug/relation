package com.bm.relation.core.domain;

import com.bm.relation.core.constant.ErrorCode;
import java.text.MessageFormat;

/**
 * 自定义异常类
 * @author : zyg
 * @since : 2022/07/19
 **/
public class BusinessException extends RuntimeException {

    private String code;
    private Object[] args;

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String code, String message) {
        super(message);
        this.code = code;
    }

    public BusinessException(ErrorCode errorCode) {
        super(errorCode.message());
        this.code = errorCode.code();
    }

    public BusinessException(String code, String message, Object... args) {
        super(MessageFormat.format(message, args));
        this.code = code;
        this.args = args;
    }

    public String getCode() {
        return this.code;
    }

    public Object[] getArgs() {
        return args;
    }
}
