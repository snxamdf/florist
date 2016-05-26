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
import com.sxm.florist.domain.FloristLeaveMsg;
import com.sxm.florist.repository.FloristLeaveMsgRepository;

/**
 * 留言版Service.
 * 
 * @author sxm
 * @version 2016-05-26
 * @----------------------------------------------------------------------------------------
 * @updated 修改描述.
 * @updated by sxm
 * @updated at 2016-05-26
 */
@Service
@Transactional
public class FloristLeaveMsgService extends BaseService<FloristLeaveMsg, String> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(FloristLeaveMsgService.class);

	@Autowired
	private FloristLeaveMsgRepository floristLeaveMsgRepository;

	@Override
	public BaseRepository<FloristLeaveMsg, String> getRepository() {
		return floristLeaveMsgRepository;
	}

}
