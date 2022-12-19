package com.bm.relation.constant;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 关系类别.
 * 部分基于维基百科 https://zh.wikipedia.org/wiki/%E4%BA%BA%E9%9A%9B%E9%97%9C%E4%BF%82
 * 部分自行编订
 * @author : zyg
 * @since : 2022/07/27
 **/
public enum RelationshipType {
    SELF("自己",100.0),
    FAMILY("亲属",90.0),
    MASTER_AND_APPRENTICE("师徒",80.0),
    CLASSMATES("同学",75.0),
    COMRADE_IN_ARMS("战友",75.0),
    HOSTILITY("敌对",70.0),//负面关系 但是相关度较高
    FRIEND("朋友",65.0),
    COLLEAGUE("同事",60.0),
    EMPLOY("雇佣",50.0),
    NETIZENS("网友",40.0),
    OTHER("其他",30.0),
    UNFAMILIAR("陌生",0.0);
    // 关系类型
    private String type;
    // 基础关联度分值
    private Double baseSource;
    RelationshipType(String type,Double baseSource){
        this.type = type;
        this.baseSource = baseSource;
    }

    public String getType() {
        return type;
    }

    public Double getBaseSource() {
        return baseSource;
    }
}
