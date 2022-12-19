package com.bm.relation.api;

import com.alibaba.fastjson.JSONObject;
import com.bm.relation.bean.People;
import com.bm.relation.bean.UserInfo;
import com.bm.relation.core.annotation.ApiPath;
import com.bm.relation.core.constant.ErrorCode;
import com.bm.relation.core.domain.BusinessException;
import com.bm.relation.service.PeopleService;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

@ApiPath(path = "/login")
public class LoginApi {
    private static Map<String,UserInfo> user_token = new HashMap<>();
    private final PeopleService peopleService;
    LoginApi(PeopleService peopleService){
        this.peopleService = peopleService;
    }

    @PostMapping
    @CrossOrigin
    public JSONObject login(@RequestBody UserInfo userInfo, HttpServletResponse response){
        System.out.println("调用登录接口");
        if(!existUsers(userInfo)){
            throw new BusinessException(ErrorCode.USER_LOGIN_ERROR);
        }
        String token = getUUID();
        response.setHeader("Authorization",token);
        user_token.put(token,userInfo);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("token",token);
        jsonObject.put("status",200);
        return jsonObject;
    }

    private String getUUID(){
        return UUID.randomUUID().toString().replace("-","");
    }


    @GetMapping("/user/current_user")
    @CrossOrigin
    public JSONObject getCurrentUser(HttpServletResponse response){
        String token= getHttpServletRequest().getHeader("Authorization");
        System.out.println("调用获取用户信息接口token:"+token);
        JSONObject object = new JSONObject();
        if(user_token.containsKey(token)){
            System.out.println("存在:"+token);
            object.put("code",0);
            object.put("message","存在:"+token);
            object.put("display",false);
        }else {
            System.out.println("不存在:"+token);
            object.put("code",1);
            object.put("message","用户不存在");

        }
        return object;

    }

    //获取当前登录用户的token  可以通过这个
    public static HttpServletRequest getHttpServletRequest() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }


    private static Map<String,String> users = new HashMap<>(){};
    static {
        users.put("admin","admin");
    }
    private static boolean existUsers(UserInfo userInfo){
        if(userInfo == null || !StringUtils.hasText(userInfo.getUserName()) || !StringUtils.hasText(userInfo.getPassWord())){
            return false;
        }
        return (users.containsKey(userInfo.getUserName()) && Objects.equals(users.get(userInfo.getUserName()),userInfo.getPassWord()));

    }

}