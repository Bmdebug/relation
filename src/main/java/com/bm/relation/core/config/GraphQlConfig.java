package com.bm.relation.core.config;

import com.bm.relation.core.exception.GraphQLBusinessException;
import graphql.GraphQLError;
import graphql.GraphqlErrorBuilder;
import org.springframework.boot.autoconfigure.graphql.GraphQlSourceBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * .
 *
 * @author : zyg
 * @since : 2022/07/25
 **/
@Configuration(proxyBeanMethods = false)
class GraphQlConfig {
    @Bean
    public GraphQlSourceBuilderCustomizer sourceBuilderCustomizer() {
        return (builder) ->
                builder.configureGraphQl(graphQlBuilder ->
                        graphQlBuilder.executionIdProvider(new CustomExecutionIdProvider()));
    }


    @ExceptionHandler(value = GraphQLBusinessException.class)
    private GraphQLError handleGraphQLError(GraphQLBusinessException graphQL) {
        return GraphqlErrorBuilder.newError()
                .message(graphQL.getMessage())
                .locations(graphQL.getLocations())
                .path(graphQL.getPath())
                .build();
    }
}
