/*
 * 
 *
 * 
 */
package com.sxm.florist.domain;

import java.util.Date;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import com.sxm.sys.domain.Users;

/**
 * 订单元模型类
 * 
 * @author sxm
 * @version 2016-05-23
 * @----------------------------------------------------------------------------------------
 * @updated 修改描述.
 * @updated by sxm
 * @updated at 2016-05-23
 */
@StaticMetamodel(FloristOrder.class)
public class FloristOrder_ {

	public static volatile SingularAttribute<FloristOrder, String> id;
	public static volatile SingularAttribute<FloristOrder, String> orderNo;
	public static volatile SingularAttribute<FloristOrder, String> flowersNo;
	public static volatile SingularAttribute<FloristOrder, Integer> price;
	public static volatile SingularAttribute<FloristOrder, String> addr;
	public static volatile SingularAttribute<FloristOrder, String> uid;
	public static volatile SingularAttribute<FloristOrder, String> flowersId;
	public static volatile SingularAttribute<FloristOrder, Integer> amount;
	public static volatile SingularAttribute<FloristOrder, String> creater;
	public static volatile SingularAttribute<FloristOrder, Date> created;
	public static volatile SingularAttribute<FloristOrder, String> modifier;
	public static volatile SingularAttribute<FloristOrder, Date> modified;
	public static volatile SingularAttribute<FloristOrder, Integer> version;
	public static volatile SingularAttribute<FloristOrder, Integer> deletion;
	public static volatile SingularAttribute<FloristOrder, Integer> history;
	public static volatile SingularAttribute<FloristOrder, String> memo;
	public static volatile SingularAttribute<FloristOrder, Users> user;

}
