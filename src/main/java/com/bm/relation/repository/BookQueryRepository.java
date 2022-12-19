package com.bm.relation.repository;

import com.bm.relation.bean.Book;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

/**
 * Query by Example .
 *
 * @author : zyg
 * @since : 2022/07/22
 **/
public interface BookQueryRepository extends Repository<Book, Long>, QueryByExampleExecutor<Book> {
}