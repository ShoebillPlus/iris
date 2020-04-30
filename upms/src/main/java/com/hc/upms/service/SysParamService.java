package com.hc.upms.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hc.common.core.exception.ApiException;
import com.hc.upms.entity.param.SysParamQueryParam;
import com.hc.upms.entity.po.SysParam;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;
/**
 * <p>
 * 系统参数 服务类
 * </p>
 *
 * @author auto
 * @since 2020-04-27
 */
public interface SysParamService extends IService<SysParam> {
      /**
       * 根据条件分页查询系统参数
       *
       * @return IPage<SysParam>   系统参数列表（分页）
       */
       IPage<SysParam> findPage(Page page, SysParamQueryParam sysParamQueryParam) throws ApiException;

      /**
       * 增加系统参数
       *
       * @param sysParam 系统参数
       * @throws ApiException 异常信息
       */
      boolean add(SysParam sysParam) throws ApiException;

      /**
      * 删除系统参数
      *
      * @param id 编号
      * @throws ApiException 异常信息
      */
      boolean delete(String id) throws ApiException;

      /**
      * 更新系统参数
      *
      * @param sysParam 系统参数
      * @throws ApiException 异常信息
      */
      boolean refresh(SysParam sysParam) throws ApiException;

      /**
      * 根据编号查询系统参数
      *
      * @param id 编号
      * @return SysParam 系统参数
      * @throws ApiException 异常信息
      */
      SysParam findById(String id) throws ApiException;

      /**
       * 根据配置键查询系统参数
       *
       * @param configKey 配置键
       * @return SysParam   系统参数
       */
      SysParam findByKey(String configKey) throws ApiException;
}
