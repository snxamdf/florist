/*
 * 
 *
 * 
 */
package com.sxm.florist.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

import com.sxm.core.domain.Sys;
import com.sxm.sys.domain.Users;

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

	@OneToOne(targetEntity = Users.class, cascade = { CascadeType.REFRESH })
	@JoinColumn(name = "uid", referencedColumnName = "id", insertable = false, updatable = false)
	private Users user;
}
