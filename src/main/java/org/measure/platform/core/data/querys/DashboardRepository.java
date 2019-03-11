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

import org.measure.platform.core.data.entity.Application;
import org.measure.platform.core.data.entity.Dashboard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Spring Data JPA repository for the Dashboard entity.
 */
public interface DashboardRepository extends JpaRepository<Dashboard,Long> {
	
    @Query(value = "SELECT DISTINCT dashboard.id, dashboard.dashboard_name, dashboard.dashboard_description, dashboard.mode, dashboard.kibana_id, dashboard.dashboard_content, dashboard.auto, dashboard.editable, dashboard.time_periode, dashboard.size, dashboard.project_id, dashboard.application_id, dashboard.manager_id FROM dashboard LEFT JOIN user_viewed_dashboard ON dashboard.id = user_viewed_dashboard.dashboard_id LEFT JOIN jhi_user ON user_viewed_dashboard.user_id = jhi_user.id WHERE ( dashboard.project_id = ?1 AND (dashboard.mode = 'OVERVIEW' OR dashboard.mode = 'APPLICATION') ) OR ( dashboard.project_id = ?1 AND dashboard.manager_id = ?2 ) OR ( dashboard.project_id = ?1 AND jhi_user.id = ?2 )", nativeQuery = true)
    List<Dashboard> findByProjectAndUser(@Param("projectId") Long projectId, @Param("userId") Long userId);

    @Query(value = "select i from Dashboard i where i.application = :application")
    List<Dashboard> findByApplication(@Param("application") Application application);
}
