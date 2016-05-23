/*
 * 
 *
 * 
 */
package com.sxm.gen.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sxm.gen.GenApplication;
import com.sxm.core.constants.PROFILES;

/**
 * 数据库初始化测试类.
 * 
 * @author sxm
 * @version 2015-01-10
 * @----------------------------------------------------------------------------------------
 * @updated 修改描述.
 * @updated by sxm
 * @updated at 2015-01-10
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = GenApplication.class)
@ActiveProfiles({ PROFILES.COMM, PROFILES.JUNIT, PROFILES.DEV })
public class InitServiceTests {

	@Autowired
	private InitService initService;

	@Test
	@Rollback(false)
	public void testInitData() throws Exception {
		initService.initData("sys");
	}

}
