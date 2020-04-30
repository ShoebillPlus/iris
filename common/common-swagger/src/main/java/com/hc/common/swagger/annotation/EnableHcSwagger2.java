package com.hc.common.swagger.annotation;

import com.hc.common.swagger.config.SwaggerAutoConfiguration;
import org.springframework.context.annotation.Import;
import java.lang.annotation.*;

/**
 * @author yanwei
 * @date 2020/3/31
 * 开启pig com.hc.gateway.swagger
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import({SwaggerAutoConfiguration.class})
public @interface EnableHcSwagger2 {
}
