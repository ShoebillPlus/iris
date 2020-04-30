package com.hc.upms.service.impl;

import com.hc.upms.entity.po.SysResource;
import com.hc.upms.entity.param.SysResourceQueryParam;
import com.hc.upms.DAO.SysResourceMapper;
import com.hc.upms.service.SysResourceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.hc.common.core.exception.ApiException;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.annotation.Resource;
import org.springframework.http.HttpStatus;
import org.apache.commons.lang.StringUtils;
import org.springframework.transaction.annotation.Transactional;
/**
 * <p>
 * 资源表 服务实现类
 * </p>
 *
 * @author auto
 * @since 2020-04-29
 */
@Service
public class SysResourceServiceImpl extends ServiceImpl<SysResourceMapper, SysResource> implements SysResourceService {

    private static final Logger logger = LoggerFactory.getLogger(SysResourceServiceImpl.class);

    @Resource
    SysResourceMapper sysResourceMapper;

    @Override
    public IPage<SysResource> findPage(Page page, SysResourceQueryParam sysResourceQueryParam) throws ApiException {
        IPage<SysResource> retPage;
        try {
            QueryWrapper<SysResource> queryWrapper = sysResourceQueryParam.build();
            queryWrapper.eq(StringUtils.isNotBlank(sysResourceQueryParam.getCode()), "code", sysResourceQueryParam.getCode());
            queryWrapper.eq(StringUtils.isNotBlank(sysResourceQueryParam.getType()), "type", sysResourceQueryParam.getType());
            queryWrapper.eq(StringUtils.isNotBlank(sysResourceQueryParam.getName()), "name", sysResourceQueryParam.getName());
            queryWrapper.eq(StringUtils.isNotBlank(sysResourceQueryParam.getUrl()), "url", sysResourceQueryParam.getUrl());
            queryWrapper.eq(StringUtils.isNotBlank(sysResourceQueryParam.getMethod()), "method", sysResourceQueryParam.getMethod());
            queryWrapper.eq(StringUtils.isNotBlank(sysResourceQueryParam.getDescription()), "description", sysResourceQueryParam.getDescription());
            retPage = this.page(page,queryWrapper);
            logger.debug("查询资源表列表成功");
        } catch (Exception e) {
            logger.error("查询资源表列表异常", e);
            e.printStackTrace();
            throw new ApiException("查询资源表列表异常", HttpStatus.BAD_REQUEST);
        }
        return retPage;
   }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void add(SysResource sysResource) throws ApiException {
        try {
            this.save(sysResource);
            logger.debug("添加资源表成功" + sysResource.getId());
        } catch (ApiException e) {
            logger.error("添加资源表错误:" + e.getMessage(), e);
            throw e;
        } catch (Exception e1) {
            logger.error("添加资源表异常", e1);
            e1.printStackTrace();
            throw new ApiException("添加资源表异常", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(String id) throws ApiException {
        try {
            this.removeById(id);
            logger.debug("删除资源表成功" + id);
        } catch (Exception e) {
            logger.error("删除资源表异常", e);
            e.printStackTrace();
            throw new ApiException("删除资源表异常", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void refresh(SysResource sysResource) throws ApiException {
        try {
            UpdateWrapper<SysResource> wrapper = new UpdateWrapper();
            wrapper.eq("id",sysResource.getId());
            this.update(sysResource,wrapper);
            logger.debug("更新资源表成功" + sysResource.getId());
        } catch (ApiException e) {
            logger.error("更新资源表错误:" + e.getMessage(), e);
            throw e;
        } catch (Exception e1) {
            logger.error("更新资源表异常", e1);
            e1.printStackTrace();
            throw new ApiException("更新资源表异常", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public SysResource findById(String id) throws ApiException {
        SysResource sysResource;
        try {
            QueryWrapper queryWrapper = new QueryWrapper();
            queryWrapper.eq("id", id);
            sysResource = sysResourceMapper.selectOne(queryWrapper);
            logger.debug("根据编号查询资源表成功");
        } catch (Exception e) {
            logger.error("根据编号查询资源表异常", e);
            e.printStackTrace();
            throw new ApiException("根据编号查询资源表异常", HttpStatus.BAD_REQUEST);
        }
        return sysResource;
    }

}
