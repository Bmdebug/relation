package com.bm.relation.repository;


import com.bm.relation.bean.Book;
import com.bm.relation.core.config.IBaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends IBaseRepository<Book, String> {

}