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

import org.measure.platform.core.data.entity.AnalysisCard;
import org.measure.platform.core.data.entity.Dashboard;
import org.measure.platform.core.data.entity.MeasureInstance;
import org.measure.platform.core.data.entity.MeasureView;
import org.measure.platform.core.data.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Spring Data JPA repository for the MeasureView entity.
 */
@SuppressWarnings("unused")
public interface MeasureViewRepository extends JpaRepository<MeasureView,Long> {
    @Query(value = "select i from MeasureView i where i.project = :project")
    List<MeasureView> findByProject(@Param("project") Project project);

    @Query(value = "select i from MeasureView i where i.projectoverview = :project")
    List<MeasureView> findByProjectOverview(@Param("project") Project project);

    @Query(value = "select i from MeasureView i where i.dashboard = :dashboard")
    List<MeasureView> findByDashboard(@Param("dashboard") Dashboard dashboard);

    @Query(value = "select i from MeasureView i where i.measureinstance = :minstance")
    List<MeasureView> findByMeasure(@Param("minstance") MeasureInstance minstance);

    @Query(value = "select i from MeasureView i where i.analysiscard = :analysisCard")
	List<MeasureView> findByAnalysisCard(@Param("analysisCard") AnalysisCard analysisCard);

    @Query(value = "select i from MeasureView i where i.measureinstance = :measureinstance AND i.defaultView = true")
  	List<MeasureView> findDefaultViewByMeasureInstance(@Param("measureinstance") MeasureInstance measureinstance);
}
