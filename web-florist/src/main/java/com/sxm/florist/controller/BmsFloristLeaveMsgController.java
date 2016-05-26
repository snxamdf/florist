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
import com.sxm.florist.domain.FloristLeaveMsg;
import com.sxm.florist.service.FloristLeaveMsgService;

/**
 * 留言版Controller.
 * 
 * @author sxm
 * @version 2016-05-26
 * @----------------------------------------------------------------------------------------
 * @updated 修改描述.
 * @updated by sxm
 * @updated at 2016-05-26
 */
@BmsEnv
@Controller
@RequestMapping(value = CTL.BMS_PATH + "/florist/leave/msg")
public class BmsFloristLeaveMsgController extends BaseController<FloristLeaveMsg, String> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(BmsFloristLeaveMsgController.class);

	@Autowired
	private FloristLeaveMsgService floristLeaveMsgService;

	@Override
	public BaseService<FloristLeaveMsg, String> getService() {
		return floristLeaveMsgService;
	}

	@Override
	public Module<FloristLeaveMsg> getModule() {
		return new Module<FloristLeaveMsg>(FLORIST.PROJECT, "florist.leave.msg", CTL.BMS, FloristLeaveMsg.class);
	}

}
