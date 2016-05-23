/*
 * 
 *
 * 
 */
package com.sxm.florist.controller;

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
import com.sxm.florist.constants.FLORIST;
import com.sxm.florist.domain.FloristType;
import com.sxm.florist.service.FloristTypeService;

/**
 * 鲜花类型Controller.
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
@RequestMapping(value = CTL.BMS_PATH + "/florist/type")
public class BmsFloristTypeController extends BaseController<FloristType, String> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(BmsFloristTypeController.class);

	@Autowired
	private FloristTypeService floristTypeService;

	@Override
	public BaseService<FloristType, String> getService() {
		return floristTypeService;
	}

	@Override
	public Module<FloristType> getModule() {
		return new Module<FloristType>(FLORIST.PROJECT, "florist.type", CTL.BMS, FloristType.class);
	}

}
