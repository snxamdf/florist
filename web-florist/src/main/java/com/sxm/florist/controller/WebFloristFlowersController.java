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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sxm.core.annotation.WebEnv;
import com.sxm.core.constants.CTL;
import com.sxm.core.constants.SYMBOL;
import com.sxm.core.controller.BaseController;
import com.sxm.core.dto.Module;
import com.sxm.core.service.BaseService;
import com.sxm.core.utils.Auths;
import com.sxm.florist.constants.FLORIST;
import com.sxm.florist.domain.FloristFlowers;
import com.sxm.florist.service.FloristFlowersService;

/**
 * 鲜花Controller.
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
@RequestMapping(value = CTL.WEB_PATH + "/florist/flowers")
public class WebFloristFlowersController extends BaseController<FloristFlowers, String> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(WebFloristFlowersController.class);

	@Autowired
	private FloristFlowersService floristFlowersService;

	@Override
	public BaseService<FloristFlowers, String> getService() {
		return floristFlowersService;
	}

	@Override
	public Module<FloristFlowers> getModule() {
		return new Module<FloristFlowers>(FLORIST.PROJECT, "florist.flowers", CTL.WEB, FloristFlowers.class);
	}

	@Override
	@RequestMapping("/view")
	public String view(@RequestParam(required = true) String id, Model model) {
		FloristFlowers domain = this.getService().findOne(id);
		model.addAttribute(CTL.DOMAIN, domain);
		model.addAttribute(CTL.STATE, CTL.STATE_VIEW);
		if (!Auths.isLogin()) {
			model.addAttribute("orderstates", "1");
		} else {
			model.addAttribute("orderstates", "0");
		}
		return this.getModule().getTmplName() + SYMBOL.DOT + CTL.FORM;
	}
}
