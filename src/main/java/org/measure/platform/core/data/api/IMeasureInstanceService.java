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

import org.measure.platform.core.data.entity.MeasureInstance;

/**
 * Service Interface for managing MeasureInstance.
 */
public interface IMeasureInstanceService {
    /**
     * Save a measureInstance.
     * @param measureInstance the entity to save
     * @return the persisted entity
     */
    MeasureInstance save(MeasureInstance measureInstance);

    /**
     * Get all the measureInstances.
     * @return the list of entities
     */
    List<MeasureInstance> findAll();

    /**
     * Get the "id" measureInstance.
     * @param id the id of the entity
     * @return the entity
     */
    MeasureInstance findOne(Long id);

    /**
     * Delete the "id" measureInstance.
     * @param id the id of the entity
     */
    void delete(Long id);

    /**
     * Get all the measureInstances of a specified project.
     * @return the list of entities
     */
    List<MeasureInstance> findMeasureInstancesByProject(Long projectId);

    List<MeasureInstance> findMeasureInstanceByReference(String id);

    List<MeasureInstance> findMeasureInstancesByName(String name);

    List<MeasureInstance> findMeasureInstancesByApplicationInstance(Long applicationInstanceId);

	MeasureInstance findMeasureInstancesByApplicationInstance(Long id, String measureType);

}
