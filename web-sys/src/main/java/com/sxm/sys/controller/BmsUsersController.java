/*
 * 
 *
 * 
 */
package com.sxm.sys.controller;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sxm.core.annotation.BmsEnv;
import com.sxm.core.constants.CTL;
import com.sxm.core.constants.SYMBOL;
import com.sxm.core.controller.BaseController;
import com.sxm.core.dto.Module;
import com.sxm.core.service.BaseService;
import com.sxm.core.utils.Auths;
import com.sxm.core.utils.Passwords;
import com.sxm.core.utils.Servlets;
import com.sxm.core.utils.Strings;
import com.sxm.sys.constants.SYS;
import com.sxm.sys.domain.Role;
import com.sxm.sys.domain.UserRoles;
import com.sxm.sys.domain.Users;
import com.sxm.sys.repository.RoleRepository;
import com.sxm.sys.repository.UserRolesRepository;
import com.sxm.sys.service.UsersService;

/**
 * 用户表Controller.
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
@RequestMapping(value = CTL.BMS_PATH + "/sys/users")
public class BmsUsersController extends BaseController<Users, String> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(BmsUsersController.class);

	@Autowired
	private UsersService usersService;

	@Override
	public BaseService<Users, String> getService() {
		return usersService;
	}

	@Override
	public Module<Users> getModule() {
		return new Module<Users>(SYS.PROJECT, "users", CTL.BMS, Users.class);
	}

	@Autowired
	private UserRolesRepository userRolesRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Override
	@RequestMapping("/add")
	public String add(Users domain, HttpServletRequest request, Model model) {
		model.addAttribute(CTL.DOMAIN, domain);
		model.addAttribute(CTL.STATE, CTL.STATE_ADD);
		Iterable<Role> iterable = roleRepository.findAll();

		model.addAttribute("roles", iterable);
		return this.getModule().getTmplName() + SYMBOL.DOT + CTL.FORM;
	}

	@RequestMapping("/information")
	public String Information(Model model) {
		Users domain = this.getService().findOne(Auths.getUserDetail().getId());
		model.addAttribute(CTL.DOMAIN, domain);
		model.addAttribute(CTL.STATE, CTL.STATE_VIEW);
		List<UserRoles> roles = userRolesRepository.findByUserId(Auths.getUserDetail().getId());
		System.out.println(roles);
		return this.getModule().getTmplName() + SYMBOL.DOT + CTL.FORM;
	}

	@Override
	@RequestMapping("/view")
	public String view(String id, Model model) {
		Users domain = this.getService().findOne(id);
		model.addAttribute(CTL.DOMAIN, domain);
		model.addAttribute(CTL.STATE, CTL.STATE_VIEW);
		Iterable<Role> iterable = roleRepository.findAll();
		List<UserRoles> roles = userRolesRepository.findByUserId(id);
		if (roles.size() > 0) {
			Iterator<Role> iroles = iterable.iterator();
			while (iroles.hasNext()) {
				Role role = iroles.next();
				for (int i = 0; i < roles.size(); i++) {
					if (roles.get(i).getRoleId().equals(role.getId())) {
						role.setBool(true);
						break;
					}
				}
			}
			String[] roleIds = new String[roles.size()];
			for (int i = 0; i < roles.size(); i++) {
				roleIds[i] = roles.get(i).getRoleId();
			}
			domain.setRoleId(roleIds);
		}
		model.addAttribute("roles", iterable);
		return this.getModule().getTmplName() + SYMBOL.DOT + CTL.FORM;
	}

	@Override
	@RequestMapping("/edit")
	public String edit(String id, Model model) {
		if (Strings.isBlank(id)) {
			id = Auths.getUserDetail().getId();
		}
		Users domain = this.getService().findOne(id);
		model.addAttribute(CTL.DOMAIN, domain);
		model.addAttribute(CTL.STATE, CTL.STATE_EDIT);

		Iterable<Role> iterable = roleRepository.findAll();
		List<UserRoles> roles = userRolesRepository.findByUserId(id);
		if (roles.size() > 0) {
			Iterator<Role> iroles = iterable.iterator();
			while (iroles.hasNext()) {
				Role role = iroles.next();
				for (int i = 0; i < roles.size(); i++) {
					if (roles.get(i).getRoleId().equals(role.getId())) {
						role.setBool(true);
						break;
					}
				}
			}
			String[] roleIds = new String[roles.size()];
			for (int i = 0; i < roles.size(); i++) {
				roleIds[i] = roles.get(i).getRoleId();
			}
			domain.setRoleId(roleIds);
		}
		model.addAttribute("roles", iterable);
		return this.getModule().getTmplName() + SYMBOL.DOT + CTL.FORM;
	}

	@Override
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@RequestParam(required = true) String state, @Valid @ModelAttribute(CTL.DOMAIN) Users domain, BindingResult result, HttpServletRequest request, Model model, RedirectAttributes redirect) {
		if (result.hasErrors()) {
			model.addAttribute(CTL.STATE, state);
			model.addAttribute(CTL.FORM_ERRORS, result.getAllErrors());
			return this.getModule().getTmplName() + SYMBOL.DOT + CTL.FORM;
		}
		userRolesRepository.deleteByUserId(domain.getId());
		String[] roleId = domain.getRoleId();
		if (roleId != null && roleId.length > 0) {
			for (String role : roleId) {
				UserRoles rs = new UserRoles();
				rs.setRoleId(role);
				rs.setUserId(domain.getId());
				userRolesRepository.save(rs);
			}
		}
		domain.setPasswd(Passwords.encrypt(domain.getPasswd()));
		domain.setPerm("bms");
		this.getService().save(domain);
		Map<String, Object> params = Servlets.getParametersStartsWith(request, CTL.SEARCH_PREFIX);
		redirect.addAllAttributes(params);
		redirect.addFlashAttribute(CTL.GLOBAL_MESSAGE, "信息保存成功！");
		return CTL.REDIRECT_PREFIX + this.getModule().getRequestMapping() + SYMBOL.SLANT + CTL.LIST;
	}
}
