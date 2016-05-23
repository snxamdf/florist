/*
 * 
 *
 * 
 */
package com.sxm.florist.domain;

import java.util.Date;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

/**
 * 鲜花类型元模型类
 * 
 * @author sxm
 * @version 2016-05-23
 * @----------------------------------------------------------------------------------------
 * @updated 修改描述.
 * @updated by sxm
 * @updated at 2016-05-23
 */
@StaticMetamodel(FloristType.class)
public class FloristType_ {

	public static volatile SingularAttribute<FloristType, String> id;
	public static volatile SingularAttribute<FloristType, String> name;
	public static volatile SingularAttribute<FloristType, String> creater;
	public static volatile SingularAttribute<FloristType, Date> created;
	public static volatile SingularAttribute<FloristType, String> modifier;
	public static volatile SingularAttribute<FloristType, Date> modified;
	public static volatile SingularAttribute<FloristType, Integer> version;
	public static volatile SingularAttribute<FloristType, Integer> deletion;
	public static volatile SingularAttribute<FloristType, Integer> history;
	public static volatile SingularAttribute<FloristType, String> memo;

}
