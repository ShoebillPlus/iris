package com.hc.upms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hc.common.core.exception.ApiException;
import com.hc.upms.DAO.SysParamMapper;
import com.hc.upms.entity.param.SysParamQueryParam;
import com.hc.upms.entity.po.SysParam;
import com.hc.upms.service.SysParamService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
/**
 * <p>
 * 系统参数 服务实现类
 * </p>
 *
 * @author auto
 * @since 2020-04-27
 */
@Service
public class SysParamServiceImpl extends ServiceImpl<SysParamMapper, SysParam> implements SysParamService {

    private static final Logger logger = LoggerFactory.getLogger(SysParamServiceImpl.class);

    @Resource
    SysParamMapper sysParamMapper;

    @Override
    public IPage<SysParam> findPage(Page page, SysParamQueryParam sysParamQueryParam) throws ApiException {
        IPage<SysParam> retPage;
        try {
            QueryWrapper<SysParam> queryWrapper = sysParamQueryParam.build();
            queryWrapper.like(StringUtils.isNotBlank(sysParamQueryParam.getName()), "name", sysParamQueryParam.getName());
            queryWrapper.eq(StringUtils.isNotBlank(sysParamQueryParam.getConfigKey()), "config_key", sysParamQueryParam.getConfigKey());
            queryWrapper.eq(StringUtils.isNotBlank(sysParamQueryParam.getIsValid()),"is_valid", sysParamQueryParam.getIsValid());
            queryWrapper.eq(StringUtils.isNotBlank(sysParamQueryParam.getRemark()), "remark", sysParamQueryParam.getRemark());
            retPage = this.page(page,queryWrapper);
            logger.debug("查询系统参数列表成功");
        } catch (Exception e) {
            logger.error("查询系统参数列表异常", e);
            e.printStackTrace();
            throw new ApiException("查询系统参数列表异常", HttpStatus.BAD_REQUEST);
        }
        return retPage;
   }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean add(SysParam sysParam) throws ApiException {
        try {
            return this.save(sysParam);
        } catch (ApiException e) {
            logger.error("添加系统参数错误:" + e.getMessage(), e);
            throw e;
        } catch (Exception e1) {
            logger.error("添加系统参数异常", e1);
            e1.printStackTrace();
            throw new ApiException("添加系统参数异常", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean delete(String id) throws ApiException {
        try {
            return this.removeById(id);
        } catch (Exception e) {
            logger.error("删除系统参数异常", e);
            e.printStackTrace();
            throw new ApiException("删除系统参数异常", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean refresh(SysParam sysParam) throws ApiException {
        try {
            UpdateWrapper<SysParam> wrapper = new UpdateWrapper();
            wrapper.eq("id",sysParam.getId());
            return this.update(sysParam,wrapper);
        } catch (ApiException e) {
            logger.error("更新系统参数错误:" + e.getMessage(), e);
            throw e;
        } catch (Exception e1) {
            logger.error("更新系统参数异常", e1);
            e1.printStackTrace();
            throw new ApiException("更新系统参数异常", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public SysParam findById(String id) throws ApiException {
        SysParam sysParam;
        try {
            QueryWrapper queryWrapper = new QueryWrapper();
            queryWrapper.eq("id", id);
            sysParam = sysParamMapper.selectOne(queryWrapper);
            logger.debug("根据编号查询系统参数成功");
        } catch (Exception e) {
            logger.error("根据编号查询系统参数异常", e);
            e.printStackTrace();
            throw new ApiException("根据编号查询系统参数异常", HttpStatus.BAD_REQUEST);
        }
        return sysParam;
    }

    @Override
    public SysParam findByKey(String configKey) throws ApiException {
        SysParam sysParam;
        try {
            QueryWrapper<SysParam> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("config_key",configKey);
            sysParam = this.getOne(queryWrapper);
            logger.debug("查询系统参数成功");
        } catch (Exception e) {
            logger.error("查询系统参数异常", e);
            e.printStackTrace();
            throw new ApiException("查询系统参数异常", HttpStatus.BAD_REQUEST);
        }
        return sysParam;
    }

}
