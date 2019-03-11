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
package org.measure.platform.core.data.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * A ProjectAnalysis.
 */
@Entity
@Table(name = "project_analysis")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class ProjectAnalysis implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Column(name = "analysis_tool_id", nullable = false)
    private String analysisToolId;
    
    
    @Column(name = "analysis_tool_description", nullable = true)
    private String analysisToolDescription;
       
    @Column(name = "dashboard_name", nullable = true)
    private String dashboardName;
    
    @Column(name = "configuration_url", nullable = true)
    private String configurationUrl;
    
    
    @Column(name = "view_url", nullable = true)
    private String viewUrl;
 
    @ManyToOne
    private Project project;
       
    @OneToMany(mappedBy = "projectanalysis")
    @JsonIgnore
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<AnalysisCard> analysiscards = new HashSet<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAnalysisToolId() {
		return analysisToolId;
	}

	public void setAnalysisToolId(String analysisToolId) {
		this.analysisToolId = analysisToolId;
	}

	public String getAnalysisToolDescription() {
		return analysisToolDescription;
	}

	public void setAnalysisToolDescription(String analysisToolDescription) {
		this.analysisToolDescription = analysisToolDescription;
	}

	public String getDashboardName() {
		return dashboardName;
	}

	public void setDashboardName(String dashboardName) {
		this.dashboardName = dashboardName;
	}

	public String getConfigurationUrl() {
		return configurationUrl;
	}

	public void setConfigurationUrl(String configurationUrl) {
		this.configurationUrl = configurationUrl;
	}

	public String getViewUrl() {
		return viewUrl;
	}

	public void setViewUrl(String viewUrl) {
		this.viewUrl = viewUrl;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Set<AnalysisCard> getAnalysiscards() {
		return analysiscards;
	}

	public void setAnalysiscards(Set<AnalysisCard> analysiscards) {
		this.analysiscards = analysiscards;
	}
}
