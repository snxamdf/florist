/* 
 * 
 *
 * 
 */
package com.sxm.core.annotation;

import java.lang.annotation.*;

import org.springframework.stereotype.Component;

/**
 * 标识MyBatis的DAO,方便{@link org.mybatis.spring.mapper.MapperScannerConfigurer}的扫描。
 * 
 * @author sxm
 * @version 2013-05-15
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Component
public @interface Mapper {
	String value() default "";
}
