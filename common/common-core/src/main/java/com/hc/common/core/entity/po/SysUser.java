package com.hc.common.core.entity.po;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 人员信息
 * </p>
 *
 * @author yanwei
 * @since 2020-03-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_sys_user")
@ApiModel(value="SysUser对象", description="人员信息")
public class SysUser extends BasePo {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(name = "name", value = "姓名")
    private String name;

    @ApiModelProperty(name = "card_id", value = "身份证号")
    private String cardId;

    @ApiModelProperty(name = "birthday", value = "生日")
    private String birthday;

    @ApiModelProperty(name = "phone", value = "手机号")
    private String phone;

    @ApiModelProperty(name = "sex", value = "性别")
    private Integer sex;

    @ApiModelProperty(name = "login_account", value = "登录账号")
    private String loginAccount;

    @ApiModelProperty(name = "login_pass", value = "登录密码")
    private String loginPass;

    @ApiModelProperty(name = "is_valid", value = "是否有效（0:否；1:是）")
    private Boolean isValid;

    @ApiModelProperty(name = "account_non_expired", value = "过期性  1没过期0过期")
    private Boolean accountNonExpired;

    @ApiModelProperty(name = "credentials_non_expired", value = "有效性  1有效0失效")
    private Boolean credentialsNonExpired;

    @ApiModelProperty(name = "account_non_locked", value = "锁定性 1未锁定0锁定")
    private Boolean accountNonLocked;

    @ApiModelProperty(name = "email", value = "邮箱")
    private String email;

}
