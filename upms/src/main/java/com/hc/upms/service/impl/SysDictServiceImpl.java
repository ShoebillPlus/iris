package com.hc.upms.service.impl;

import com.hc.upms.entity.po.SysDict;
import com.hc.upms.entity.param.SysDictQueryParam;
import com.hc.upms.DAO.SysDictMapper;
import com.hc.upms.service.SysDictService;
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
 * 字典 服务实现类
 * </p>
 *
 * @author auto
 * @since 2020-04-28
 */
@Service
public class SysDictServiceImpl extends ServiceImpl<SysDictMapper, SysDict> implements SysDictService {

    private static final Logger logger = LoggerFactory.getLogger(SysDictServiceImpl.class);

    @Resource
    SysDictMapper sysDictMapper;

    @Override
    public IPage<SysDict> findPage(Page page, SysDictQueryParam sysDictQueryParam) throws ApiException {
        IPage<SysDict> retPage;
        try {
            QueryWrapper<SysDict> queryWrapper = sysDictQueryParam.build();
            queryWrapper.eq(StringUtils.isNotBlank(sysDictQueryParam.getCode()), "code", sysDictQueryParam.getCode());
            queryWrapper.like(StringUtils.isNotBlank(sysDictQueryParam.getName()), "name", sysDictQueryParam.getName());
            queryWrapper.eq(StringUtils.isNotBlank(sysDictQueryParam.getIsValid()), "is_valid", sysDictQueryParam.getIsValid());
            queryWrapper.eq(StringUtils.isNotBlank(sysDictQueryParam.getSerial()), "serial", sysDictQueryParam.getSerial());
            queryWrapper.eq(StringUtils.isNotBlank(sysDictQueryParam.getRemark()), "remark", sysDictQueryParam.getRemark());
            retPage = this.page(page,queryWrapper);
            logger.debug("查询字典列表成功");
        } catch (Exception e) {
            logger.error("查询字典列表异常", e);
            e.printStackTrace();
            throw new ApiException("查询字典列表异常", HttpStatus.BAD_REQUEST);
        }
        return retPage;
   }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void add(SysDict sysDict) throws ApiException {
        try {
            this.save(sysDict);
            logger.debug("添加字典成功" + sysDict.getId());
        } catch (ApiException e) {
            logger.error("添加字典错误:" + e.getMessage(), e);
            throw e;
        } catch (Exception e1) {
            logger.error("添加字典异常", e1);
            e1.printStackTrace();
            throw new ApiException("添加字典异常", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(String id) throws ApiException {
        try {
            this.removeById(id);
            logger.debug("删除字典成功" + id);
        } catch (Exception e) {
            logger.error("删除字典异常", e);
            e.printStackTrace();
            throw new ApiException("删除字典异常", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void refresh(SysDict sysDict) throws ApiException {
        try {
            UpdateWrapper<SysDict> wrapper = new UpdateWrapper();
            wrapper.eq("id",sysDict.getId());
            this.update(sysDict,wrapper);
            logger.debug("更新字典成功" + sysDict.getId());
        } catch (ApiException e) {
            logger.error("更新字典错误:" + e.getMessage(), e);
            throw e;
        } catch (Exception e1) {
            logger.error("更新字典异常", e1);
            e1.printStackTrace();
            throw new ApiException("更新字典异常", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public SysDict findById(String id) throws ApiException {
        SysDict sysDict;
        try {
            QueryWrapper queryWrapper = new QueryWrapper();
            queryWrapper.eq("id", id);
            sysDict = sysDictMapper.selectOne(queryWrapper);
            logger.debug("根据编号查询字典成功");
        } catch (Exception e) {
            logger.error("根据编号查询字典异常", e);
            e.printStackTrace();
            throw new ApiException("根据编号查询字典异常", HttpStatus.BAD_REQUEST);
        }
        return sysDict;
    }

}
