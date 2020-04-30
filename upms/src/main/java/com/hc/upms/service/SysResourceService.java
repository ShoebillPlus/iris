package com.hc.upms.service;

import com.hc.upms.entity.po.SysResource;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hc.upms.entity.param.SysResourceQueryParam;
import com.hc.common.core.exception.ApiException;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
/**
 * <p>
 * 资源表 服务类
 * </p>
 *
 * @author auto
 * @since 2020-04-29
 */
public interface SysResourceService extends IService<SysResource> {
      /**
       * 根据条件分页查询资源表
       *
       * @param page 分页对象
       * @return IPage<SysResource>   资源表列表（分页）
       */
       IPage<SysResource> findPage(Page page, SysResourceQueryParam sysResourceQueryParam) throws ApiException;

      /**
       * 增加资源表
       *
       * @param sysResource 资源表
       * @throws ApiException 异常信息
       */
      void add(SysResource sysResource) throws ApiException;

      /**
      * 删除资源表
      *
      * @param id 编号
      * @throws ApiException 异常信息
      */
      void delete(String id) throws ApiException;

      /**
      * 更新资源表
      *
      * @param sysResource 资源表
      * @throws ApiException 异常信息
      */
      void refresh(SysResource sysResource) throws ApiException;

      /**
      * 根据编号查询资源表
      *
      * @param id 编号
      * @return SysResource 资源表
      * @throws ApiException 异常信息
      */
      SysResource findById(String id) throws ApiException;
}
