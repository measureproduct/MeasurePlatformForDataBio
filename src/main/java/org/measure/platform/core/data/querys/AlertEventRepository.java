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

import org.measure.platform.core.data.entity.AlertEvent;
import org.measure.platform.core.data.entity.Project;
import org.measure.platform.core.data.entity.ProjectAnalysis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Spring Data JPA repository for the AlertEvent entity.
 */
@SuppressWarnings("unused")
public interface AlertEventRepository extends JpaRepository<AlertEvent,Long> {

	@Query(value = "select i from AlertEvent i where i.project = :project")
	List<AlertEvent> findByProject(@Param("project") Project project);

	@Query(value = "select i from AlertEvent i where i.project = :project")
	List<AlertEvent> findByProjectAnalysis(@Param("project") Project project);

	@Query(value = "select i from AlertEvent i where i.analysisTool = :analysisTool and  i.project = :project and i.eventType = :eventType")
	List<AlertEvent> findByProjectAndEventType(@Param("project") Project project,@Param("analysisTool") String analysisTool,@Param("eventType") String eventType);

	
	@Query(value = "select i from AlertEvent i join i.alerteventpropertys pr where i.analysisTool = :analysisTool and  i.project = :project and i.eventType = :eventType and pr.name = :propName and pr.value = :propValue")
	List<AlertEvent> findByProjectEventTypeAndProp(@Param("project") Project project,@Param("analysisTool") String analysisTool,@Param("eventType") String eventType,@Param("propName")String propName,@Param("propValue") String propValue);
	
}
