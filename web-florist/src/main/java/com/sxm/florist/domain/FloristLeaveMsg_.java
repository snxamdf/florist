/*
 * 
 *
 * 
 */
package com.sxm.florist.domain;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

/**
 * 留言版元模型类
 * 
 * @author sxm
 * @version 2016-05-26
 * @----------------------------------------------------------------------------------------
 * @updated 修改描述.
 * @updated by sxm
 * @updated at 2016-05-26
 */
@StaticMetamodel(FloristLeaveMsg.class)
public class FloristLeaveMsg_ {

	public static volatile SingularAttribute<FloristLeaveMsg, String> id;
	public static volatile SingularAttribute<FloristLeaveMsg, String> uid;
	public static volatile SingularAttribute<FloristLeaveMsg, String> msg;
	public static volatile SingularAttribute<FloristLeaveMsg, String> title;

}
