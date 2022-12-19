package com.bm.relation.bean;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 人员地域信息.
 *
 * @author : zyg
 * @since : 2022/08/02
 **/
@Data
public class PeopleRegion {

    @ApiModelProperty(name = "国籍")
    private String nationality;

    @ApiModelProperty(name = "民族")
    private String nation;

    @ApiModelProperty(name = "户籍")
    private String censusRegister;

    @ApiModelProperty(name = "居住地")
    private String residence;
}
