package com.hc.upms.entity.param;

import com.hc.common.core.entity.param.BaseParam;
import com.hc.upms.entity.po.SysParam;
import lombok.Data;

/**
 * <p>
 * 系统参数
 * </p>
 *
 * @author 
 * @since 2020-04-27
 */
@Data
public class SysParamQueryParam extends BaseParam<SysParam> {

    private String name;

    private String configKey;

    private String configValue;

    private String isValid;

    private Integer serial;

    private String remark;
}
