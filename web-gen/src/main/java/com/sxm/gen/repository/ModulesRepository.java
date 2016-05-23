/* 
 * 
 *
 * 
 */
package com.sxm.gen.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.sxm.core.repository.BaseRepository;
import com.sxm.gen.domain.Modules;

public interface ModulesRepository extends BaseRepository<Modules, String> {

	@Query("from Modules t where t.projectId like ?1")
	public List<Modules> findByProjectId(String projectId);

}
