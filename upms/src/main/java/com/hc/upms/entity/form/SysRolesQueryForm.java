package com.hc.upms.entity.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.hc.common.core.entity.form.BaseQueryForm;
import com.hc.upms.entity.param.SysRolesQueryParam;
import lombok.*;

/**
 * <p>
 * 角色表对外查询条件
 * </p>
 *
 * @author auto
 * @since 2020-04-29
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value="SysRolesQueryForm", description="角色表对外查询条件")
public class SysRolesQueryForm extends BaseQueryForm<SysRolesQueryParam> {


    @ApiModelProperty(name = "code", value = "角色code||varchar(100)")
    private String code;

    @ApiModelProperty(name = "name", value = "角色名称||varchar(200)")
    private String name;

    @ApiModelProperty(name = "description", value = "简介||varchar(500)")
    private String description;
    @ApiModelProperty(value = "查询开始时间")
    private String createdTimeStart;

    @ApiModelProperty(value = "查询结束时间")
    private String createdTimeEnd;


}
