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
 * 留言版Domain
 * 
 * @author sxm
 * @version 2016-05-26
 * @----------------------------------------------------------------------------------------
 * @updated 修改描述.
 * @updated by sxm
 * @updated at 2016-05-26
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "t_florist_leave_msg")
public class FloristLeaveMsg extends Sys<String> {

	private static final long serialVersionUID = 1L;
	private String uid;
	private String msg;
	private String title;

}
