package com.hc.upms.entity.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.hc.common.core.entity.form.BaseQueryForm;
import com.hc.upms.entity.param.SysDictQueryParam;
import lombok.*;

/**
 * <p>
 * 字典对外查询条件
 * </p>
 *
 * @author auto
 * @since 2020-04-28
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value="SysDictQueryForm", description="字典对外查询条件")
public class SysDictQueryForm extends BaseQueryForm<SysDictQueryParam> {

    @ApiModelProperty(name = "code", value = "字典代码||varchar(200)")
    private String code;

    @ApiModelProperty(name = "name", value = "字典名称||varchar(200)")
    private String name;

    @ApiModelProperty(name = "is_valid", value = "是否有效（0:否；1:是）||int(1)")
    private String isValid;

    @ApiModelProperty(name = "serial", value = "顺序||int(10)")
    private String serial;

    @ApiModelProperty(name = "remark", value = "备注||varchar(500)")
    private String remark;
    @ApiModelProperty(value = "查询开始时间")
    private String createdTimeStart;

    @ApiModelProperty(value = "查询结束时间")
    private String createdTimeEnd;


}
