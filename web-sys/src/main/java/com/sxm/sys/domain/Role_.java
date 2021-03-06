/*
 * 
 *
 * 
 */
package com.sxm.sys.domain;

import java.util.Date;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

/**
 * 权限管理元模型类
 * 
 * @author sxm
 * @version 2016-05-23
 * @----------------------------------------------------------------------------------------
 * @updated 修改描述.
 * @updated by sxm
 * @updated at 2016-05-23
 */
@StaticMetamodel(Role.class)
public class Role_ {

	public static volatile SingularAttribute<Role, String> id;
	public static volatile SingularAttribute<Role, String> name;
	public static volatile SingularAttribute<Role, String> genre;
	public static volatile SingularAttribute<Role, String> creater;
	public static volatile SingularAttribute<Role, Date> created;
	public static volatile SingularAttribute<Role, String> modifier;
	public static volatile SingularAttribute<Role, Date> modified;
	public static volatile SingularAttribute<Role, Integer> version;
	public static volatile SingularAttribute<Role, Integer> deletion;
	public static volatile SingularAttribute<Role, Integer> history;
	public static volatile SingularAttribute<Role, String> memo;
	public static volatile SingularAttribute<Role, String> code;

}
