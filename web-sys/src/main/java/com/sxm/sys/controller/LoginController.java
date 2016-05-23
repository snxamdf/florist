/*
 * 
 *
 * 
 */
package com.sxm.sys.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sxm.core.annotation.BmsEnv;
import com.sxm.core.constants.CTL;
import com.sxm.core.dto.Result;
import com.sxm.core.utils.Auths;

/**
 * Controller.
 * 
 * @author sxm
 * @version 2016-05-21
 * @----------------------------------------------------------------------------------------
 * @updated 修改描述.
 * @updated by sxm
 * @updated at 2016-05-21
 */
@BmsEnv
@Controller
public class LoginController {

	private static Logger logger = LoggerFactory.getLogger(LoginController.class);

	@RequestMapping(value = { "/login", "/", "index" })
	public String login() {
		if (Auths.isLogin()) {
			return CTL.REDIRECT_PREFIX + "/florist/flowers/list";
		}
		return "sys/login";
	}

	@RequestMapping(value = "/dologin", method = RequestMethod.POST)
	public String login(String username, String password, HttpServletRequest request, Model model) {
		Result<String> result = Auths.login(username, password, request);
		if (!result.isSuccess()) {
			model.addAttribute("usernameErr", "无效的用户名或密码");
			logger.info(result.getMessage());
			return "sys/login";
		} else {
			return CTL.REDIRECT_PREFIX + "/";
		}
		// Passwords.encrypt(newPasswd)
	}

}
