package com.hc.authentication.service;

import com.hc.common.core.entity.po.Resource;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Service
public interface IResourceService {

    /**
     * 动态新增更新权限
     *
     * @param resource
     */
    void saveResource(Resource resource);

    /**
     * 动态删除权限
     *
     * @param resource
     */
    void removeResource(Resource resource);

    /**
     * 加载权限资源数据
     */
    Map<RequestMatcher, ConfigAttribute> loadResource();

    /**
     * 根据url和method查询到对应的权限信息
     *
     * @param authRequest
     * @return
     */
    ConfigAttribute findConfigAttributesByUrl(HttpServletRequest authRequest);

}
