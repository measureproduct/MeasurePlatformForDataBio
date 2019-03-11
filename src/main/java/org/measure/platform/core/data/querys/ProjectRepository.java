/*******************************************************************************
 * Copyright (C) 2019 Softeam
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 ******************************************************************************/
package org.measure.platform.core.data.querys;

import java.util.List;

import org.measure.platform.core.data.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Spring Data JPA repository for the Project entity.
 */
public interface ProjectRepository extends JpaRepository<Project,Long> {
    @Query(value = "select * from project where project.id in "
			+ "( select user_managed_project.project_id from user_managed_project where user_managed_project.user_id in "
				+ "( select jhi_user.id from jhi_user where jhi_user.login = ?#{principal.username} ) )"
	+ "union "
		+ "select * from project where project.id in "
			+ "( select user_invited_project.project_id from user_invited_project where user_invited_project.user_id in "
				+ "( select jhi_user.id from jhi_user where jhi_user.login = ?#{principal.username} ) )", nativeQuery= true)
	List<Project> findByOwnerIsCurrentUser();
       
    @Query(value= "SELECT id, login, first_name, last_name, email FROM jhi_user WHERE NOT EXISTS ( SELECT * FROM user_invited_project WHERE jhi_user.id = user_invited_project.user_id AND user_invited_project.project_id = ?1 UNION SELECT * FROM user_managed_project WHERE jhi_user.id = user_managed_project.user_id AND user_managed_project.project_id = ?1 )", nativeQuery = true)
    List<Object[]> findCandidateUsersByProjectId(@Param("projectId") Long projectId);

}
