package com.bm.relation.api;

import com.bm.relation.bean.People;
import com.bm.relation.core.annotation.ApiPath;
import com.bm.relation.model.relation.GraphPeople;
import com.bm.relation.service.PeopleService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@ApiPath(path = "/people")
public class PeopleApi {

    private final PeopleService peopleService;
    PeopleApi(PeopleService peopleService){
        this.peopleService = peopleService;
    }

    @PostMapping("/create")
    public People create(@RequestBody People people){
        return peopleService.create(people);
    }
    @PutMapping("/update")
    public People update(@RequestBody People people){
        return peopleService.update(people);
    }
    @GetMapping("/findById/{id}")
    public People update(@PathVariable String id){
        return peopleService.findById(id).get();
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable String id){
        peopleService.delete(id);
    }

}