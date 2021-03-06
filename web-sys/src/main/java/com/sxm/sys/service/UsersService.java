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
import com.sxm.sys.domain.Users;
import com.sxm.sys.repository.UsersRepository;

/**
 * 用户表Service.
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
public class UsersService extends BaseService<Users, String> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(UsersService.class);

	@Autowired
	private UsersRepository usersRepository;

	@Override
	public BaseRepository<Users, String> getRepository() {
		return usersRepository;
	}

	public Users findByLoginName(String loginName) {
		return usersRepository.findByLoginName(loginName);
	}
}
