package com.hc.upms.entity.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.hc.common.core.entity.form.BaseQueryForm;
import com.hc.upms.entity.param.SysUserRoleQueryParam;
import lombok.*;

/**
 * <p>
 * 用户和角色关系表对外查询条件
 * </p>
 *
 * @author auto
 * @since 2020-04-29
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value="SysUserRoleQueryForm", description="用户和角色关系表对外查询条件")
public class SysUserRoleQueryForm extends BaseQueryForm<SysUserRoleQueryParam> {


    @ApiModelProperty(name = "user_id", value = "用户id||bigint(20) unsigned")
    private String userId;

    @ApiModelProperty(name = "role_id", value = "角色id||bigint(20) unsigned")
    private String roleId;
    @ApiModelProperty(value = "查询开始时间")
    private String createdTimeStart;

    @ApiModelProperty(value = "查询结束时间")
    private String createdTimeEnd;


}
