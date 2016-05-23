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

import com.sxm.core.annotation.WebEnv;
import com.sxm.core.constants.CTL;
import com.sxm.core.controller.BaseController;
import com.sxm.core.dto.Module;
import com.sxm.core.service.BaseService;
import com.sxm.florist.constants.FLORIST;
import com.sxm.florist.domain.FloristOrder;
import com.sxm.florist.service.FloristOrderService;

/**
 * 订单Controller.
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
@RequestMapping(value = CTL.WEB_PATH + "/florist/order")
public class WebFloristOrderController extends BaseController<FloristOrder, String> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(WebFloristOrderController.class);

	@Autowired
	private FloristOrderService floristOrderService;

	@Override
	public BaseService<FloristOrder, String> getService() {
		return floristOrderService;
	}

	@Override
	public Module<FloristOrder> getModule() {
		return new Module<FloristOrder>(FLORIST.PROJECT, "florist.order", CTL.WEB, FloristOrder.class);
	}

}
