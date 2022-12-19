package com.bm.relation.bean;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
public class PeopleInput {

    private String id;
    private String name;
    private List<String> lables;
    private List<String> links;


}