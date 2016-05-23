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
import com.sxm.sys.domain.Role;
import com.sxm.sys.service.RoleService;

/**
 * 权限管理Controller.
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
@RequestMapping(value = CTL.BMS_PATH + "/sys/role")
public class BmsRoleController extends BaseController<Role, String> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(BmsRoleController.class);

	@Autowired
	private RoleService roleService;

	@Override
	public BaseService<Role, String> getService() {
		return roleService;
	}

	@Override
	public Module<Role> getModule() {
		return new Module<Role>(SYS.PROJECT, "role", CTL.BMS, Role.class);
	}

}
