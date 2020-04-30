package com.hc.upms.entity.form;

import com.hc.upms.entity.po.SysResource;
import com.hc.common.core.entity.form.BaseForm;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotBlank;

/**
 * <p>
 * 资源表对外查询保存实体
 * </p>
 *
 * @author auto
 * @since 2020-04-29
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value="SysResourceForm", description="资源表对外查询保存实体")
public class SysResourceForm extends BaseForm<SysResource> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(name = "code", value = "资源code||varchar(100)")
    @NotBlank(message = "code不能为空")
    @Length(min = 2, max = 20, message = "code长度在3到20个字符")
    private String code;

    @ApiModelProperty(name = "type", value = "资源类型||varchar(100)")
    @NotBlank(message = "type不能为空")
    @Length(min = 2, max = 20, message = "type长度在3到20个字符")
    private String type;

    @ApiModelProperty(name = "name", value = "资源名称||varchar(200)")
    @NotBlank(message = "name不能为空")
    @Length(min = 2, max = 20, message = "name长度在3到20个字符")
    private String name;

    @ApiModelProperty(name = "url", value = "资源url||varchar(200)")
    @NotBlank(message = "url不能为空")
    @Length(min = 2, max = 20, message = "url长度在3到20个字符")
    private String url;

    @ApiModelProperty(name = "method", value = "资源方法||varchar(20)")
    @NotBlank(message = "method不能为空")
    @Length(min = 2, max = 20, message = "method长度在3到20个字符")
    private String method;

    @ApiModelProperty(name = "description", value = "简介||varchar(500)")
    @NotBlank(message = "description不能为空")
    @Length(min = 2, max = 20, message = "description长度在3到20个字符")
    private String description;


}
