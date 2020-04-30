package com.hc.bgmt.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

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
	@GetMapping("/sysParam/findById")
	String findById();
}
