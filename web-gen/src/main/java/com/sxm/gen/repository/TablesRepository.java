/* 
 * 
 *
 * 
 */
package com.sxm.gen.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.sxm.gen.domain.Tables;
import com.sxm.core.repository.BaseRepository;

public interface TablesRepository extends BaseRepository<Tables, String> {

	@Query("from Tables t where t.moduleId like ?1")
	public List<Tables> findByModuleId(String moduleId);

}
