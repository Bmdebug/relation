package com.bm.relation.model.relation;

import lombok.Data;

/**
 * .
 *
 * @author : zyg
 * @since : 2022/07/26
 **/
@Data
public class GraphCategorie {
    private String name;

    public GraphCategorie(String name){
        this.name = name;
    }
}
