package com.hc.upms.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.hc.common.core.exception.ApiException;
import com.hc.upms.entity.po.SysResource;
import com.hc.upms.service.SysResourceService;
import com.hc.upms.entity.form.SysResourceForm;
import com.hc.upms.entity.form.SysResourceQueryForm;
import com.hc.upms.entity.param.SysResourceQueryParam;
import io.swagger.annotations.*;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import javax.validation.Valid;
import java.util.List;

/**
 * <p>
 * 资源表 前端控制器
 * </p>
 *
 * @author auto
 * @since 2020-04-29
 */
@RestController
 @Api(tags = "资源表")
@RequestMapping("/sysResource")
@CrossOrigin
public class SysResourceController {

    private SysResourceService sysResourceService;

    @Autowired
    public void setSysResourceService(SysResourceService sysResourceService) {
       this.sysResourceService = sysResourceService;
    }

    @ApiOperation(value = "新增资源表", notes = "新增资源表")
    @PostMapping
    public ResponseEntity<HttpStatus> add(@Validated @RequestBody SysResourceForm sysResourceForm) throws ApiException {
        sysResourceService.add(sysResourceForm.toPo(SysResource.class));
        return ResponseEntity.ok().build();
    }

    @ApiOperation(value = "删除资源表", notes = "删除资源表")
    @ApiImplicitParam(paramType = "path", name = "id", value = "编号", required = true, dataType = "long")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable String id) throws ApiException {
        sysResourceService.delete(id);
        return ResponseEntity.ok().build();
    }

    @ApiOperation(value = "更新资源表", notes = "更新资源表")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "id", value = "资源表ID", required = true, dataType = "long"),
        @ApiImplicitParam(name = "sysResourceForm", value = "资源表实体", required = true, dataType = "SysResourceForm")
    })
    @PutMapping(value = "/{id}")
    public ResponseEntity<HttpStatus> update(@PathVariable Long id,@Validated @RequestBody SysResourceForm sysResourceForm) throws ApiException {
        sysResourceService.refresh(sysResourceForm.toPo(id,SysResource.class));
        return ResponseEntity.ok().build();
    }

    @ApiOperation(value="获取资源表", notes="获取指定资源表")
    @ApiImplicitParam(paramType = "path", name = "id", value = "资源表ID", required = true, dataType = "long")
    @GetMapping(value = "/{id}")
    public ResponseEntity<SysResource> get(@PathVariable String id) throws ApiException {
        return new ResponseEntity(sysResourceService.findById(id), HttpStatus.OK);
    }

    @ApiOperation(value = "查询所有资源表", notes = "查询所有资源表")
    @ApiResponses(
        @ApiResponse(code = 200, message = "处理成功", response = JSON.class)
    )
    @GetMapping(value = "/all")
    public ResponseEntity<List<SysResource>> queryAll() throws ApiException {
        List<SysResource> sysResourceList = sysResourceService.list();
        return new ResponseEntity(sysResourceList, HttpStatus.OK);
    }

    @ApiOperation(value = "搜索资源表(分页)", notes = "根据条件搜索资源表")
    @ApiImplicitParam(name = "sysResourceQueryForm", value = "{table.comment!}查询参数", required = true, dataType = "SysResourceQueryForm")
    @PostMapping("/page")
    public ResponseEntity<IPage<SysResource>> search(@Valid @RequestBody SysResourceQueryForm sysResourceQueryForm) throws ApiException {
        IPage<SysResource> page = sysResourceService.findPage(sysResourceQueryForm.getPage(),sysResourceQueryForm.toParam(SysResourceQueryParam.class));
        return new ResponseEntity<>(page, HttpStatus.OK);
    }
}
