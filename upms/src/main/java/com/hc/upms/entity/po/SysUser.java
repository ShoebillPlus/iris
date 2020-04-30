package com.hc.upms.entity.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.hc.common.core.entity.po.BasePo;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;
import lombok.experimental.Accessors;

/**
 * <p>
 * 法院人员信息表
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
@TableName("t_sys_user")
public class SysUser extends BasePo {

    private static final long serialVersionUID = 1L;

    /**
     * 姓名
     */
    private String name;

    /**
     * 身份证号
     */
    private String cardId;

    /**
     * 生日
     */
    private String birthday;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 性别
     */
    private Integer sex;

    /**
     * 登录账号
     */
    private String loginAccount;

    /**
     * 登录密码
     */
    private String loginPass;

    /**
     * 是否有效（0:否；1:是）
     */
    private Integer isValid;

    /**
     * 过期性  1没过期0过期
     */
    private Integer accountNonExpired;

    /**
     * 有效性  1有效0失效
     */
    private Integer credentialsNonExpired;

    /**
     * 锁定性 1未锁定0锁定
     */
    private Integer accountNonLocked;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 备注
     */
    private String remark;


}
