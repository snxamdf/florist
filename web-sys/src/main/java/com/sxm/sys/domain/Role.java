/*
 * 
 *
 * 
 */
package com.sxm.sys.domain;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Data;
import lombok.EqualsAndHashCode;

import com.sxm.core.domain.Sys;

/**
 * 权限管理Domain
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
@Table(name = "t_sys_role")
public class Role extends Sys<String> {

	private static final long serialVersionUID = 1L;
	private String name;
	private String genre;
	private String code;
	@Transient
	private Boolean bool;

}
