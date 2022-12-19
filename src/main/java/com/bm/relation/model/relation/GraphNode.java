//package com.bm.relation.model.relation;
//
//import com.bm.relation.bean.Link;
//import com.bm.relation.bean.People;
//import com.bm.relation.constant.Relationship;
//import lombok.Data;
//import lombok.ToString;
//import lombok.extern.slf4j.Slf4j;
//import java.util.List;
//import java.util.Objects;
//import java.util.stream.Collectors;
//
///**
// * .
// *
// * @author : zyg
// * @since : 2022/07/26
// **/
//@Data
//@ToString
//@Slf4j
//public class GraphNode {
//    private String id;
//    private String name;
//    private Double symbolSize;
//    private Double x;
//    private Double y;
//    private Double value;
//    private String category;
//
//    public static GraphNode from(People people,People root){
//        GraphNode node = new GraphNode();
//        node.id = people.getId();
//        node.name = people.getName();
//        List<Link> links = people.getLinks().stream().filter(
//                link ->
//                Objects.equals(link.getTarget(),root.getId())
//        ).collect(Collectors.toList());
//        // 可能都有多种关联关系
//        // 如果有多个 暂时取等级 或分数最高的
//        Relationship realtion = eval(links) ;
//        node.symbolSize = realtion.getScore() * 0.5;
//        node.x = (realtion.getScore()*Math.random());
//        node.y = 50.0;//(realtion.getScore()*Math.random());
//        if(Objects.equals(realtion,Relationship.SON) || Objects.equals(realtion,Relationship.DAUGHTER) ){
//            node.y = 48.0;//(realtion.getScore()*Math.random());
//            if(people.getName().equals("张三爸爸")){
//                node.x = 45.0;
//            }
//            if(people.getName().equals("张三妈妈")){
//                node.x = 50.0;
//            }
//        }
//        if(Objects.equals(realtion,Relationship.BROTHER) || Objects.equals(realtion,Relationship.SISTERS) ){
//            node.y = 50.0;//(realtion.getScore()*Math.random());
//            if(people.getName().equals("张三的大姐")){
//                node.x = 40.0;
//            }
//            if(people.getName().equals("张三的二姐")){
//                node.x = 45.0;
//            }
//            if(people.getName().equals("张三的表哥")){
//                node.x = 55.0;
//            }
//        }
//        node.value =  realtion.getScore();
//        node.category = "B";
//        log.info("realtion:{},node:{}",realtion,node.toString());
//        return node;
//    }
//
//    public static GraphNode fromSelf(People people){
//        GraphNode node = new GraphNode();
//        node.id = people.getId();
//        node.name = people.getName();
//        Relationship realtion = Relationship.SELF ;
//        node.symbolSize = realtion.getScore()* 0.5;
//        node.x = 50.0;
//        node.y = 50.0;
//        node.value =  53.37143;
//        node.category = "A";
//        log.info("realtion:{},node:{}",realtion,node.toString());
//        return node;
//    }
//
//    private static Relationship eval(List<Link> links){
//        Relationship realtion = null;
//        if(links == null || links.size() ==0){
//            return Relationship.OTHER;
//        }
//        if(links.get(0).getDescribes() == null){
//            return Relationship.OTHER;
//        }
//        realtion = Relationship.contain(links.get(0).getDescribes().get(0)) ?
//                Relationship.getBydescribe(links.get(0).getDescribes().get(0))
//                :Relationship.OTHER ;
//        return realtion;
//    }
//
//}
