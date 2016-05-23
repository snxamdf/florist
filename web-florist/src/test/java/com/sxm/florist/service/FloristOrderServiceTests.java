/*
 * 
 *
 * 
 */
package com.sxm.florist.service;

import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sxm.core.constants.PROFILES;
import com.sxm.florist.FloristApplication;
import com.sxm.florist.domain.FloristOrder;

/**
 * 订单Service测试.
 * 禁用事务回滚使用@Rollback(false).
 * 
 * @author sxm
 * @version 2016-05-23
 * @----------------------------------------------------------------------------------------
 * @updated 修改描述.
 * @updated by sxm
 * @updated at 2016-05-23
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = FloristApplication.class)
@ActiveProfiles({ PROFILES.COMM, PROFILES.JUNIT, PROFILES.DEV })
public class FloristOrderServiceTests {

	@Autowired
	private FloristOrderService floristOrderService;

	@Test
	public void findOne() throws Exception {
		FloristOrder floristOrder = floristOrderService.findOne("1");
		assertNull(floristOrder);
	}

}
