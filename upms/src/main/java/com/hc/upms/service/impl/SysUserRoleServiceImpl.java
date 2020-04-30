package com.hc.upms.service.impl;

import com.hc.upms.entity.po.SysUserRole;
import com.hc.upms.entity.param.SysUserRoleQueryParam;
import com.hc.upms.DAO.SysUserRoleMapper;
import com.hc.upms.service.SysUserRoleService;
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

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * <p>
 * 用户和角色关系表 服务实现类
 * </p>
 *
 * @author auto
 * @since 2020-04-29
 */
@Service
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleMapper, SysUserRole> implements SysUserRoleService {

    private static final Logger logger = LoggerFactory.getLogger(SysUserRoleServiceImpl.class);

    @Resource
    SysUserRoleMapper sysUserRoleMapper;

    @Override
    public IPage<SysUserRole> findPage(Page page, SysUserRoleQueryParam sysUserRoleQueryParam) throws ApiException {
        IPage<SysUserRole> retPage;
        try {
            QueryWrapper<SysUserRole> queryWrapper = sysUserRoleQueryParam.build();
            queryWrapper.eq(StringUtils.isNotBlank(sysUserRoleQueryParam.getUserId()), "user_id", sysUserRoleQueryParam.getUserId());
            queryWrapper.eq(StringUtils.isNotBlank(sysUserRoleQueryParam.getRoleId()), "role_id", sysUserRoleQueryParam.getRoleId());
            retPage = this.page(page,queryWrapper);
            logger.debug("查询用户和角色关系表列表成功");
        } catch (Exception e) {
            logger.error("查询用户和角色关系表列表异常", e);
            e.printStackTrace();
            throw new ApiException("查询用户和角色关系表列表异常", HttpStatus.BAD_REQUEST);
        }
        return retPage;
   }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void add(SysUserRole sysUserRole) throws ApiException {
        try {
            this.save(sysUserRole);
            logger.debug("添加用户和角色关系表成功" + sysUserRole.getId());
        } catch (ApiException e) {
            logger.error("添加用户和角色关系表错误:" + e.getMessage(), e);
            throw e;
        } catch (Exception e1) {
            logger.error("添加用户和角色关系表异常", e1);
            e1.printStackTrace();
            throw new ApiException("添加用户和角色关系表异常", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(String id) throws ApiException {
        try {
            this.removeById(id);
            logger.debug("删除用户和角色关系表成功" + id);
        } catch (Exception e) {
            logger.error("删除用户和角色关系表异常", e);
            e.printStackTrace();
            throw new ApiException("删除用户和角色关系表异常", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void refresh(SysUserRole sysUserRole) throws ApiException {
        try {
            UpdateWrapper<SysUserRole> wrapper = new UpdateWrapper();
            wrapper.eq("id",sysUserRole.getId());
            this.update(sysUserRole,wrapper);
            logger.debug("更新用户和角色关系表成功" + sysUserRole.getId());
        } catch (ApiException e) {
            logger.error("更新用户和角色关系表错误:" + e.getMessage(), e);
            throw e;
        } catch (Exception e1) {
            logger.error("更新用户和角色关系表异常", e1);
            e1.printStackTrace();
            throw new ApiException("更新用户和角色关系表异常", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public SysUserRole findById(String id) throws ApiException {
        SysUserRole sysUserRole;
        try {
            QueryWrapper queryWrapper = new QueryWrapper();
            queryWrapper.eq("id", id);
            sysUserRole = sysUserRoleMapper.selectOne(queryWrapper);
            logger.debug("根据编号查询用户和角色关系表成功");
        } catch (Exception e) {
            logger.error("根据编号查询用户和角色关系表异常", e);
            e.printStackTrace();
            throw new ApiException("根据编号查询用户和角色关系表异常", HttpStatus.BAD_REQUEST);
        }
        return sysUserRole;
    }

    @Override
    public Set<Long> queryByUserId(String userId) {
        QueryWrapper<SysUserRole> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId);
        List<SysUserRole> userRoleList = list(queryWrapper);
        return userRoleList.stream().map(SysUserRole::getRoleId).collect(Collectors.toSet());
    }

}
