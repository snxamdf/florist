/*
 * 
 *
 * 
 */
package com.sxm.sys.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sxm.core.repository.BaseRepository;
import com.sxm.core.service.BaseService;
import com.sxm.sys.domain.Role;
import com.sxm.sys.repository.RoleRepository;

/**
 * 权限管理Service.
 * 
 * @author sxm
 * @version 2016-05-23
 * @----------------------------------------------------------------------------------------
 * @updated 修改描述.
 * @updated by sxm
 * @updated at 2016-05-23
 */
@Service
@Transactional
public class RoleService extends BaseService<Role, String> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(RoleService.class);

	@Autowired
	private RoleRepository roleRepository;

	@Override
	public BaseRepository<Role, String> getRepository() {
		return roleRepository;
	}

}
