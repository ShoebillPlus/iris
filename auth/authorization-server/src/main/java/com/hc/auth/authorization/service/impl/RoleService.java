package com.hc.auth.authorization.service.impl;

import com.hc.auth.authorization.provider.OrganizationProvider;
import com.hc.auth.authorization.entity.Role;
import com.hc.auth.authorization.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class RoleService implements IRoleService {

    @Autowired
    private OrganizationProvider organizationProvider;

    @Override
    public Set<Role> queryUserRolesByUserId(String userId) {
        return organizationProvider.queryRolesByUserId(userId);
    }

}
