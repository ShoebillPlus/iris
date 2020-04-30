package com.hc.upms.entity.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.hc.common.core.entity.po.BasePo;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;
import lombok.experimental.Accessors;

/**
 * <p>
 * 角色表
 * </p>
 *
 * @author auto
 * @since 2020-04-29
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("t_sys_roles")
public class SysRoles extends BasePo {

    private static final long serialVersionUID = 1L;

    /**
     * 角色code
     */
    private String code;

    /**
     * 角色名称
     */
    private String name;

    /**
     * 简介
     */
    private String description;


}
