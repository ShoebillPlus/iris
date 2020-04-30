package com.hc.upms.entity.param;

import com.hc.upms.entity.po.SysDict;
import lombok.*;
import com.hc.common.core.entity.param.BaseParam;

/**
 * <p>
 * 字典对内查询条件
 * </p>
 *
 * @author auto
 * @since 2020-04-28
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SysDictQueryParam extends BaseParam<SysDict> {

    private String code;

    private String name;

    private String isValid;

    private String serial;

    private String remark;


}
