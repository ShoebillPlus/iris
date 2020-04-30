package com.hc.upms.service.impl;

import com.hc.upms.entity.po.SysUser;
import com.hc.upms.entity.param.SysUserQueryParam;
import com.hc.upms.DAO.SysUserMapper;
import com.hc.upms.service.SysUserService;
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
 * 法院人员信息表 服务实现类
 * </p>
 *
 * @author auto
 * @since 2020-04-29
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    private static final Logger logger = LoggerFactory.getLogger(SysUserServiceImpl.class);

    @Resource
    SysUserMapper sysUserMapper;

    @Override
    public IPage<SysUser> findPage(Page page, SysUserQueryParam sysUserQueryParam) throws ApiException {
        IPage<SysUser> retPage;
        try {
            QueryWrapper<SysUser> queryWrapper = sysUserQueryParam.build();
            queryWrapper.like(StringUtils.isNotBlank(sysUserQueryParam.getName()), "name", sysUserQueryParam.getName());
            queryWrapper.eq(StringUtils.isNotBlank(sysUserQueryParam.getCardId()), "card_id", sysUserQueryParam.getCardId());
            queryWrapper.eq(StringUtils.isNotBlank(sysUserQueryParam.getPhone()), "phone", sysUserQueryParam.getPhone());
            queryWrapper.eq(StringUtils.isNotBlank(sysUserQueryParam.getLoginAccount()), "login_account", sysUserQueryParam.getLoginAccount());
            retPage = this.page(page,queryWrapper);
            logger.debug("查询法院人员信息表列表成功");
        } catch (Exception e) {
            logger.error("查询法院人员信息表列表异常", e);
            e.printStackTrace();
            throw new ApiException("查询法院人员信息表列表异常", HttpStatus.BAD_REQUEST);
        }
        return retPage;
   }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void add(SysUser sysUser) throws ApiException {
        try {
            this.save(sysUser);
            logger.debug("添加法院人员信息表成功" + sysUser.getId());
        } catch (ApiException e) {
            logger.error("添加法院人员信息表错误:" + e.getMessage(), e);
            throw e;
        } catch (Exception e1) {
            logger.error("添加法院人员信息表异常", e1);
            e1.printStackTrace();
            throw new ApiException("添加法院人员信息表异常", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(String id) throws ApiException {
        try {
            this.removeById(id);
            logger.debug("删除法院人员信息表成功" + id);
        } catch (Exception e) {
            logger.error("删除法院人员信息表异常", e);
            e.printStackTrace();
            throw new ApiException("删除法院人员信息表异常", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void refresh(SysUser sysUser) throws ApiException {
        try {
            UpdateWrapper<SysUser> wrapper = new UpdateWrapper();
            wrapper.eq("id",sysUser.getId());
            this.update(sysUser,wrapper);
            logger.debug("更新法院人员信息表成功" + sysUser.getId());
        } catch (ApiException e) {
            logger.error("更新法院人员信息表错误:" + e.getMessage(), e);
            throw e;
        } catch (Exception e1) {
            logger.error("更新法院人员信息表异常", e1);
            e1.printStackTrace();
            throw new ApiException("更新法院人员信息表异常", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public SysUser findById(String id) throws ApiException {
        SysUser sysUser;
        try {
            QueryWrapper queryWrapper = new QueryWrapper();
            queryWrapper.eq("id", id);
            sysUser = sysUserMapper.selectOne(queryWrapper);
            logger.debug("根据编号查询法院人员信息表成功");
        } catch (Exception e) {
            logger.error("根据编号查询法院人员信息表异常", e);
            e.printStackTrace();
            throw new ApiException("根据编号查询法院人员信息表异常", HttpStatus.BAD_REQUEST);
        }
        return sysUser;
    }

    @Override
    public SysUser findByAccount(String account) throws ApiException {
        SysUser sysUser;
        try {
            QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("login_account",account);
            sysUser = this.getOne(queryWrapper);
            logger.debug("查询人员信息成功");
        } catch (Exception e) {
            logger.error("查询人员信息异常", e);
            e.printStackTrace();
            throw new ApiException("查询人员信息异常", HttpStatus.BAD_REQUEST);
        }
        return sysUser;
    }
}
