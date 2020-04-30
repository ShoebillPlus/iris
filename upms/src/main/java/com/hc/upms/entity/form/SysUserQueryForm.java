package com.hc.upms.entity.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.hc.common.core.entity.form.BaseQueryForm;
import com.hc.upms.entity.param.SysUserQueryParam;
import lombok.*;

/**
 * <p>
 * 法院人员信息表对外查询条件
 * </p>
 *
 * @author auto
 * @since 2020-04-29
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value="SysUserQueryForm", description="法院人员信息表对外查询条件")
public class SysUserQueryForm extends BaseQueryForm<SysUserQueryParam> {

    @ApiModelProperty(name = "name", value = "姓名||varchar(200)")
    private String name;

    @ApiModelProperty(name = "card_id", value = "身份证号||varchar(20)")
    private String cardId;

    @ApiModelProperty(name = "phone", value = "手机号||varchar(20)")
    private String phone;

    @ApiModelProperty(name = "login_account", value = "登录账号||varchar(200)")
    private String loginAccount;

    @ApiModelProperty(value = "查询开始时间")
    private String createdTimeStart;

    @ApiModelProperty(value = "查询结束时间")
    private String createdTimeEnd;


}
