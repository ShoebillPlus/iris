package ${package.Controller};

import com.alibaba.fastjson.JSON;
import org.springframework.web.bind.annotation.RequestMapping;
<#if restControllerStyle>
import org.springframework.web.bind.annotation.RestController;
<#else>
import org.springframework.stereotype.Controller;
</#if>
<#if superControllerClassPackage??>
import ${superControllerClassPackage};
</#if>
import com.hc.common.core.exception.ApiException;
import ${package.Entity}.${entity};
import ${package.Service}.${table.serviceName};
import ${package.Entity?substring(0,(package.Controller)?length-3)}form.${entity}Form;
import ${package.Entity?substring(0,(package.Controller)?length-3)}form.${entity}QueryForm;
import ${package.Entity?substring(0,(package.Controller)?length-3)}param.${entity}QueryParam;
<#if swagger2>
import io.swagger.annotations.*;
</#if>
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
 * ${table.comment!} 前端控制器
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
<#if restControllerStyle>
@RestController
<#else>
@Controller
</#if>
<#if swagger2>
 @Api(tags = "${table.comment!}")
</#if>
@RequestMapping("/<#if controllerMappingHyphenStyle??>${controllerMappingHyphen}<#else>${table.entityPath}</#if>")
@CrossOrigin
<#if kotlin>
class ${table.controllerName}<#if superControllerClass??> : ${superControllerClass}()</#if>
<#else>
<#if superControllerClass??>
public class ${table.controllerName} extends ${superControllerClass} {
<#else>
public class ${table.controllerName} {
</#if>

    private ${table.serviceName} ${(table.serviceName)?uncap_first};

    @Autowired
    public void set${table.serviceName}(${table.serviceName} ${(table.serviceName)?uncap_first}) {
       this.${(table.serviceName)?uncap_first} = ${(table.serviceName)?uncap_first};
    }

    @ApiOperation(value = "新增${table.comment!}", notes = "新增${table.comment!}")
    @PostMapping
    public ResponseEntity<HttpStatus> add(@Validated @RequestBody ${entity!}Form ${entity?uncap_first}Form) throws ApiException {
        ${(table.serviceName)?uncap_first}.add(${entity?uncap_first}Form.toPo(${entity!}.class));
        return ResponseEntity.ok().build();
    }

    @ApiOperation(value = "删除${table.comment!}", notes = "删除${table.comment!}")
    @ApiImplicitParam(paramType = "path", name = "id", value = "编号", required = true, dataType = "long")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable String id) throws ApiException {
        ${(table.serviceName)?uncap_first}.delete(id);
        return ResponseEntity.ok().build();
    }

    @ApiOperation(value = "更新${table.comment!}", notes = "更新${table.comment!}")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "id", value = "${table.comment!}ID", required = true, dataType = "long"),
        @ApiImplicitParam(name = "${entity?uncap_first}Form", value = "${table.comment!}实体", required = true, dataType = "${entity!}Form")
    })
    @PutMapping(value = "/{id}")
    public ResponseEntity<HttpStatus> update(@PathVariable Long id,@Validated @RequestBody ${entity!}Form ${entity?uncap_first}Form) throws ApiException {
        ${(table.serviceName)?uncap_first}.refresh(${entity?uncap_first}Form.toPo(id,${entity!}.class));
        return ResponseEntity.ok().build();
    }

    @ApiOperation(value="获取${table.comment!}", notes="获取指定${table.comment!}")
    @ApiImplicitParam(paramType = "path", name = "id", value = "${table.comment!}ID", required = true, dataType = "long")
    @GetMapping(value = "/{id}")
    public ResponseEntity<${entity!}> get(@PathVariable String id) throws ApiException {
        return new ResponseEntity(${(table.serviceName)?uncap_first}.findById(id), HttpStatus.OK);
    }

    @ApiOperation(value = "查询所有${table.comment!}", notes = "查询所有${table.comment!}")
    @ApiResponses(
        @ApiResponse(code = 200, message = "处理成功", response = JSON.class)
    )
    @GetMapping(value = "/all")
    public ResponseEntity<List<${entity!}>> queryAll() throws ApiException {
        List<${entity!}> ${entity?uncap_first}List = ${(table.serviceName)?uncap_first}.list();
        return new ResponseEntity(${entity?uncap_first}List, HttpStatus.OK);
    }

    @ApiOperation(value = "搜索${table.comment!}(分页)", notes = "根据条件搜索${table.comment!}")
    @ApiImplicitParam(name = "${entity?uncap_first}QueryForm", value = "{table.comment!}查询参数", required = true, dataType = "${entity!}QueryForm")
    @PostMapping("/page")
    public ResponseEntity<IPage<${entity!}>> search(@Valid @RequestBody ${entity!}QueryForm ${entity?uncap_first}QueryForm) throws ApiException {
        IPage<${entity!}> page = ${(table.serviceName)?uncap_first}.findPage(${entity?uncap_first}QueryForm.getPage(),${entity?uncap_first}QueryForm.toParam(${entity!}QueryParam.class));
        return new ResponseEntity<>(page, HttpStatus.OK);
    }
}
</#if>
