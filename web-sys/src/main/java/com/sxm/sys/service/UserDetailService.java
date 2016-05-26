/*
 * 
 *
 * 
 */
package com.sxm.sys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.sxm.core.constants.PROFILES;
import com.sxm.sys.domain.Users;
import com.sxm.sys.repository.UsersRepository;

/**
 * 自定义UserDetailsService实现类.
 * 
 * @author sxm
 * @version 2014-12-12
 * @----------------------------------------------------------------------------------------
 * @updated 修改描述.
 * @updated by sxm
 * @updated at 2014-12-12
 */
@Service("userDetailsService")
public class UserDetailService implements UserDetailsService {

	@Autowired
	private Environment env;

	@Autowired
	private UsersRepository usersRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		boolean isBmsProfile = env.acceptsProfiles(PROFILES.BMS);
		Users user = usersRepository.findByLoginName(username);
		if (user == null) {
			throw new UsernameNotFoundException(String.format("User %s does not exist!", username));
		} else {
			if ("bms".equals(user.getPerm())) {
				if (!isBmsProfile) {
					throw new UsernameNotFoundException(String.format("User %s does not exist!", username));
				}
			}
			if ("web".equals(user.getPerm())) {
				if (isBmsProfile) {
					throw new UsernameNotFoundException(String.format("User %s does not exist!", username));
				}
			}
		}
		List<String> userRoles = usersRepository.findPermissionsById(user.getId());

		List<GrantedAuthority> authorities = Lists.newArrayList();
		boolean bool = false;
		for (String value : userRoles) {
			if (value.indexOf("bms") != -1 && bool == false) {
				bool = true;
			}
			authorities.add(new SimpleGrantedAuthority(value));
		}
		if (isBmsProfile && bool) {

		} else {

		}
		SecureUserDetail userDetail = new SecureUserDetail(user.getId(), user.getUname(), user.getPasswd());
		userDetail.setAuthorities(authorities);
		return userDetail;
	}
}
