/*
 * 
 *
 * 
 */
package com.sxm.sys.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.sxm.core.domain.Sys;
import com.sxm.core.repository.BaseRepository;
import com.sxm.sys.domain.UserRoles;

/**
 * 用户角色关系表Repository接口.
 * 
 * @author sxm
 * @version 2016-05-23
 * @----------------------------------------------------------------------------------------
 * @updated 修改描述.
 * @updated by sxm
 * @updated at 2016-05-23
 */
@Transactional
public interface UserRolesRepository extends BaseRepository<UserRoles, String> {

	@Query("select r from UserRoles r where r.userId = ?1 and r.deletion = " + Sys.DELETION_NO)
	List<UserRoles> findByUserId(String userId);

	@Modifying
	@Query(value = "delete from UserRoles ur where ur.userId = ?1")
	int deleteByUserId(String userId);
}
