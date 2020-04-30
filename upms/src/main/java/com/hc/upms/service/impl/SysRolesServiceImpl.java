package com.hc.upms.service.impl;

import com.hc.upms.entity.po.SysRoles;
import com.hc.upms.entity.param.SysRolesQueryParam;
import com.hc.upms.DAO.SysRolesMapper;
import com.hc.upms.service.SysRolesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hc.upms.service.SysUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
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
 * 角色表 服务实现类
 * </p>
 *
 * @author auto
 * @since 2020-04-29
 */
@Service
public class SysRolesServiceImpl extends ServiceImpl<SysRolesMapper, SysRoles> implements SysRolesService {

    private static final Logger logger = LoggerFactory.getLogger(SysRolesServiceImpl.class);

    @Resource
    SysRolesMapper sysRolesMapper;

    private SysUserRoleService sysUserRoleService;

    @Autowired
    public void setSysUserRoleService(SysUserRoleService sysUserRoleService) {
        this.sysUserRoleService = sysUserRoleService;
    }


    @Override
    public IPage<SysRoles> findPage(Page page, SysRolesQueryParam sysRolesQueryParam) throws ApiException {
        IPage<SysRoles> retPage;
        try {
            QueryWrapper<SysRoles> queryWrapper = sysRolesQueryParam.build();
            queryWrapper.eq(StringUtils.isNotBlank(sysRolesQueryParam.getCode()), "code", sysRolesQueryParam.getCode());
            queryWrapper.eq(StringUtils.isNotBlank(sysRolesQueryParam.getName()), "name", sysRolesQueryParam.getName());
            queryWrapper.eq(StringUtils.isNotBlank(sysRolesQueryParam.getDescription()), "description", sysRolesQueryParam.getDescription());
            retPage = this.page(page,queryWrapper);
            logger.debug("查询角色表列表成功");
        } catch (Exception e) {
            logger.error("查询角色表列表异常", e);
            e.printStackTrace();
            throw new ApiException("查询角色表列表异常", HttpStatus.BAD_REQUEST);
        }
        return retPage;
   }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void add(SysRoles sysRoles) throws ApiException {
        try {
            this.save(sysRoles);
            logger.debug("添加角色表成功" + sysRoles.getId());
        } catch (ApiException e) {
            logger.error("添加角色表错误:" + e.getMessage(), e);
            throw e;
        } catch (Exception e1) {
            logger.error("添加角色表异常", e1);
            e1.printStackTrace();
            throw new ApiException("添加角色表异常", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(String id) throws ApiException {
        try {
            this.removeById(id);
            logger.debug("删除角色表成功" + id);
        } catch (Exception e) {
            logger.error("删除角色表异常", e);
            e.printStackTrace();
            throw new ApiException("删除角色表异常", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void refresh(SysRoles sysRoles) throws ApiException {
        try {
            UpdateWrapper<SysRoles> wrapper = new UpdateWrapper();
            wrapper.eq("id",sysRoles.getId());
            this.update(sysRoles,wrapper);
            logger.debug("更新角色表成功" + sysRoles.getId());
        } catch (ApiException e) {
            logger.error("更新角色表错误:" + e.getMessage(), e);
            throw e;
        } catch (Exception e1) {
            logger.error("更新角色表异常", e1);
            e1.printStackTrace();
            throw new ApiException("更新角色表异常", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public SysRoles findById(String id) throws ApiException {
        SysRoles sysRoles;
        try {
            QueryWrapper queryWrapper = new QueryWrapper();
            queryWrapper.eq("id", id);
            sysRoles = sysRolesMapper.selectOne(queryWrapper);
            logger.debug("根据编号查询角色表成功");
        } catch (Exception e) {
            logger.error("根据编号查询角色表异常", e);
            e.printStackTrace();
            throw new ApiException("根据编号查询角色表异常", HttpStatus.BAD_REQUEST);
        }
        return sysRoles;
    }

    @Override
    public List<SysRoles> queryByUserId(String userId)  throws ApiException {
        Set<Long> roleIds = sysUserRoleService.queryByUserId(userId);
        return (List<SysRoles>) this.listByIds(roleIds);
    }

}
