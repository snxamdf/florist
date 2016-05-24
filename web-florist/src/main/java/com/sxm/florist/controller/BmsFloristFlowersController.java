/*
 * 
 *
 * 
 */
package com.sxm.florist.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sxm.core.annotation.BmsEnv;
import com.sxm.core.constants.CTL;
import com.sxm.core.constants.SYMBOL;
import com.sxm.core.controller.BaseController;
import com.sxm.core.dto.Module;
import com.sxm.core.service.BaseService;
import com.sxm.florist.constants.FLORIST;
import com.sxm.florist.domain.FloristFlowers;
import com.sxm.florist.repository.FloristTypeRepository;
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
@BmsEnv
@Controller
@RequestMapping(value = CTL.BMS_PATH + "/florist/flowers")
public class BmsFloristFlowersController extends BaseController<FloristFlowers, String> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(BmsFloristFlowersController.class);

	@Autowired
	private FloristFlowersService floristFlowersService;

	@Autowired
	private FloristTypeRepository floristTypeRepository;

	@Override
	public BaseService<FloristFlowers, String> getService() {
		return floristFlowersService;
	}

	@Override
	public Module<FloristFlowers> getModule() {
		return new Module<FloristFlowers>(FLORIST.PROJECT, "florist.flowers", CTL.BMS, FloristFlowers.class);
	}

	@RequestMapping("/add")
	public String add(FloristFlowers domain, HttpServletRequest request, Model model) {
		model.addAttribute(CTL.DOMAIN, domain);
		model.addAttribute(CTL.STATE, CTL.STATE_ADD);
		model.addAttribute("types", floristTypeRepository.findAll());
		return this.getModule().getTmplName() + SYMBOL.DOT + CTL.FORM;
	}

	@RequestMapping("/view")
	public String view(@RequestParam(required = true) String id, Model model) {
		FloristFlowers domain = this.getService().findOne(id);
		model.addAttribute(CTL.DOMAIN, domain);
		model.addAttribute(CTL.STATE, CTL.STATE_VIEW);
		model.addAttribute("types", floristTypeRepository.findAll());
		return this.getModule().getTmplName() + SYMBOL.DOT + CTL.FORM;
	}

	@RequestMapping("/edit")
	public String edit(@RequestParam(required = true) String id, Model model) {
		FloristFlowers domain = this.getService().findOne(id);
		model.addAttribute(CTL.DOMAIN, domain);
		model.addAttribute(CTL.STATE, CTL.STATE_EDIT);
		model.addAttribute("types", floristTypeRepository.findAll());
		return this.getModule().getTmplName() + SYMBOL.DOT + CTL.FORM;
	}
}
