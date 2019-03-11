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

import org.measure.platform.core.data.entity.Notification;
import org.measure.platform.core.data.entity.Project;

/**
 * Service Interface for managing notification.
 */
public interface INotificationService {
    /**
     * Save a notification.
     * @param notification the entity to save
     * @return the persisted entity
     */
    Notification save(Notification notification);

    /**
     * Get all the notifications.
     * @return the list of entities
     */
    List<Notification> findAll();

    /**
     * Get all the notifications by project.
     * @param id the id of the project
     * @return the list of entities
     */
    List<Notification> findAllByProject(Project project);

    /**
     * Get the "id" notification.
     * @param id the id of the entity
     * @return the entity
     */
    Notification findOne(Long id);

    /**
     * Delete the "id" notification.
     * @param id the id of the entity
     */
    void delete(Long id);

    /**
     * Get all the unvalidated notifications by project.
     * @param id the id of the project
     * @return the list of entities
     */
    List<Notification> findNewByProject(Project project);

}
