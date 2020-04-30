package com.hc.auth.authorization.provider;

import com.hc.auth.authorization.entity.Role;
import com.hc.common.core.entity.po.SysUser;
import com.hc.common.core.entity.vo.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Set;

@FeignClient(name = "upms", fallback = OrganizationProviderFallback.class)
public interface OrganizationProvider {

    @GetMapping(value = "/sysUser")
    SysUser findByAccount(@RequestParam("loginAccount") String loginAccount);

    @GetMapping(value = "/sysRoles/user/{userId}")
    Set<Role> queryRolesByUserId(@PathVariable("userId") String userId);
}
