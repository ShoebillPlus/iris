package ${package.ServiceImpl};

import ${package.Entity}.${entity};
import ${package.Entity?substring(0,(package.Controller)?length-3)}param.${entity}QueryParam;
import ${package.Mapper}.${table.mapperName};
import ${package.Service}.${table.serviceName};
import ${superServiceImplClassPackage};
import org.springframework.stereotype.Service;
import com.hc.common.core.exception.ApiException;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.annotation.Resource;
import org.springframework.http.HttpStatus;
import org.apache.commons.lang.StringUtils;
import org.springframework.transaction.annotation.Transactional;
/**
 * <p>
 * ${table.comment!} 服务实现类
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
@Service
<#if kotlin>
open class ${table.serviceImplName} : ${superServiceImplClass}<${table.mapperName}, ${entity}>(), ${table.serviceName} {

}
<#else>
public class ${table.serviceImplName} extends ${superServiceImplClass}<${table.mapperName}, ${entity}> implements ${table.serviceName} {

    private static final Logger logger = LoggerFactory.getLogger(${table.serviceImplName}.class);

    @Resource
    ${table.mapperName} ${table.mapperName?uncap_first};

    @Override
    public IPage<${entity}> findPage(Page page, ${entity}QueryParam ${entity?uncap_first}QueryParam) throws ApiException {
        IPage<${entity}> retPage;
        try {
            QueryWrapper<${entity}> queryWrapper = ${entity?uncap_first}QueryParam.build();
            <#list table.fields as field>
            queryWrapper.eq(StringUtils.isNotBlank(${entity?uncap_first}QueryParam.get${field.propertyName?cap_first}()), "${field.name}", ${entity?uncap_first}QueryParam.get${field.propertyName?cap_first}());
            </#list>
            retPage = this.page(page,queryWrapper);
            logger.debug("查询${table.comment!}列表成功");
        } catch (Exception e) {
            logger.error("查询${table.comment!}列表异常", e);
            e.printStackTrace();
            throw new ApiException("查询${table.comment!}列表异常", HttpStatus.BAD_REQUEST);
        }
        return retPage;
   }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void add(${entity} ${entity?uncap_first}) throws ApiException {
        try {
            this.save(${entity?uncap_first});
            logger.debug("添加${table.comment!}成功" + ${entity?uncap_first}.getId());
        } catch (ApiException e) {
            logger.error("添加${table.comment!}错误:" + e.getMessage(), e);
            throw e;
        } catch (Exception e1) {
            logger.error("添加${table.comment!}异常", e1);
            e1.printStackTrace();
            throw new ApiException("添加${table.comment!}异常", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(String id) throws ApiException {
        try {
            this.removeById(id);
            logger.debug("删除${table.comment!}成功" + id);
        } catch (Exception e) {
            logger.error("删除${table.comment!}异常", e);
            e.printStackTrace();
            throw new ApiException("删除${table.comment!}异常", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void refresh(${entity} ${entity?uncap_first}) throws ApiException {
        try {
            UpdateWrapper<${entity}> wrapper = new UpdateWrapper();
            wrapper.eq("id",${entity?uncap_first}.getId());
            this.update(${entity?uncap_first},wrapper);
            logger.debug("更新${table.comment!}成功" + ${entity?uncap_first}.getId());
        } catch (ApiException e) {
            logger.error("更新${table.comment!}错误:" + e.getMessage(), e);
            throw e;
        } catch (Exception e1) {
            logger.error("更新${table.comment!}异常", e1);
            e1.printStackTrace();
            throw new ApiException("更新${table.comment!}异常", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ${entity} findById(String id) throws ApiException {
        ${entity} ${entity?uncap_first};
        try {
            QueryWrapper queryWrapper = new QueryWrapper();
            queryWrapper.eq("id", id);
            ${entity?uncap_first} = ${table.mapperName?uncap_first}.selectOne(queryWrapper);
            logger.debug("根据编号查询${table.comment!}成功");
        } catch (Exception e) {
            logger.error("根据编号查询${table.comment!}异常", e);
            e.printStackTrace();
            throw new ApiException("根据编号查询${table.comment!}异常", HttpStatus.BAD_REQUEST);
        }
        return ${entity?uncap_first};
    }

}
</#if>
