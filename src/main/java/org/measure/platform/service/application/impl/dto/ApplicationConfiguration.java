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
package org.measure.platform.service.application.impl.dto;

import java.util.ArrayList;
import java.util.List;

import org.measure.platform.core.data.entity.Project;

public class ApplicationConfiguration {
	
	private Long id;
	
	private String name;
	
	private String applicationType;
	
	private List<ApplicationProperty> properties;
	
	private Boolean isEnable;

	private Project project;
	
	public ApplicationConfiguration() {
		this.properties = new ArrayList<>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getApplicationType() {
		return applicationType;
	}

	public void setApplicationType(String applicationType) {
		this.applicationType = applicationType;
	}

	public List<ApplicationProperty> getProperties() {
		return properties;
	}

	public void setProperties(List<ApplicationProperty> properties) {
		this.properties = properties;
	}

	public Boolean getIsEnable() {
		return isEnable;
	}

	public void setIsEnable(Boolean isEnable) {
		this.isEnable = isEnable;
	}

	public Project getProject() {
		
		return project;
	}
	
	public void setProject(Project project) {
		
		this.project = project;
	}
	
	public String getPropertyValue(String name) {
		for(ApplicationProperty prop : this.properties) {
			if(prop.getName().equals(name)) {
				return prop.getValue();
			}
		}
		
		return "";		
	}


}
