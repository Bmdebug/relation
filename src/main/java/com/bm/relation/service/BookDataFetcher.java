//package com.bm.relation.service;
//
//import com.bm.relation.bean.Book;
//import com.bm.relation.repository.BookRepository;
//import graphql.schema.DataFetcher;
//import graphql.schema.DataFetchingEnvironment;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
///**
// * .
// *
// * @author : zyg
// * @since : 2022/07/20
// **/
//@Component
//public class BookDataFetcher implements DataFetcher<Book> {
//
//    @Autowired
//    private BookRepository bookRepository;
//
//    @Override
//    public Book get(DataFetchingEnvironment dataFetchingEnvironment) {
//        String isn = dataFetchingEnvironment.getArgument("id");
//        return bookRepository.findById(isn).orElse(null);
//    }
//}
