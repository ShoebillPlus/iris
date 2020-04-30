package com.hc.auth.authorization.service;

import com.hc.common.core.entity.po.SysUser;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public interface IUserService {

    /**
     * 根据用户唯一标识获取用户信息
     *
     * @param uniqueId
     * @return
     */
    @Cacheable(value = "#id")
    SysUser getByUniqueId(String uniqueId);
}
