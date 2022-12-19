package com.bm.relation.bean;

import lombok.Data;
import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
/**
 * 测试实体
 * @author : zyg
 * @since : 2022/07/19
 **/
@Data
@Document(collection = "collectionName")
public class User implements Serializable {
    @Id
    private Integer id;
    private String name;
    private String address;
    private String mobile;
    private String email;
    private Date createTime;
    private Integer role;
}