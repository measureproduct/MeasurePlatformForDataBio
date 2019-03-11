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

import org.measure.platform.core.data.entity.AlertEvent;
import org.measure.platform.core.data.entity.AlertEventProperty;

/**
 * Service Interface for managing AlertEvent.
 */
public interface IAlertEventPropertyService {
    /**
     * Save a alert event property.
     * @param project the entity to save
     * @return the persisted entity
     */
    AlertEventProperty save(AlertEventProperty project);

    /**
     * Get all the alert event property.
     * @return the list of entities
     */
    List<AlertEventProperty> findAll();

    /**
     * Get all the alert events of current owner.
     * @return the list of entities
     */
    List<AlertEventProperty> findAllByAlertEvent(AlertEvent alertEvent);

    /**
     * Get the "id" alert event property.
     * @param id the id of the entity
     * @return the entity
     */
    AlertEventProperty findOne(Long id);

    /**
     * Delete the "id" alert event  property.
     * @param id the id of the entity
     */
    void delete(Long id);

	

}
