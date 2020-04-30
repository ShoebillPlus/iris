package com.hc.upms.entity.form;

import com.hc.upms.entity.po.SysRoles;
import com.hc.common.core.entity.form.BaseForm;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotBlank;

/**
 * <p>
 * 角色表对外查询保存实体
 * </p>
 *
 * @author auto
 * @since 2020-04-29
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value="SysRolesForm", description="角色表对外查询保存实体")
public class SysRolesForm extends BaseForm<SysRoles> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(name = "code", value = "角色code||varchar(100)")
    @NotBlank(message = "code不能为空")
    @Length(min = 2, max = 20, message = "code长度在3到20个字符")
    private String code;

    @ApiModelProperty(name = "name", value = "角色名称||varchar(200)")
    @NotBlank(message = "name不能为空")
    @Length(min = 2, max = 20, message = "name长度在3到20个字符")
    private String name;

    @ApiModelProperty(name = "description", value = "简介||varchar(500)")
    @NotBlank(message = "description不能为空")
    @Length(min = 2, max = 20, message = "description长度在3到20个字符")
    private String description;


}
