//package com.bm.relation.service;
//
//import com.bm.relation.bean.Book;
//import com.bm.relation.repository.BookRepository;
//import com.google.common.collect.Lists;
//import graphql.schema.DataFetcher;
//import graphql.schema.DataFetchingEnvironment;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//
///**
// * .
// *
// * @author : zyg
// * @since : 2022/07/20
// **/
//@Component
//public class AllBooksDataFetcher implements DataFetcher<List<Book>> {
//
//    @Autowired
//    private BookRepository bookRepository;
//
//    @Override
//    public List<Book> get(DataFetchingEnvironment dataFetchingEnvironment) {
//        return Lists.newArrayList(bookRepository.findAll());
//    }
//}