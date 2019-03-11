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
import org.measure.platform.core.data.entity.ProjectAnalysis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Spring Data JPA repository for the ProjectAnalysis entity.
 */
public interface ProjectAnalysisRepository extends JpaRepository<ProjectAnalysis,Long> {

	@Query(value = "select i from ProjectAnalysis i where i.project = :project")
	List<ProjectAnalysis> findAllByProject(@Param("project")Project project);

	@Query(value = "select i from ProjectAnalysis i where i.project = :project and i.analysisToolId = :analysisTool")
	List<ProjectAnalysis> findByProjectAndTool(@Param("project")Project project,@Param("analysisTool") String analysisTool);

	@Query(value = "select i from ProjectAnalysis i where i.analysisToolId = :analysisTool")
	List<ProjectAnalysis> findAllByAnalysisTool(String analysisToolId);

}
