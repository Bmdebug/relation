package com.bm.relation.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Data
@Document
@ApiModel
public class People {

    @ApiModelProperty(name = "个人唯一标识")
    private String id;

    @ApiModelProperty(name = "基础信息")
    private PeopleBasicInfo basicInfo;

    @ApiModelProperty(name = "地域信息")
    private PeopleRegion region;

    @ApiModelProperty(name = "关联信息")
    private List<Link> links;

    @ApiModelProperty(name = "个人标签")
    private List<String> labels;

}