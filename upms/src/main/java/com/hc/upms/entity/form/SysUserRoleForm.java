package com.hc.upms.entity.form;

import com.hc.upms.entity.po.SysUserRole;
import com.hc.common.core.entity.form.BaseForm;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotBlank;

/**
 * <p>
 * 用户和角色关系表对外查询保存实体
 * </p>
 *
 * @author auto
 * @since 2020-04-29
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value="SysUserRoleForm", description="用户和角色关系表对外查询保存实体")
public class SysUserRoleForm extends BaseForm<SysUserRole> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(name = "user_id", value = "用户id||bigint(20) unsigned")
    @NotBlank(message = "user_id不能为空")
    @Length(min = 2, max = 20, message = "user_id长度在3到20个字符")
    private Long userId;

    @ApiModelProperty(name = "role_id", value = "角色id||bigint(20) unsigned")
    @NotBlank(message = "role_id不能为空")
    @Length(min = 2, max = 20, message = "role_id长度在3到20个字符")
    private Long roleId;


}
