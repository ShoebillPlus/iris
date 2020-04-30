package com.hc.auth.authorization.provider;

import com.hc.auth.authorization.entity.Role;
import com.hc.common.core.entity.po.SysUser;
import com.hc.common.core.entity.vo.Result;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class OrganizationProviderFallback implements OrganizationProvider {

    @Override
    public SysUser findByAccount(String uniqueId) {
        return new SysUser();
    }

    @Override
    public Set<Role> queryRolesByUserId(String userId) {
        return new HashSet<Role>();
    }
}
