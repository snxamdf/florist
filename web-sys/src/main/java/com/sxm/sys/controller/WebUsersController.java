/*
 * 
 *
 * 
 */
package com.sxm.sys.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sxm.core.annotation.WebEnv;
import com.sxm.core.constants.CTL;
import com.sxm.core.controller.BaseController;
import com.sxm.core.dto.Module;
import com.sxm.core.service.BaseService;
import com.sxm.sys.constants.SYS;
import com.sxm.sys.domain.Users;
import com.sxm.sys.service.UsersService;

/**
 * 用户表Controller.
 * 
 * @author sxm
 * @version 2016-05-23
 * @----------------------------------------------------------------------------------------
 * @updated 修改描述.
 * @updated by sxm
 * @updated at 2016-05-23
 */
@WebEnv
@Controller
@RequestMapping(value = CTL.WEB_PATH + "/sys/users")
public class WebUsersController extends BaseController<Users, String> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(WebUsersController.class);

	@Autowired
	private UsersService usersService;

	@Override
	public BaseService<Users, String> getService() {
		return usersService;
	}

	@Override
	public Module<Users> getModule() {
		return new Module<Users>(SYS.PROJECT, "users", CTL.WEB, Users.class);
	}

}
