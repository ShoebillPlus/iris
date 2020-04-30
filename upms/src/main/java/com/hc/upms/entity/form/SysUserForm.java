package com.hc.upms.entity.form;

import com.hc.upms.entity.po.SysUser;
import com.hc.common.core.entity.form.BaseForm;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotBlank;

/**
 * <p>
 * 法院人员信息表对外查询保存实体
 * </p>
 *
 * @author auto
 * @since 2020-04-29
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value="SysUserForm", description="法院人员信息表对外查询保存实体")
public class SysUserForm extends BaseForm<SysUser> {

    @ApiModelProperty(name = "name", value = "姓名||varchar(200)")
    @NotBlank(message = "name不能为空")
    @Length(min = 2, max = 20, message = "name长度在3到20个字符")
    private String name;

    @ApiModelProperty(name = "card_id", value = "身份证号||varchar(20)")
    @NotBlank(message = "card_id不能为空")
    @Length(min = 2, max = 20, message = "card_id长度在3到20个字符")
    private String cardId;

    @ApiModelProperty(name = "birthday", value = "生日||varchar(8)")
    @NotBlank(message = "birthday不能为空")
    @Length(min = 2, max = 20, message = "birthday长度在3到20个字符")
    private String birthday;

    @ApiModelProperty(name = "phone", value = "手机号||varchar(20)")
    @NotBlank(message = "phone不能为空")
    @Length(min = 2, max = 20, message = "phone长度在3到20个字符")
    private String phone;

    @ApiModelProperty(name = "sex", value = "性别||int(1)")
    @NotBlank(message = "sex不能为空")
    @Length(min = 2, max = 20, message = "sex长度在3到20个字符")
    private Integer sex;

    @ApiModelProperty(name = "login_account", value = "登录账号||varchar(200)")
    @NotBlank(message = "login_account不能为空")
    @Length(min = 2, max = 20, message = "login_account长度在3到20个字符")
    private String loginAccount;

    @ApiModelProperty(name = "login_pass", value = "登录密码||varchar(200)")
    @NotBlank(message = "login_pass不能为空")
    @Length(min = 2, max = 20, message = "login_pass长度在3到20个字符")
    private String loginPass;

    @ApiModelProperty(name = "is_valid", value = "是否有效（0:否；1:是）||int(1)")
    @NotBlank(message = "is_valid不能为空")
    @Length(min = 2, max = 20, message = "is_valid长度在3到20个字符")
    private Integer isValid;

    @ApiModelProperty(name = "account_non_expired", value = "过期性  1没过期0过期||int(1)")
    @NotBlank(message = "account_non_expired不能为空")
    @Length(min = 2, max = 20, message = "account_non_expired长度在3到20个字符")
    private Integer accountNonExpired;

    @ApiModelProperty(name = "credentials_non_expired", value = "有效性  1有效0失效||int(1)")
    @NotBlank(message = "credentials_non_expired不能为空")
    @Length(min = 2, max = 20, message = "credentials_non_expired长度在3到20个字符")
    private Integer credentialsNonExpired;

    @ApiModelProperty(name = "account_non_locked", value = "锁定性 1未锁定0锁定||int(1)")
    @NotBlank(message = "account_non_locked不能为空")
    @Length(min = 2, max = 20, message = "account_non_locked长度在3到20个字符")
    private Integer accountNonLocked;

    @ApiModelProperty(name = "email", value = "邮箱||varchar(200)")
    @NotBlank(message = "email不能为空")
    @Length(min = 2, max = 20, message = "email长度在3到20个字符")
    private String email;

    @ApiModelProperty(name = "remark", value = "备注||varchar(500)")
    @NotBlank(message = "remark不能为空")
    @Length(min = 2, max = 20, message = "remark长度在3到20个字符")
    private String remark;


}
