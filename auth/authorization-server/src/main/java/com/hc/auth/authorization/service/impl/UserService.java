package com.hc.auth.authorization.service.impl;

import com.hc.auth.authorization.provider.OrganizationProvider;
import com.hc.auth.authorization.service.IUserService;
import com.hc.common.core.entity.po.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Autowired
    private OrganizationProvider organizationProvider;

    @Override
    public SysUser getByUniqueId(String uniqueId) {
        return organizationProvider.findByAccount(uniqueId);
    }
}
