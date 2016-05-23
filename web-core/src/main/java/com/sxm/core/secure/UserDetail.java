/*
 * 
 *
 * 
 */
package com.sxm.core.secure;

import org.springframework.security.core.userdetails.UserDetails;

/**
 * 登录用户信息表.
 * 
 * @author sxm
 * @version 2015-01-12
 * @----------------------------------------------------------------------------------------
 * @updated 修改描述.
 * @updated by sxm
 * @updated at 2015-01-12
 */
public interface UserDetail extends UserDetails {

	/**
	 * 获取登录用户标识.
	 * 
	 * @return 登录用户标识
	 * @author sxm
	 * @version 2015-01-12
	 * @----------------------------------------------------------------------------------------
	 * @updated 修改描述.
	 * @updated by sxm
	 * @updated at 2015-01-12
	 */
	String getId();


}
