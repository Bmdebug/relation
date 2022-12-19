package com.bm.relation.core.exception;

import graphql.GraphQLError;
import graphql.GraphqlErrorBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * .
 *
 * @author : zyg
 * @since : 2022/07/25
 **/
@Slf4j
@Component
public class BusinessExceptionHandler {

        @ExceptionHandler(value = GraphQLBusinessException.class)
        private GraphQLError handleGraphQLError(GraphQLBusinessException graphQL) {
            System.out.println("进入异常捕获");
            return GraphqlErrorBuilder.newError()
                    .message(graphQL.getMessage())
                    .locations(graphQL.getLocations())
                    .path(graphQL.getPath())
                    .build();
        }

}
