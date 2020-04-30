package com.hc.upms.service;

import com.hc.upms.entity.po.SysUserRole;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hc.upms.entity.param.SysUserRoleQueryParam;
import com.hc.common.core.exception.ApiException;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.Set;

/**
 * <p>
 * 用户和角色关系表 服务类
 * </p>
 *
 * @author auto
 * @since 2020-04-29
 */
public interface SysUserRoleService extends IService<SysUserRole> {
      /**
       * 根据条件分页查询用户和角色关系表
       *
       * @param page 分页对象
       * @return IPage<SysUserRole>   用户和角色关系表列表（分页）
       */
       IPage<SysUserRole> findPage(Page page, SysUserRoleQueryParam sysUserRoleQueryParam) throws ApiException;

      /**
       * 增加用户和角色关系表
       *
       * @param sysUserRole 用户和角色关系表
       * @throws ApiException 异常信息
       */
      void add(SysUserRole sysUserRole) throws ApiException;

      /**
      * 删除用户和角色关系表
      *
      * @param id 编号
      * @throws ApiException 异常信息
      */
      void delete(String id) throws ApiException;

      /**
      * 更新用户和角色关系表
      *
      * @param sysUserRole 用户和角色关系表
      * @throws ApiException 异常信息
      */
      void refresh(SysUserRole sysUserRole) throws ApiException;

      /**
      * 根据编号查询用户和角色关系表
      *
      * @param id 编号
      * @return SysUserRole 用户和角色关系表
      * @throws ApiException 异常信息
      */
      SysUserRole findById(String id) throws ApiException;

      Set<Long> queryByUserId(String userId);
}
