/*
 * 
 *
 * 
 */
package com.sxm.gen.repository;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sxm.gen.GenApplication;
import com.sxm.gen.domain.Columns;
import com.sxm.core.constants.PROFILES;

/**
 * 列Repository测试类.
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
public class ColumnsRepositoryTests {

	@Autowired
	private ColumnsRepository columnsRepository;

	@Test
	public void testFindByTableName() throws Exception {
		List<Columns> columns = columnsRepository.findByTableName("t_sys_user");
		System.out.println(columns.size());
	}

	@Test
	public void testCountDatetime() throws Exception {
		Long count = columnsRepository.countDatetime("t_sys_user");
		System.out.println(count);
	}

	@Test
	public void testSumDatetime() throws Exception {
		Long count = columnsRepository.sumDatetime("t_sys_user");
		System.out.println(count);
	}

}
