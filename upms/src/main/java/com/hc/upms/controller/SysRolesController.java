package com.hc.upms.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.hc.common.core.exception.ApiException;
import com.hc.upms.entity.po.SysRoles;
import com.hc.upms.service.SysRolesService;
import com.hc.upms.entity.form.SysRolesForm;
import com.hc.upms.entity.form.SysRolesQueryForm;
import com.hc.upms.entity.param.SysRolesQueryParam;
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
 * 角色表 前端控制器
 * </p>
 *
 * @author auto
 * @since 2020-04-29
 */
@RestController
 @Api(tags = "角色表")
@RequestMapping("/sysRoles")
@CrossOrigin
public class SysRolesController {

    private SysRolesService sysRolesService;

    @Autowired
    public void setSysRolesService(SysRolesService sysRolesService) {
       this.sysRolesService = sysRolesService;
    }

    @ApiOperation(value = "新增角色表", notes = "新增角色表")
    @PostMapping
    public ResponseEntity<HttpStatus> add(@Validated @RequestBody SysRolesForm sysRolesForm) throws ApiException {
        sysRolesService.add(sysRolesForm.toPo(SysRoles.class));
        return ResponseEntity.ok().build();
    }

    @ApiOperation(value = "删除角色表", notes = "删除角色表")
    @ApiImplicitParam(paramType = "path", name = "id", value = "编号", required = true, dataType = "long")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable String id) throws ApiException {
        sysRolesService.delete(id);
        return ResponseEntity.ok().build();
    }

    @ApiOperation(value = "更新角色表", notes = "更新角色表")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "id", value = "角色表ID", required = true, dataType = "long"),
        @ApiImplicitParam(name = "sysRolesForm", value = "角色表实体", required = true, dataType = "SysRolesForm")
    })
    @PutMapping(value = "/{id}")
    public ResponseEntity<HttpStatus> update(@PathVariable Long id,@Validated @RequestBody SysRolesForm sysRolesForm) throws ApiException {
        sysRolesService.refresh(sysRolesForm.toPo(id,SysRoles.class));
        return ResponseEntity.ok().build();
    }

    @ApiOperation(value="获取角色表", notes="获取指定角色表")
    @ApiImplicitParam(paramType = "path", name = "id", value = "角色表ID", required = true, dataType = "long")
    @GetMapping(value = "/{id}")
    public ResponseEntity<SysRoles> get(@PathVariable String id) throws ApiException {
        return new ResponseEntity(sysRolesService.findById(id), HttpStatus.OK);
    }

    @ApiOperation(value = "查询所有角色表", notes = "查询所有角色表")
    @ApiResponses(
        @ApiResponse(code = 200, message = "处理成功", response = JSON.class)
    )
    @GetMapping(value = "/all")
    public ResponseEntity<List<SysRoles>> queryAll() throws ApiException {
        List<SysRoles> sysRolesList = sysRolesService.list();
        return new ResponseEntity(sysRolesList, HttpStatus.OK);
    }

    @ApiOperation(value = "搜索角色表(分页)", notes = "根据条件搜索角色表")
    @ApiImplicitParam(name = "sysRolesQueryForm", value = "{table.comment!}查询参数", required = true, dataType = "SysRolesQueryForm")
    @PostMapping("/page")
    public ResponseEntity<IPage<SysRoles>> search(@Valid @RequestBody SysRolesQueryForm sysRolesQueryForm) throws ApiException {
        IPage<SysRoles> page = sysRolesService.findPage(sysRolesQueryForm.getPage(),sysRolesQueryForm.toParam(SysRolesQueryParam.class));
        return new ResponseEntity<>(page, HttpStatus.OK);
    }

    @ApiOperation(value = "查询角色", notes = "根据用户id查询用户所拥有的角色信息")
    @ApiImplicitParam(paramType = "path", name = "userId", value = "用户id", required = true, dataType = "long")
    @GetMapping(value = "/user/{userId}")
    public ResponseEntity<List<SysRoles>> query(@PathVariable String userId) {
        return new ResponseEntity<>(sysRolesService.queryByUserId(userId), HttpStatus.OK);
    }
}
