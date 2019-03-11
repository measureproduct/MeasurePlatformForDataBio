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
package org.measure.platform.core.data.api;

import java.util.List;

import org.measure.platform.core.data.entity.MeasureView;

/**
 * Service Interface for managing MeasureView.
 */
public interface IMeasureViewService {
    /**
     * Save a measureView.
     * @param measureView the entity to save
     * @return the persisted entity
     */
    MeasureView save(MeasureView measureView);

    /**
     * Get all the measureViews.
     * @return the list of entities
     */
    List<MeasureView> findAll();

    /**
     * Get the "id" measureView.
     * @param id the id of the entity
     * @return the entity
     */
    MeasureView findOne(Long id);

    /**
     * Delete the "id" measureView.
     * @param id the id of the entity
     */
    void delete(Long id);

    List<MeasureView> findByProject(Long id);

    List<MeasureView> findByProjectOverview(Long id);

    List<MeasureView> findByDashboard(Long id);

    List<MeasureView> findByAnalysisCard(Long id);
    
    List<MeasureView> findDefaulsByMeasureInstance(Long id);

}
