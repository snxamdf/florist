/* 
 * 
 *
 * 
 */
package com.sxm.gen.service;

import javax.sql.DataSource;

import org.apache.log4j.PropertyConfigurator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sxm.core.utils.Paths;
import com.sxm.core.utils.Strings;
import com.sxm.gen.utils.DbUnits;

/**
 * 初始化服务类.
 * 
 * @author sxm
 * @version 2015-01-11
 * @----------------------------------------------------------------------------------------
 * @updated 创建.
 * @updated by sxm
 * @updated at 2015-01-11
 */
@Service
@Transactional
public class InitService {

	@Autowired
	private DataSource dataSource;

	@Value("${spring.datasource.url:florist}")
	private String url;

	public String getSchema() {
		if (Strings.isBlank(url)) {
			return "florist";
		}
		String tmp = Strings.substringAfterLast(url, "/");
		return Strings.substringBefore(tmp, "?");
	}

	/**
	 * 初始化日志.
	 * 
	 * @author sxm
	 * @version 2015-01-11
	 * @----------------------------------------------------------------------------------------
	 * @updated 创建.
	 * @updated by sxm
	 * @updated at 2015-01-11
	 */
	public void initLog() {
		System.setProperty("WORKDIR", Paths.getProjectPath());
		PropertyConfigurator.configure(Paths.getProjectPathByRelative("../isy-gen/src/main/resources/logback.xml"));
	}

	/**
	 * 初始化数据库.
	 * 
	 * @author sxm
	 * @version 2015-01-11
	 * @----------------------------------------------------------------------------------------
	 * @updated 创建.
	 * @updated by sxm
	 * @updated at 2015-01-11
	 */
	public void initData(String sort) {
		try {
			String schema = getSchema();
			DbUnits.loadData(dataSource, schema, "/data.xml");
			DbUnits.loadData(dataSource, schema, "/data-" + sort + ".xml");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
