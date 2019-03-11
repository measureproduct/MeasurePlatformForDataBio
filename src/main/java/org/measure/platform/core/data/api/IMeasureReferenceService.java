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
import org.measure.platform.core.data.entity.MeasureReference;

/**
 * Service Interface for managing MeasureReference.
 */
public interface IMeasureReferenceService {
    /**
     * Save a measureReference.
     * @param measureReference the entity to save
     * @return the persisted entity
     */
    MeasureReference save(MeasureReference measureReference);

    /**
     * Get all the measureProperties.
     * @return the list of entities
     */
    List<MeasureReference> findAll();

    /**
     * Get the "id" measureReference.
     * @param id the id of the entity
     * @return the entity
     */
    MeasureReference findOne(Long id);

    /**
     * Delete the "id" measureReference.
     * @param id the id of the entity
     */
    void delete(Long id);

    List<MeasureReference> findByInstance(MeasureInstance instance);

}
