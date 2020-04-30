package com.hc.bgmt.controller;

import com.hc.bgmt.feign.RemoteUpmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 系统参数 前端控制器
 * </p>
 *
 * @author yanwei
 * @since 2020-03-25
 */
@RestController
@RequestMapping("/sysParam")
@CrossOrigin
public class SysParamController {

    private RemoteUpmsService remoteUpmsService;

    @Autowired
    public void setRemoteUpmsService(RemoteUpmsService remoteUpmsService) {
        this.remoteUpmsService = remoteUpmsService;
    }

    @GetMapping({"/findById"})
    public ResponseEntity<String> findById() throws Exception {
         return new ResponseEntity(remoteUpmsService.findById(), HttpStatus.OK);
    }
}
