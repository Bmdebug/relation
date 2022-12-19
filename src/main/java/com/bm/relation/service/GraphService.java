//package com.bm.relation.service;
//
//import com.bm.relation.bean.People;
//import com.bm.relation.model.relation.GraphCategorie;
//import com.bm.relation.model.relation.GraphLink;
//import com.bm.relation.model.relation.GraphNode;
//import com.bm.relation.model.relation.GraphPeople;
//import com.google.common.collect.Lists;
//import org.springframework.stereotype.Service;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
///**
// * 图像化数据组装.
// *
// * @author : zyg
// * @since : 2022/07/26
// **/
//@Service
//public class GraphService {
//    private PeopleService peopleService;
//    GraphService(PeopleService peopleService){
//        this.peopleService = peopleService;
//    }
//
//    /**
//     * 基于个人id 生成关系图标
//     * 由关系类型等参数 计算 相关关联度
//     * 自身坐标为 0.0 其他基于此进行分布
//     * @param id
//     * @return
//     */
//    public Map<String,Object> graph(String id){
//        Map<String,Object> result = new HashMap<>();
//        GraphPeople graphPeople = peopleService.findRelation(id);
//        // 转换人物数据为 图标所需数据
//        List<GraphNode> nodes = Lists.newArrayList();
//        List<GraphLink> links = Lists.newArrayList();
//        // 添加自身
//        nodes.add(GraphNode.fromSelf(graphPeople.getRoot()));
//        for (People people: graphPeople.getLeaf()) {
//            nodes.add(GraphNode.from(people,graphPeople.getRoot()));
//            links.addAll(GraphLink.from(people,graphPeople.getRoot()));
//        }
//        result.put("nodes",nodes);
//        result.put("links",links);
//        result.put("categories", Lists.newArrayList(
//                new GraphCategorie("A"),
//                new GraphCategorie("B")));
//        return result;
//    }
//}
