/*
 * 
 *
 * 
 */
package com.sxm.sys.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

import com.sxm.core.domain.Sys;

/**
 * 用户角色关系表Domain
 * 
 * @author sxm
 * @version 2016-05-23
 * @----------------------------------------------------------------------------------------
 * @updated 修改描述.
 * @updated by sxm
 * @updated at 2016-05-23
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "t_sys_user_roles")
public class UserRoles extends Sys<String> {

	private static final long serialVersionUID = 1L;
	private String userId;
	private String roleId;

}
