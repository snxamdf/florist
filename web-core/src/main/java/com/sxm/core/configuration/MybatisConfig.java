/*
 * 
 *
 * 
 */
package com.sxm.core.configuration;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import com.sxm.core.mapper.PaginationInterceptor;

/**
 * Mybatis配置.
 * 
 * @author sxm
 * @version 2015-01-15
 * @----------------------------------------------------------------------------------------
 * @updated 修改描述.
 * @updated by sxm
 * @updated at 2015-01-15
 */
@Configuration
@MapperScan(basePackages = "com.sxm.*.mapper")
class MybatisConfig {

	@Autowired
	private DataSource dataSource;

	@Autowired
	private PaginationInterceptor paginationInterceptor;

	@Bean
	public PaginationInterceptor paginationInterceptor() {
		return new PaginationInterceptor();
	}

	@Bean
	public SqlSessionFactory sqlSessionFactoryBean() throws Exception {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource);
		// 自动扫描domain目录, 省掉Configuration.xml里的手工配置
		sqlSessionFactoryBean.setTypeAliasesPackage("com.sxm.*.*.domain");
		// 添加分页plugin
		PaginationInterceptor plugins[] = { paginationInterceptor };
		sqlSessionFactoryBean.setPlugins(plugins);
		// 显式指定Mapper文件位置
		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:/com/sxm/*/mapper/*.xml"));
		return sqlSessionFactoryBean.getObject();
	}

}
