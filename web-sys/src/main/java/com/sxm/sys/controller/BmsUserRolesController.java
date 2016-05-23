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

import com.sxm.core.annotation.BmsEnv;
import com.sxm.core.constants.CTL;
import com.sxm.core.controller.BaseController;
import com.sxm.core.dto.Module;
import com.sxm.core.service.BaseService;
import com.sxm.sys.constants.SYS;
import com.sxm.sys.domain.UserRoles;
import com.sxm.sys.service.UserRolesService;

/**
 * 用户角色关系表Controller.
 * 
 * @author sxm
 * @version 2016-05-23
 * @----------------------------------------------------------------------------------------
 * @updated 修改描述.
 * @updated by sxm
 * @updated at 2016-05-23
 */
@BmsEnv
@Controller
@RequestMapping(value = CTL.BMS_PATH + "/sys/user/roles")
public class BmsUserRolesController extends BaseController<UserRoles, String> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(BmsUserRolesController.class);

	@Autowired
	private UserRolesService userRolesService;

	@Override
	public BaseService<UserRoles, String> getService() {
		return userRolesService;
	}

	@Override
	public Module<UserRoles> getModule() {
		return new Module<UserRoles>(SYS.PROJECT, "user.roles", CTL.BMS, UserRoles.class);
	}

}
