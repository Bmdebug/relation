package com.bm.relation.repository;


import com.bm.relation.bean.People;
import com.bm.relation.core.config.IBaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeopleRepository extends IBaseRepository<People, String> {

}