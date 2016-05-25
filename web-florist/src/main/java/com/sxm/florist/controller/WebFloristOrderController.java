/*
 * 
 *
 * 
 */
package com.sxm.florist.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sxm.core.annotation.WebEnv;
import com.sxm.core.constants.CTL;
import com.sxm.core.constants.SYMBOL;
import com.sxm.core.controller.BaseController;
import com.sxm.core.domain.Sys;
import com.sxm.core.dto.Module;
import com.sxm.core.search.Filter;
import com.sxm.core.service.BaseService;
import com.sxm.core.utils.Auths;
import com.sxm.core.utils.Pageables;
import com.sxm.core.utils.Pages;
import com.sxm.core.utils.Servlets;
import com.sxm.core.utils.Sorts;
import com.sxm.core.utils.Specifications;
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

	@Override
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@RequestParam(required = true) String state, @Valid @ModelAttribute(CTL.DOMAIN) FloristOrder domain, BindingResult result, HttpServletRequest request, Model model, RedirectAttributes redirect) {
		if (result.hasErrors()) {
			model.addAttribute(CTL.STATE, state);
			model.addAttribute(CTL.FORM_ERRORS, result.getAllErrors());
			return this.getModule().getTmplName() + SYMBOL.DOT + CTL.FORM;
		}
		if (!Auths.isLogin()) {
			return CTL.REDIRECT_PREFIX + "/";
		}
		domain.setUid(Auths.getUserDetail().getId());
		int orderNo = (int) (Math.random() * 1000000);
		domain.setOrderNo(String.valueOf(orderNo));
		this.getService().save(domain);
		Map<String, Object> params = Servlets.getParametersStartsWith(request, CTL.SEARCH_PREFIX);
		redirect.addAllAttributes(params);
		redirect.addFlashAttribute(CTL.GLOBAL_MESSAGE, "信息保存成功！");
		model.addAttribute("orderstates", "3");
		model.addAttribute("order", domain);
		return "florist/web.florist.flowers.form";
	}

	@Override
	@RequestMapping("/list")
	public String list(HttpServletRequest request, HttpServletResponse response, Model model) {
		Map<String, Object> params = Servlets.getParametersStartingWith(request, CTL.SEARCH_PREFIX);
		if (!params.containsKey(Filter.DELETION)) { // 如果没有指定查询逻辑删除条件：默认查询未逻辑删除的数据
			params.put(Filter.DELETION, String.valueOf(Sys.DELETION_NO));
		}
		if (!Auths.isLogin()) {
			return CTL.REDIRECT_PREFIX + "/";
		}
		params.put("EQ_uid", Auths.getUserDetail().getId());
		Sort sort = Sorts.byMap(params);
		Pageable pageable = Pageables.Build(request, response, sort);
		Page<FloristOrder> page = this.getService().findAll(Specifications.byMap(this.getModule().getEntityClass(), params), pageable);
		model.addAttribute(CTL.PAGE, page);
		model.addAttribute(CTL.PAGINATION, Pages.toHtml(page));
		return this.getModule().getTmplName() + SYMBOL.DOT + CTL.LIST;
	}
}
