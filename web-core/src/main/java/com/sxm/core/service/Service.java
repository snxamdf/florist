/*
 * 
 *
 * 
 */
package com.sxm.core.service;

import java.io.Serializable;

import com.sxm.core.domain.Sys;
import com.sxm.core.repository.BaseRepository;

/**
 * 祖先服务类.
 * 
 * @author sxm
 * @version 2014-08-08
 * @----------------------------------------------------------------------------------------
 * @updated 修改描述.
 * @updated by sxm
 * @updated at 2014-08-08
 */
public abstract class Service<T extends Sys<ID>, ID extends Serializable> {

	/**
	 * 在子类实现的回调函数，为Service提供基本操作所需的Repository.
	 * 
	 * @return
	 * @author sxm
	 * @version 2014-08-08
	 * @----------------------------------------------------------------------------------------
	 * @updated 修改描述.
	 * @updated by sxm
	 * @updated at 2014-08-08
	 */
	public abstract BaseRepository<T, ID> getRepository();

}
