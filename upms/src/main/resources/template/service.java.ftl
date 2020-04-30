package ${package.Service};

import ${package.Entity}.${entity};
import ${superServiceClassPackage};
import ${package.Entity?substring(0,(package.Controller)?length-3)}param.${entity}QueryParam;
import com.hc.common.core.exception.ApiException;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
/**
 * <p>
 * ${table.comment!} 服务类
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
<#if kotlin>
interface ${table.serviceName} : ${superServiceClass}<${entity}>
<#else>
public interface ${table.serviceName} extends ${superServiceClass}<${entity}> {
      /**
       * 根据条件分页查询${table.comment!}
       *
       * @param page 分页对象
       * @return IPage<${entity}>   ${table.comment!}列表（分页）
       */
       IPage<${entity}> findPage(Page page, ${entity}QueryParam ${entity?uncap_first}QueryParam) throws ApiException;

      /**
       * 增加${table.comment!}
       *
       * @param ${entity?uncap_first} ${table.comment!}
       * @throws ApiException 异常信息
       */
      void add(${entity} ${entity?uncap_first}) throws ApiException;

      /**
      * 删除${table.comment!}
      *
      * @param id 编号
      * @throws ApiException 异常信息
      */
      void delete(String id) throws ApiException;

      /**
      * 更新${table.comment!}
      *
      * @param ${entity?uncap_first} ${table.comment!}
      * @throws ApiException 异常信息
      */
      void refresh(${entity} ${entity?uncap_first}) throws ApiException;

      /**
      * 根据编号查询${table.comment!}
      *
      * @param id 编号
      * @return ${entity} ${table.comment!}
      * @throws ApiException 异常信息
      */
      ${entity} findById(String id) throws ApiException;
}
</#if>
