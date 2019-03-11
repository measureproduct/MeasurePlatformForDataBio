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

import org.measure.platform.core.data.entity.Application;

/**
 * Service Interface for managing ApplicationInstance.
 */
public interface IApplicationService {
    /**
     * Save an applicationInstance.
     * @param applicationInstance the entity to save
     * @return the persisted entity
     */
    Application save(Application applicationInstance);

    /**
     * Get all the applicationInstances.
     * @return the list of entities
     */
    List<Application> findAll();

    /**
     * Get the "id" applicationInstance.
     * @param id the id of the entity
     * @return the entity
     */
    Application findOne(Long id);

    /**
     * Delete the "id" applicationInstance.
     * @param id the id of the entity
     */
    void delete(Long id);

    /**
     * Get all the applicationInstances of a specified project.
     * @return the list of entities
     */
    List<Application> findApplicationInstancesByProject(Long projectId);

    List<Application> findApplicationInstanceByApplicationType(String applicationtype);

    List<Application> findApplicationInstancesByName(String name);

}
