//package com.bm.relation.service;
//
//
//import com.bm.relation.repository.BookRepository;
//import graphql.GraphQL;
//import graphql.schema.GraphQLSchema;
//import graphql.schema.idl.RuntimeWiring;
//import graphql.schema.idl.SchemaGenerator;
//import graphql.schema.idl.SchemaParser;
//import graphql.schema.idl.TypeDefinitionRegistry;
//import lombok.Getter;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.core.io.Resource;
//import org.springframework.stereotype.Service;
//import javax.annotation.PostConstruct;
//import java.io.File;
//import java.io.IOException;
//
///**
// * GraphQ 测试.
// *
// * @author : zyg
// * @since : 2022/07/20
// **/
//@Service
//public class GraphQLService {
//
//    @Value("classpath:schema.graphql")
//    private Resource resource;
//
//    @Autowired private BookRepository bookRepository;
//
//    @Getter private GraphQL graphQL;
//
//    @Autowired private AllBooksDataFetcher allBooksDataFetcher;
//
//    @Autowired private BookDataFetcher bookDataFetcher;
//
//    @PostConstruct
//    private void loadSchema() throws IOException {
//        //loadDataIntoHSQL();
//        // 获取本地定义的 Schema 文件
//        File schemaFile = resource.getFile();
//        // 解析 Schema 文件
//        TypeDefinitionRegistry typeRegistry = new SchemaParser().parse(schemaFile);
//        RuntimeWiring wiring = buildRuntimeWiring();
//        GraphQLSchema schema = new SchemaGenerator().makeExecutableSchema(typeRegistry, wiring);
//        graphQL = GraphQL.newGraphQL(schema).build();
//    }
//
//    private RuntimeWiring buildRuntimeWiring() {
//        return RuntimeWiring.newRuntimeWiring()
//                .type(
//                        "Query",
//                        typeWiring ->
//                                typeWiring
//                                        .dataFetcher("allBooks", allBooksDataFetcher)
//                                        .dataFetcher("book", bookDataFetcher))
//                .build();
//    }
//}