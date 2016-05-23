/*
 * 
 *
 * 
 */
package com.sxm.florist.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

import com.sxm.core.domain.Sys;

/**
 * 订单Domain
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
@Table(name = "t_florist_order")
public class FloristOrder extends Sys<String> {

	private static final long serialVersionUID = 1L;
	private String orderNo;
	private String flowersNo;
	private Integer price;
	private String addr;
	private String uid;
	private String flowersId;
	private Integer amount;

}
