package com.bm.relation.bean;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * 人员基础信息.
 *
 * @author : zyg
 * @since : 2022/08/02
 **/
@Data
public class PeopleBasicInfo {

    @ApiModelProperty(name = "名称")
    private String name;

    @ApiModelProperty(name = "性别")
    private String gender;

    @ApiModelProperty(name = "出生日期")
    private Date birthDay;

    @ApiModelProperty(name = "死亡日期")
    private Date deathDate;

    @ApiModelProperty(name = "死亡日期")
    private String profession;

    @ApiModelProperty(name = "描述")
    private String describe;

    @ApiModelProperty(name = "学历")
    private String education;
}
