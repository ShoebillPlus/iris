package com.hc.upms.entity.form;

import com.hc.common.core.entity.form.BaseQueryForm;
import com.hc.upms.entity.param.SysParamQueryParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Past;
import java.util.Date;

/**
 * <p>
 * 系统参数
 * </p>
 *
 * @author 
 * @since 2020-04-27
 */
@Data
@ApiModel(value="SysParamQueryForm", description="系统参数")
public class SysParamQueryForm extends BaseQueryForm<SysParamQueryParam> {

    @ApiModelProperty(name = "name", value = "名称||varchar(200)")
    private String name;

    @ApiModelProperty(name = "config_key", value = "配置键||varchar(200)")
    private String configKey;

    @ApiModelProperty(name = "is_valid", value = "是否有效（0:否；1:是）")
    private String isValid;

    @ApiModelProperty(name = "remark", value = "备注")
    private String remark;

    @ApiModelProperty(value = "查询开始时间")
    private String createdTimeStart;

    @ApiModelProperty(value = "查询结束时间")
    private String createdTimeEnd;

}
