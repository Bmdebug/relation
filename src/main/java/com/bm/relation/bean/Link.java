package com.bm.relation.bean;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * .
 *
 * @author : zyg
 * @since : 2022/07/25
 **/
@Data
public class Link{

    @ApiModelProperty(name = "关联者ID")
    private String target;

    @ApiModelProperty(name = "关系类型")
    private String  relation;

    @ApiModelProperty(name = "关系")
    private String  describe;

}