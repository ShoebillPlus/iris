package com.hc.upms.service;

import com.hc.upms.entity.po.SysRoles;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hc.upms.entity.param.SysRolesQueryParam;
import com.hc.common.core.exception.ApiException;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;

/**
 * <p>
 * 角色表 服务类
 * </p>
 *
 * @author auto
 * @since 2020-04-29
 */
public interface SysRolesService extends IService<SysRoles> {
      /**
       * 根据条件分页查询角色表
       *
       * @param page 分页对象
       * @return IPage<SysRoles>   角色表列表（分页）
       */
       IPage<SysRoles> findPage(Page page, SysRolesQueryParam sysRolesQueryParam) throws ApiException;

      /**
       * 增加角色表
       *
       * @param sysRoles 角色表
       * @throws ApiException 异常信息
       */
      void add(SysRoles sysRoles) throws ApiException;

      /**
      * 删除角色表
      *
      * @param id 编号
      * @throws ApiException 异常信息
      */
      void delete(String id) throws ApiException;

      /**
      * 更新角色表
      *
      * @param sysRoles 角色表
      * @throws ApiException 异常信息
      */
      void refresh(SysRoles sysRoles) throws ApiException;

      /**
      * 根据编号查询角色表
      *
      * @param id 编号
      * @return SysRoles 角色表
      * @throws ApiException 异常信息
      */
      SysRoles findById(String id) throws ApiException;

      List<SysRoles> queryByUserId(String userId) throws ApiException;
}
