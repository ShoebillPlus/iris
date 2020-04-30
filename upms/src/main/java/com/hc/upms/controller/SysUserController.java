package com.hc.upms.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.hc.common.core.exception.ApiException;
import com.hc.upms.entity.po.SysUser;
import com.hc.upms.service.SysUserService;
import com.hc.upms.entity.form.SysUserForm;
import com.hc.upms.entity.form.SysUserQueryForm;
import com.hc.upms.entity.param.SysUserQueryParam;
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
 * 法院人员信息表 前端控制器
 * </p>
 *
 * @author auto
 * @since 2020-04-29
 */
@RestController
 @Api(tags = "法院人员信息表")
@RequestMapping("/sysUser")
@CrossOrigin
public class SysUserController {

    private SysUserService sysUserService;

    @Autowired
    public void setSysUserService(SysUserService sysUserService) {
       this.sysUserService = sysUserService;
    }

    @ApiOperation(value = "新增法院人员信息表", notes = "新增法院人员信息表")
    @PostMapping
    public ResponseEntity<HttpStatus> add(@Validated @RequestBody SysUserForm sysUserForm) throws ApiException {
        sysUserService.add(sysUserForm.toPo(SysUser.class));
        return ResponseEntity.ok().build();
    }

    @ApiOperation(value = "删除法院人员信息表", notes = "删除法院人员信息表")
    @ApiImplicitParam(paramType = "path", name = "id", value = "编号", required = true, dataType = "long")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable String id) throws ApiException {
        sysUserService.delete(id);
        return ResponseEntity.ok().build();
    }

    @ApiOperation(value = "更新法院人员信息表", notes = "更新法院人员信息表")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "id", value = "法院人员信息表ID", required = true, dataType = "long"),
        @ApiImplicitParam(name = "sysUserForm", value = "法院人员信息表实体", required = true, dataType = "SysUserForm")
    })
    @PutMapping(value = "/{id}")
    public ResponseEntity<HttpStatus> update(@PathVariable Long id,@Validated @RequestBody SysUserForm sysUserForm) throws ApiException {
        sysUserService.refresh(sysUserForm.toPo(id,SysUser.class));
        return ResponseEntity.ok().build();
    }

    @ApiOperation(value="获取法院人员信息表", notes="获取指定法院人员信息表")
    @ApiImplicitParam(paramType = "path", name = "id", value = "法院人员信息表ID", required = true, dataType = "long")
    @GetMapping(value = "/{id}")
    public ResponseEntity<SysUser> get(@PathVariable String id) throws ApiException {
        return new ResponseEntity(sysUserService.findById(id), HttpStatus.OK);
    }

    @ApiOperation(value="获取法院人员信息", notes="获取指定法院人员信息")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "loginAccount", paramType = "query", required = true, value = "账号")
    })
    @GetMapping
    public ResponseEntity<SysUser> query(@Param("loginAccount") String loginAccount) throws ApiException {
        return new ResponseEntity(sysUserService.findByAccount(loginAccount), HttpStatus.OK);
    }

    @ApiOperation(value = "查询所有法院人员信息表", notes = "查询所有法院人员信息表")
    @ApiResponses(
        @ApiResponse(code = 200, message = "处理成功", response = JSON.class)
    )
    @GetMapping(value = "/all")
    public ResponseEntity<List<SysUser>> queryAll() throws ApiException {
        List<SysUser> sysUserList = sysUserService.list();
        return new ResponseEntity(sysUserList, HttpStatus.OK);
    }

    @ApiOperation(value = "搜索法院人员信息表(分页)", notes = "根据条件搜索法院人员信息表")
    @ApiImplicitParam(name = "sysUserQueryForm", value = "{table.comment!}查询参数", required = true, dataType = "SysUserQueryForm")
    @PostMapping("/page")
    public ResponseEntity<IPage<SysUser>> search(@Valid @RequestBody SysUserQueryForm sysUserQueryForm) throws ApiException {
        IPage<SysUser> page = sysUserService.findPage(sysUserQueryForm.getPage(),sysUserQueryForm.toParam(SysUserQueryParam.class));
        return new ResponseEntity<>(page, HttpStatus.OK);
    }
}
