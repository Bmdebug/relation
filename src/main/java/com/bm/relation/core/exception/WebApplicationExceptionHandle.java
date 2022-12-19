package com.bm.relation.core.exception;

import com.bm.relation.core.domain.BusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 全局异常处理类
 * @author : zyg
 * @since : 2022/07/19
 **/
@ControllerAdvice
public class WebApplicationExceptionHandle {
    private final static Logger LOGGER = LoggerFactory.getLogger(WebApplicationExceptionHandle.class);

    private final MessageSource messageSource;

    public WebApplicationExceptionHandle(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @ExceptionHandler(value = BusinessException.class)
    @ResponseBody
    public ResponseEntity<WebApplicationExceptionMessage> businessExceptionHandler(HttpServletRequest request, BusinessException e) throws Exception {
        WebApplicationExceptionMessage exceptionMessage = new WebApplicationExceptionMessage();
        if (StringUtils.hasText(e.getCode())) {
            exceptionMessage.setCode(StringUtils.hasText(e.getCode()) ? "SYSTEM" : e.getCode());
            exceptionMessage.setMessage(e.getMessage());
        } else {
            exceptionMessage.setCode(e.getCode());
            exceptionMessage.setMessage(messageSource.getMessage(e.getCode(), e.getArgs(), e.getMessage(), request.getLocale()));
        }
        return new ResponseEntity<>(exceptionMessage, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = Throwable.class)
    @ResponseBody
    public ResponseEntity<WebApplicationExceptionMessage> defaultErrorHandler(HttpServletRequest request, HttpServletResponse response, Throwable e) throws Exception {
        WebApplicationExceptionMessage exceptionMessage = new WebApplicationExceptionMessage();
        exceptionMessage.setCode("SYSTEM");
        exceptionMessage.setMessage(e.getMessage());
        String exceptionType = e.getClass().getName();
        HttpStatus httpStatus;
        httpStatus = HttpStatus.EXPECTATION_FAILED;
        String code = "SYSTEM";
        exceptionMessage.setCode(code);
        exceptionMessage.setMessage(WebApplicationExceptionMessage.SERVER_BUSY.getMessage());
        LOGGER.error("[".concat(code).concat("]").concat(exceptionType), e);
        return new ResponseEntity<>(exceptionMessage, httpStatus);
    }


}
