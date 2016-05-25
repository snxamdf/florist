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

/**
 * 鲜花Domain
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
@Table(name = "t_florist_flowers")
public class FloristFlowers extends Sys<String> {

	private static final long serialVersionUID = 1L;
	private String name;
	private String typeId;
	private String no;
	private Integer price;
	private String material;
	private String image;

	@OneToOne(targetEntity = FloristType.class, cascade = { CascadeType.REFRESH })
	@JoinColumn(name = "typeId", referencedColumnName = "id", insertable = false, updatable = false)
	private FloristType type;
}
