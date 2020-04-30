package com.hc.upms.controller;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hc.common.core.exception.ApiException;
import com.hc.upms.entity.form.SysParamForm;
import com.hc.upms.entity.form.SysParamQueryForm;
import com.hc.upms.entity.param.SysParamQueryParam;
import com.hc.upms.entity.po.SysParam;
import com.hc.upms.service.SysParamService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

/**
 * <p>
 * 系统参数 前端控制器
 * </p>
 *
 * @author 
 * @since 2020-04-27
 */
@RestController
 @Api(tags = "系统参数")
@RequestMapping("/sysParams")
@CrossOrigin
public class SysParamController {

    private SysParamService sysParamService;

    @Autowired
    public void setSysParamService(SysParamService sysParamService) {
       this.sysParamService = sysParamService;
    }

    @ApiOperation(value = "新增系统参数", notes = "新增系统参数")
    @PostMapping
    public ResponseEntity<HttpStatus> add(@Validated @RequestBody SysParamForm sysParamForm) throws ApiException {
        sysParamService.add(sysParamForm.toPo(SysParam.class));
        return ResponseEntity.ok().build();
    }

    @ApiOperation(value = "删除系统参数", notes = "删除系统参数")
    @ApiImplicitParam(paramType = "path", name = "id", value = "编号", required = true, dataType = "long")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable String id) throws ApiException {
        sysParamService.delete(id);
        return ResponseEntity.ok().build();
    }

    @ApiOperation(value = "更新系统参数", notes = "更新系统参数")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "系统参数ID", required = true, dataType = "long"),
            @ApiImplicitParam(name = "sysParamForm", value = "系统参数实体", required = true, dataType = "SysParamForm")
    })
    @PutMapping(value = "/{id}")
    public ResponseEntity<HttpStatus> update(@PathVariable Long id,@Validated @RequestBody SysParamForm sysParamForm) throws ApiException {
        sysParamService.refresh(sysParamForm.toPo(id,SysParam.class));
        return ResponseEntity.ok().build();
    }

    @ApiOperation(value="获取系统参数", notes="获取指定系统参数")
    @ApiImplicitParam(paramType = "path", name = "id", value = "系统参数ID", required = true, dataType = "long")
    @GetMapping(value = "/{id}")
    public ResponseEntity<SysParam> get(@PathVariable String id) throws ApiException {
        SysParam sysParam = sysParamService.findById(id);
        return new ResponseEntity(sysParam, HttpStatus.OK);
    }

    @ApiOperation(value = "查询所有系统参数", notes = "查询所有系统参数")
    @ApiResponses(
            @ApiResponse(code = 200, message = "处理成功", response = JSON.class)
    )
    @GetMapping(value = "/all")
    public ResponseEntity<List<SysParam>> queryAll() throws ApiException {
        List<SysParam> sysParamList = sysParamService.list();
        return new ResponseEntity(sysParamList, HttpStatus.OK);
    }

    @ApiOperation(value = "搜索系统参数(分页)", notes = "根据条件搜索系统参数")
    @ApiImplicitParam(name = "sysParamQueryForm", value = "系统参数查询参数", required = true, dataType = "SysParamQueryForm")
    @PostMapping(value = "/page")
    public ResponseEntity<IPage<SysParam>> search(@Valid @RequestBody SysParamQueryForm sysParamQueryForm) {
        IPage<SysParam> page = sysParamService.findPage(sysParamQueryForm.getPage(),sysParamQueryForm.toParam(SysParamQueryParam.class));
        return new ResponseEntity<>(page, HttpStatus.OK);
    }

    @ApiOperation(value = "查询系统参数", notes = "根据条件查询系统参数信息，简单查询")
    @ApiImplicitParam(paramType = "query", name = "configKey", value = "配置键", required = true, dataType = "string")
    @GetMapping
    public ResponseEntity<SysParam> query(@RequestParam String configKey) throws ApiException {
        SysParam sysParam = sysParamService.findByKey(configKey);
        return new ResponseEntity(sysParam, HttpStatus.OK);
    }
}
