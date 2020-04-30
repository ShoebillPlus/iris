package com.hc.upms.entity.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.hc.common.core.entity.po.BasePo;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;
import lombok.experimental.Accessors;

/**
 * <p>
 * 字典
 * </p>
 *
 * @author auto
 * @since 2020-04-28
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("t_sys_dict")
public class SysDict extends BasePo {

    private static final long serialVersionUID = 1L;

    /**
     * 字典代码
     */
    private String code;

    /**
     * 字典名称
     */
    private String name;

    /**
     * 是否有效（0:否；1:是）
     */
    private Integer isValid;

    /**
     * 顺序
     */
    private Integer serial;

    /**
     * 备注
     */
    private String remark;


}
