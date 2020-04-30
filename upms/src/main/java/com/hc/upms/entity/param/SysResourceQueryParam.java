package com.hc.upms.entity.param;

import com.hc.upms.entity.po.SysResource;
import lombok.*;
import com.hc.common.core.entity.param.BaseParam;

/**
 * <p>
 * 资源表对内查询条件
 * </p>
 *
 * @author auto
 * @since 2020-04-29
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SysResourceQueryParam extends BaseParam<SysResource> {


    private String code;

    private String type;

    private String name;

    private String url;

    private String method;

    private String description;


}
