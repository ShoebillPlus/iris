package com.hc.upms.entity.param;

import com.hc.upms.entity.po.SysUser;
import lombok.*;
import com.hc.common.core.entity.param.BaseParam;

/**
 * <p>
 * 法院人员信息表对内查询条件
 * </p>
 *
 * @author auto
 * @since 2020-04-29
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SysUserQueryParam extends BaseParam<SysUser> {

    private String name;

    private String cardId;

    private String phone;

    private String loginAccount;


}
