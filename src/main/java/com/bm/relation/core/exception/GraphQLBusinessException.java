package com.bm.relation.core.exception;

import graphql.ErrorClassification;
import graphql.GraphQLError;
import graphql.language.SourceLocation;
import org.springframework.graphql.execution.ErrorType;
import java.util.List;

/**
 * 自定义异常类
 * @author : zyg
 * @since : 2022/07/19
 **/
public class GraphQLBusinessException extends RuntimeException implements GraphQLError  {

    private String message;
    private List<SourceLocation> locations;
    private ErrorType errorType;

    public GraphQLBusinessException(String message, ErrorType errorType){
        super(message);
        this.message = message;
        this.errorType = errorType;
    }

    public GraphQLBusinessException(String message){
        super(message);
        this.message = message;
    }



    @Override
    public String getMessage() {
        return message;
    }
    @Override
    public List<SourceLocation> getLocations() {
        return locations;
    }
    @Override
    public ErrorClassification getErrorType() {
        return errorType;
    }
    @Override
    public List<Object> getPath() {
        return null;
    }
}
