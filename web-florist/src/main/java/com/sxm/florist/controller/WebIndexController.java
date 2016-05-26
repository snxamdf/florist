/*
 * 
 *
 * 
 */
package com.sxm.florist.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sxm.core.annotation.WebEnv;
import com.sxm.core.constants.CTL;
import com.sxm.core.controller.BaseController;
import com.sxm.core.dto.Module;
import com.sxm.core.dto.Result;
import com.sxm.core.service.BaseService;
import com.sxm.core.utils.Auths;
import com.sxm.core.utils.Passwords;
import com.sxm.core.utils.Results;
import com.sxm.florist.constants.FLORIST;
import com.sxm.florist.domain.FloristFlowers;
import com.sxm.florist.domain.FloristType;
import com.sxm.florist.service.FloristFlowersService;
import com.sxm.florist.service.FloristTypeService;
import com.sxm.sys.domain.UserRoles;
import com.sxm.sys.domain.Users;
import com.sxm.sys.service.UserRolesService;
import com.sxm.sys.service.UsersService;

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
@RequestMapping(value = CTL.WEB_PATH + "/")
public class WebIndexController extends BaseController<FloristFlowers, String> {

	private static Logger logger = LoggerFactory.getLogger(WebIndexController.class);

	@Autowired
	private FloristFlowersService floristFlowersService;

	@Override
	public BaseService<FloristFlowers, String> getService() {
		return floristFlowersService;
	}

	@Autowired
	private FloristTypeService floristTypeService;

	@Autowired
	private UserRolesService userRolesService;

	@Autowired
	private UsersService usersService;

	@Override
	public Module<FloristFlowers> getModule() {
		return new Module<FloristFlowers>(FLORIST.PROJECT, "florist.flowers", CTL.WEB, FloristFlowers.class);
	}

	@RequestMapping(value = { "/", "/index", "/mlist","/login" })
	public String index(Model model, HttpServletRequest request, HttpServletResponse response) {
		Iterable<FloristType> iterableTypes = floristTypeService.findAll();
		model.addAttribute("types", iterableTypes);
		super.list(request, response, model);
		return "florist/index";
	}

	@ResponseBody
	@RequestMapping(value = { "/web/login" })
	public Result<String> login(String loginName, String passwd, HttpServletRequest request) {
		Result<String> result = Auths.login(loginName, passwd, request);
		if (!result.isSuccess()) {
			logger.info(result.getMessage());
			return Results.fault(0, "登录失败");
		}
		return Results.success(0, "登录成功");
	}

	@RequestMapping(value = { "/to/register" })
	public String register(Model model, HttpServletRequest request, HttpServletResponse response) {
		super.list(request, response, model);
		return "florist/register";
	}

	@ResponseBody
	@RequestMapping(value = { "/do/register" })
	public Result<String> doRegister(Users user) {
		Users usera = usersService.findByLoginName(user.getLoginName());
		if (usera != null) {
			return Results.fault(0, "用户已存在");
		}
		user.setRoleId(new String[] { "3" });
		user.setPasswd(Passwords.encrypt(user.getPasswd()));
		user.setPerm("web");
		usersService.save(user);
		UserRoles rs = new UserRoles();
		rs.setRoleId("3");// 普通用户
		rs.setUserId(user.getId());
		userRolesService.save(rs);
		return Results.success(0, "注册成功");
	}

	@RequestMapping(value = "/user/msave", method = RequestMethod.POST)
	public String save(@RequestParam(required = true) String state, Users user, BindingResult result, HttpServletRequest request, Model model, RedirectAttributes redirect) {

		user.setPasswd(Passwords.encrypt(user.getPasswd()));
		usersService.save(user);
		model.addAttribute("domain", user);
		return "florist/web.user";
	}

	@RequestMapping("/users/edit")
	public String edit(Model model) {
		if (!Auths.isLogin()) {
			return CTL.REDIRECT_PREFIX + "/";
		}
		Users domain = usersService.findOne(Auths.getUserDetail().getId());
		model.addAttribute(CTL.DOMAIN, domain);
		model.addAttribute(CTL.STATE, CTL.STATE_EDIT);
		return "florist/web.user";
	}
}
