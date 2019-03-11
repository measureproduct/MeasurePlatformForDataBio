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
package org.measure.platform.core.data.api.dto;

import org.measure.platform.core.data.entity.Dashboard;

public class MappingDashboardDTO {
	
	private Dashboard dashboard;
	private DashboardDTO dashboardDTO;
	
	public MappingDashboardDTO() {
	}
	
	public Dashboard convertDashboardDtoToDashboard(DashboardDTO dashboardDTO) {
		dashboard = new Dashboard();
		dashboard.setId(dashboardDTO.getId());
		dashboard.setDashboardName(dashboardDTO.getDashboardName());
		dashboard.setDashboardDescription(dashboardDTO.getDashboardDescription());
		dashboard.setMode(dashboardDTO.getMode());
		dashboard.setKibanaId(dashboardDTO.getKibanaId());
		dashboard.setContent(dashboardDTO.getContent());
		dashboard.setAuto(dashboardDTO.isAuto());
		dashboard.setEditable(dashboardDTO.isEditable());
		dashboard.setSize(dashboardDTO.getSize());
		dashboard.setTimePeriode(dashboardDTO.getTimePeriode());
		dashboard.setProject(dashboardDTO.getProject());
		dashboard.setApplication(dashboardDTO.getApplication());
		dashboard.setViews(dashboardDTO.getViews());
		dashboard.setUsers(dashboardDTO.getUsers());
		return dashboard;
	}
	
	public DashboardDTO convertDashboardToDashboardDto(Dashboard dashboard) {
		dashboardDTO = new DashboardDTO();
		dashboardDTO.setId(dashboard.getId());
		dashboardDTO.setDashboardName(dashboard.getDashboardName());
		dashboardDTO.setDashboardDescription(dashboard.getDashboardDescription());
		dashboardDTO.setMode(dashboard.getMode());
		dashboardDTO.setKibanaId(dashboard.getKibanaId());
		dashboardDTO.setContent(dashboard.getContent());
		dashboardDTO.setAuto(dashboard.isAuto());
		dashboardDTO.setEditable(dashboard.isEditable());
		dashboardDTO.setSize(dashboard.getSize());
		dashboardDTO.setTimePeriode(dashboard.getTimePeriode());
		dashboardDTO.setProject(dashboard.getProject());
		dashboardDTO.setApplication(dashboard.getApplication());
		dashboardDTO.setViews(dashboard.getViews());
		dashboardDTO.setUsers(dashboard.getUsers());
		return dashboardDTO;
	}

}
