/*
 * 
 *
 * 
 */
package com.sxm.florist.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sxm.core.repository.BaseRepository;
import com.sxm.core.service.BaseService;
import com.sxm.florist.domain.FloristOrder;
import com.sxm.florist.repository.FloristOrderRepository;

/**
 * 订单Service.
 * 
 * @author sxm
 * @version 2016-05-23
 * @----------------------------------------------------------------------------------------
 * @updated 修改描述.
 * @updated by sxm
 * @updated at 2016-05-23
 */
@Service
@Transactional
public class FloristOrderService extends BaseService<FloristOrder, String> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(FloristOrderService.class);

	@Autowired
	private FloristOrderRepository floristOrderRepository;

	@Override
	public BaseRepository<FloristOrder, String> getRepository() {
		return floristOrderRepository;
	}

}
