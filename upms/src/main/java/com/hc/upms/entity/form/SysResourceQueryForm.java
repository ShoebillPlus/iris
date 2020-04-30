package com.hc.upms.entity.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.hc.common.core.entity.form.BaseQueryForm;
import com.hc.upms.entity.param.SysResourceQueryParam;
import lombok.*;

/**
 * <p>
 * 资源表对外查询条件
 * </p>
 *
 * @author auto
 * @since 2020-04-29
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value="SysResourceQueryForm", description="资源表对外查询条件")
public class SysResourceQueryForm extends BaseQueryForm<SysResourceQueryParam> {


    @ApiModelProperty(name = "code", value = "资源code||varchar(100)")
    private String code;

    @ApiModelProperty(name = "type", value = "资源类型||varchar(100)")
    private String type;

    @ApiModelProperty(name = "name", value = "资源名称||varchar(200)")
    private String name;

    @ApiModelProperty(name = "url", value = "资源url||varchar(200)")
    private String url;

    @ApiModelProperty(name = "method", value = "资源方法||varchar(20)")
    private String method;

    @ApiModelProperty(name = "description", value = "简介||varchar(500)")
    private String description;
    @ApiModelProperty(value = "查询开始时间")
    private String createdTimeStart;

    @ApiModelProperty(value = "查询结束时间")
    private String createdTimeEnd;


}
