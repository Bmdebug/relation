package com.bm.relation.model.relation;

import com.bm.relation.bean.Link;
import com.bm.relation.bean.People;
import com.google.common.collect.Lists;
import lombok.Data;

import java.util.List;

/**
 * .
 *
 * @author : zyg
 * @since : 2022/07/26
 **/
@Data
public class GraphLink {
    private String source;
    private String target;

    public static List<GraphLink> from(People people,People root) {
        List<GraphLink> links = Lists.newArrayList();
        for (Link temp: people.getLinks()) {
            //GraphLink
            links.add(new GraphLink(people.getId(),temp.getTarget()));
        }
        return links;
    }

    GraphLink(String source,String target){
        this.source = source;
        this.target = target;
    }

}
