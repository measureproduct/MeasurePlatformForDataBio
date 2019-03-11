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
import org.measure.platform.core.data.entity.Project;
import org.measure.platform.core.data.entity.ProjectAnalysis;

/**
 * Service Interface for managing AlertEvent.
 */
public interface IAlertEventService {
	/**
	 * Save a alert event.
	 * 
	 * @param project the entity to save
	 * @return the persisted entity
	 */
	AlertEvent save(AlertEvent alertEvent);

	/**
	 * Get all the alert events.
	 * 
	 * @return the list of entities
	 */
	List<AlertEvent> findAll();

	/**
	 * Get all the alert events of current project.
	 * 
	 * @return the list of entities
	 */
	List<AlertEvent> findAllByProject(Project project);
	
	/**
	 * Get the "id" alert event.
	 * 
	 * @param id the id of the entity
	 * @return the entity
	 */
	AlertEvent findOne(Long id);

	/**
	 * Delete the "id" alert event.
	 * 
	 * @param id the id of the entity
	 */
	void delete(Long id);

	List<AlertEvent> findByProjectAndEventType(Project project, String analysisTool, String name);

	List<AlertEvent> findByProjectEventTypeAndProp(Project project, String analysisTool, String name, String property,String value);



}
