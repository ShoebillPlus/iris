package com.hc.upms.entity.param;

import com.hc.upms.entity.po.SysUserRole;
import lombok.*;
import com.hc.common.core.entity.param.BaseParam;

/**
 * <p>
 * 用户和角色关系表对内查询条件
 * </p>
 *
 * @author auto
 * @since 2020-04-29
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SysUserRoleQueryParam extends BaseParam<SysUserRole> {


    private String userId;

    private String roleId;


}
