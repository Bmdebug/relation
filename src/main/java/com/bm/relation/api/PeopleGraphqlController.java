package com.bm.relation.api;

import com.bm.relation.bean.People;
import com.bm.relation.model.relation.GraphPeople;
import com.bm.relation.service.PeopleService;
import org.springframework.graphql.data.method.annotation.*;
import org.springframework.stereotype.Controller;
import java.util.List;

@Controller
public class PeopleGraphqlController {


    private final PeopleService peopleService;
    PeopleGraphqlController(PeopleService peopleService){
        this.peopleService = peopleService;
    }

    @QueryMapping
    public List<People> findList() {
        return peopleService.findList();
    }

    @QueryMapping
    public GraphPeople findRelation(@Argument String id) {
        return peopleService.findRelation(id);
    }

    @QueryMapping
    public List<People> findListByLable(@Argument String str) {
        return peopleService.findListByLable(str);
    }

    @MutationMapping
    public People update(@Argument People peopleInput)  {
        return peopleService.update(peopleInput);
    }

}