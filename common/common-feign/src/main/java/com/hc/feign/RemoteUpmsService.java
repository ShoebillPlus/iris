package com.hc.feign;

import com.hc.common.core.entity.po.SysUser;
import com.hc.common.core.exception.ApiException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author lengleng
 * @date 2018/6/22
 */
@FeignClient(contextId = "remoteUpmsService", value = "upms")
public interface RemoteUpmsService {

	/**
	 * 通过用户名查询用户、角色信息
	 *
	 * @return R
	 */
	@GetMapping("/sysUser")
	SysUser queryUserInfo(@RequestParam(required = false, name = "loginAccount") String loginAccount) throws ApiException;
}
