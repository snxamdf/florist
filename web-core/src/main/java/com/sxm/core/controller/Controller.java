/*
 * 
 *
 * 
 */
package com.sxm.core.controller;

import java.io.Serializable;

import com.sxm.core.domain.Sys;
import com.sxm.core.dto.Module;
import com.sxm.core.service.BaseService;

/**
 * 祖先控制器类.
 * 
 * @author sxm
 * @version 2014-08-11
 * @----------------------------------------------------------------------------------------
 * @updated 修改描述.
 * @updated by sxm
 * @updated at 2014-08-11
 */
public abstract class Controller<T extends Sys<ID>, ID extends Serializable> {

	/**
	 * 在子类实现的回调函数，为BaseController提供基本操作所需的Service.
	 * 
	 * @return
	 * @author sxm
	 * @version 2014-08-11
	 * @----------------------------------------------------------------------------------------
	 * @updated 修改描述.
	 * @updated by sxm
	 * @updated at 2014-08-11
	 */
	public abstract BaseService<T, ID> getService();

	/**
	 * 在子类实现的回调函数，为BaseController提供对应Module.
	 * 
	 * @return
	 * @author sxm
	 * @version 2014-12-26
	 * @----------------------------------------------------------------------------------------
	 * @updated 修改描述.
	 * @updated by sxm
	 * @updated at 2014-12-26
	 */
	public abstract Module<T> getModule();

}
