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
 * 鲜花元模型类
 * 
 * @author sxm
 * @version 2016-05-23
 * @----------------------------------------------------------------------------------------
 * @updated 修改描述.
 * @updated by sxm
 * @updated at 2016-05-23
 */
@StaticMetamodel(FloristFlowers.class)
public class FloristFlowers_ {

	public static volatile SingularAttribute<FloristFlowers, String> id;
	public static volatile SingularAttribute<FloristFlowers, String> name;
	public static volatile SingularAttribute<FloristFlowers, String> typeId;
	public static volatile SingularAttribute<FloristFlowers, String> no;
	public static volatile SingularAttribute<FloristFlowers, Integer> price;
	public static volatile SingularAttribute<FloristFlowers, String> material;
	public static volatile SingularAttribute<FloristFlowers, String> creater;
	public static volatile SingularAttribute<FloristFlowers, Date> created;
	public static volatile SingularAttribute<FloristFlowers, String> modifier;
	public static volatile SingularAttribute<FloristFlowers, Date> modified;
	public static volatile SingularAttribute<FloristFlowers, Integer> version;
	public static volatile SingularAttribute<FloristFlowers, Integer> deletion;
	public static volatile SingularAttribute<FloristFlowers, Integer> history;
	public static volatile SingularAttribute<FloristFlowers, String> memo;
	public static volatile SingularAttribute<FloristFlowers, String> image;
	public static volatile SingularAttribute<FloristFlowers, FloristType> type;

}
