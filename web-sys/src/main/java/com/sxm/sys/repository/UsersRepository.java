/*
 * 
 *
 * 
 */
package com.sxm.sys.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.sxm.core.domain.Sys;
import com.sxm.core.repository.BaseRepository;
import com.sxm.sys.domain.Users;

/**
 * 用户表Repository接口.
 * 
 * @author sxm
 * @version 2016-05-23
 * @----------------------------------------------------------------------------------------
 * @updated 修改描述.
 * @updated by sxm
 * @updated at 2016-05-23
 */
public interface UsersRepository extends BaseRepository<Users, String> {

	@Query("select u from Users u where u.loginname = ?1 and u.deletion = " + Sys.DELETION_NO)
	Users findByLoginName(String loginName);

	@Query("select distinct r.genre from Users u, UserRoles ur, Role r where u.id=ur.userId and ur.roleId=r.id and u.id = ?1")
	List<String> findPermissionsById(String userId);
}
