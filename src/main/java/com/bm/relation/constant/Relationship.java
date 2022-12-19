package com.bm.relation.constant;

import lombok.Data;
import lombok.Getter;
import org.springframework.util.StringUtils;

import java.util.Objects;

/**
 * 人际关系
 * 按纽带关系划分
 * @author : zyg
 * @since : 2022/07/27
 **/
@Getter
public enum Relationship {
    SELF("自我",RelationshipType.FAMILY,10.0,0),
    MOTHER("母亲",RelationshipType.FAMILY,9.5,1),
    FATHER("父亲",RelationshipType.FAMILY,9.0,1),
    WIFE("妻子",RelationshipType.FAMILY,8.5,1),
    HUSBAND("丈夫",RelationshipType.FAMILY,8.5,1),
    SISTERS("姐妹",RelationshipType.FAMILY,8.0,1),
    BROTHER("兄弟",RelationshipType.FAMILY,8.0,1),
    SON("儿子",RelationshipType.FAMILY,8.0,1),
    DAUGHTER("女儿",RelationshipType.FAMILY,8.0,1),
    GRANDFATHER("爷爷",RelationshipType.FAMILY,7.0,1),
    GRANDMOTHER("奶奶",RelationshipType.FAMILY,7.0,1),
    GRANDSON("孙子",RelationshipType.FAMILY,6.5,1),
    GRANDDAUGHTER("孙女",RelationshipType.FAMILY,6.5,1),
    CLOSE_RELATIVES("近亲",RelationshipType.FAMILY,3.0,1),
    DISTANT_RELATIVE("远亲",RelationshipType.FAMILY,0.0,1),
    OTHER("远亲",RelationshipType.OTHER,0.0,1);
    private String describe;
    private RelationshipType type;
    // 不同详细关系 变动分值  基于基础分值进行计算
    private Double score;
    private Integer level;
    Relationship(String describe,RelationshipType type, Double score,Integer level){
        this.describe = describe;
        this.type = type;
        this.score = score;
        this.level = level;
    }

    public Double getScore(){
        return this.score + this.type.getBaseSource();
    }


    public static boolean contain(String describe){
        if(!StringUtils.hasText(describe)){
            return false;
        }
        for (Relationship relationship: Relationship.values()) {
            if(Objects.equals(relationship.getDescribe(),describe)){
                return true;
            }
        }
        return false;
    }

    public static Relationship getBydescribe(String describe){
        if(!StringUtils.hasText(describe)){
            return Relationship.OTHER;
        }
        for (Relationship relationship: Relationship.values()) {
            if(Objects.equals(relationship.getDescribe(),describe)){
                return relationship;
            }
        }
        return Relationship.OTHER;
    }

}
