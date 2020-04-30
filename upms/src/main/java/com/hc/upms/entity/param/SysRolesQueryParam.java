package com.hc.upms.entity.param;

import com.hc.upms.entity.po.SysRoles;
import lombok.*;
import com.hc.common.core.entity.param.BaseParam;

/**
 * <p>
 * 角色表对内查询条件
 * </p>
 *
 * @author auto
 * @since 2020-04-29
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SysRolesQueryParam extends BaseParam<SysRoles> {


    private String code;

    private String name;

    private String description;


}
