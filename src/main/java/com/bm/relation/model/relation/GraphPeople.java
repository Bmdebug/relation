package com.bm.relation.model.relation;

import com.bm.relation.bean.People;
import lombok.Data;

import java.util.List;

/**
 * .
 *
 * @author : zyg
 * @since : 2022/07/29
 **/
@Data
public class GraphPeople {
    private People root ;
    private List<People> leaf;
}
