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
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sxm.core.annotation.WebEnv;
import com.sxm.core.constants.CTL;
import com.sxm.core.constants.SYMBOL;
import com.sxm.core.dto.Module;
import com.sxm.core.dto.Result;
import com.sxm.core.service.BaseService;
import com.sxm.core.utils.Auths;
import com.sxm.core.utils.Results;
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
@WebEnv
@Controller
@RequestMapping(value = CTL.WEB_PATH + "/florist/leave/msg")
public class WebFloristLeaveMsgController {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(WebFloristLeaveMsgController.class);

	@Autowired
	private FloristLeaveMsgService floristLeaveMsgService;

	public BaseService<FloristLeaveMsg, String> getService() {
		return floristLeaveMsgService;
	}

	public Module<FloristLeaveMsg> getModule() {
		return new Module<FloristLeaveMsg>(FLORIST.PROJECT, "florist.leave.msg", CTL.WEB, FloristLeaveMsg.class);
	}

	@RequestMapping("/add")
	public String add(FloristLeaveMsg domain, HttpServletRequest request, Model model) {
		model.addAttribute(CTL.DOMAIN, domain);
		model.addAttribute(CTL.STATE, CTL.STATE_ADD);
		return this.getModule().getTmplName() + SYMBOL.DOT + CTL.FORM;
	}

	@ResponseBody
	@RequestMapping(value = "/msave", method = RequestMethod.POST)
	public Result<String> save(FloristLeaveMsg leaveMsg, BindingResult result) {
		if (result.hasErrors()) {
			return Results.fault(-1, "有错误！");
		}
		if (!Auths.isLogin()) {
			return Results.fault(-1, "留言失败，请先登录！");
		}
		leaveMsg.setUid(Auths.getUserDetail().getId());
		this.getService().save(leaveMsg);
		return Results.fault(0, "留言成功！");
	}
}
