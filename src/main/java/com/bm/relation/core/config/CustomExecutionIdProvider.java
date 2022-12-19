package com.bm.relation.core.config;

import graphql.execution.ExecutionId;
import graphql.execution.ExecutionIdProvider;

/**
 * .
 *
 * @author : zyg
 * @since : 2022/07/25
 **/
public class CustomExecutionIdProvider implements ExecutionIdProvider {
    @Override
    public ExecutionId provide(String query, String operationName, Object context) {
        return ExecutionId.generate();
    }
}
