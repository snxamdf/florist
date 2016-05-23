/* 
 * 
 *
 * 
 */
package com.sxm.gen.repository;

import java.util.List;

import com.sxm.core.repository.BaseRepository;
import com.sxm.gen.domain.Projects;

public interface ProjectsRepository extends BaseRepository<Projects, String> {

	public List<Projects> findAll();

}
