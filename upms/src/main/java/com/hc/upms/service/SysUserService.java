package com.hc.upms.service;

import com.hc.upms.entity.po.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hc.upms.entity.param.SysUserQueryParam;
import com.hc.common.core.exception.ApiException;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
/**
 * <p>
 * 法院人员信息表 服务类
 * </p>
 *
 * @author auto
 * @since 2020-04-29
 */
public interface SysUserService extends IService<SysUser> {
      /**
       * 根据条件分页查询法院人员信息表
       *
       * @param page 分页对象
       * @return IPage<SysUser>   法院人员信息表列表（分页）
       */
       IPage<SysUser> findPage(Page page, SysUserQueryParam sysUserQueryParam) throws ApiException;

      /**
       * 增加法院人员信息表
       *
       * @param sysUser 法院人员信息表
       * @throws ApiException 异常信息
       */
      void add(SysUser sysUser) throws ApiException;

      /**
      * 删除法院人员信息表
      *
      * @param id 编号
      * @throws ApiException 异常信息
      */
      void delete(String id) throws ApiException;

      /**
      * 更新法院人员信息表
      *
      * @param sysUser 法院人员信息表
      * @throws ApiException 异常信息
      */
      void refresh(SysUser sysUser) throws ApiException;

      /**
      * 根据编号查询法院人员信息表
      *
      * @param id 编号
      * @return SysUser 法院人员信息表
      * @throws ApiException 异常信息
      */
      SysUser findById(String id) throws ApiException;

      /**
       * 根据账号查询用户信息
       *
       * @param account 账号
       * @return SysUser   用户信息
       */
      SysUser findByAccount(String account) throws ApiException;
}
