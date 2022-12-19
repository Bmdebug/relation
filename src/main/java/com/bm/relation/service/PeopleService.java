package com.bm.relation.service;

import com.bm.relation.bean.People;
import com.bm.relation.core.domain.BusinessException;
import com.bm.relation.core.exception.GraphQLBusinessException;
import com.bm.relation.core.util.UUIDUtil;
import com.bm.relation.model.relation.GraphPeople;
import com.bm.relation.repository.PeopleRepository;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.graphql.execution.ErrorType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

/**
 * .
 *
 * @author : zyg
 * @since : 2022/07/22
 **/
@Component
@Service
public class PeopleService  {

    private PeopleRepository peopleRepository;
    PeopleService(PeopleRepository peopleRepository){

        this.peopleRepository = peopleRepository;
    }
    public List<People> findList(){
        return peopleRepository.findAll();
    }

    public List<People> findListByLable(String lable){
        Query query = new Query();
        query.addCriteria(new Criteria("labels").is(lable));
        return peopleRepository.find(query);
    }

    public GraphPeople findRelation(String id){
        GraphPeople graphPeople = new GraphPeople();
        Optional<People>  base = peopleRepository.findById(id);
        if(base.isEmpty()){
            throw new GraphQLBusinessException("数据不存在", ErrorType.BAD_REQUEST);
        }
        Query query = new Query();
        query.addCriteria(new Criteria("links.target").is(id));
        query.addCriteria(new Criteria("_id").ne(id));
        graphPeople.setRoot(base.get());
        graphPeople.setLeaf(peopleRepository.find(query));
        return graphPeople;
    }

    /**
     * 基础crud
     */
    public People create(People people){
        Optional<People>  base = findById(people.getId());
        if(!base.isEmpty()){
            throw new BusinessException("数据已存在");
        }
        people.setId(UUIDUtil.getUUID());
        return peopleRepository.save(people);
    }
    public People update(People people){
        Optional<People>  base = findById(people.getId());
        if(base.isEmpty()){
            throw new BusinessException("数据不存在");
        }
        return peopleRepository.save(people);
    }

    public void delete(String id){
        Optional<People>  base = findById(id);
        if(base.isEmpty()){
            throw new BusinessException("数据不存在");
        }
        peopleRepository.deleteById(id);
    }

    public Optional<People> findById(String id){
        Optional<People>  base = peopleRepository.findById(id);
        return base;
    }

}
