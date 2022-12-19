package com.bm.relation.api;

import com.alibaba.fastjson.JSONObject;
import com.bm.relation.core.annotation.ApiPath;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 首页统计.
 *
 * @author : zyg
 * @since : 2022/09/01
 **/
@ApiPath(path = "/home")
public class HomeApi {

    @GetMapping("/statistic")
    public JSONObject login(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("user",100);
        jsonObject.put("marker",200);
        jsonObject.put("label",300);
        jsonObject.put("code",0);
        return jsonObject;
    }
}
