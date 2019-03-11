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
package org.measure.platform.core.data.service;

import java.util.List;

import javax.inject.Inject;

import org.measure.platform.core.data.api.IAlertEventPropertyService;
import org.measure.platform.core.data.entity.AlertEvent;
import org.measure.platform.core.data.entity.AlertEventProperty;
import org.measure.platform.core.data.querys.AlertEventPropertyRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing AlertEventProperty.
 */
@Service
@Transactional
public class AlertEventPropertyServiceImpl implements IAlertEventPropertyService {
    private final Logger log = LoggerFactory.getLogger(AlertEventPropertyServiceImpl.class);

    @Inject
    private AlertEventPropertyRepository alertEventPropertyRepository;


    /**
     * Save a AlertEventProperty.
     * @param project the entity to save
     * @return the persisted entity
     */
    public AlertEventProperty save(AlertEventProperty alertEventProperty) {
        log.debug("Request to save AlertEventProperty : {}", alertEventProperty);
        AlertEventProperty result = alertEventPropertyRepository.save(alertEventProperty);
        return result;
    }

    /**
     * Get all the AlertEventProperty
     * @return the list of entities
     */
    @Transactional(readOnly = true)
    public List<AlertEventProperty> findAll() {
        log.debug("Request to get all AlertEventPropertys");
        List<AlertEventProperty> result = alertEventPropertyRepository.findAll();
        return result;
    }


    /**
     * Get one AlertEventProperty by id.
     * @param id the id of the entity
     * @return the entity
     */
    @Transactional(readOnly = true)
    public AlertEventProperty findOne(Long id) {
        log.debug("Request to get AlertEventProperty : {}", id);
        AlertEventProperty project = alertEventPropertyRepository.findOne(id);
        return project;
    }

    /**
     * Delete the  AlertEventProperty by id.
     * @param id the id of the entity
     */
    public void delete(Long id) {
        alertEventPropertyRepository.delete(id);
    }

	@Override
	public List<AlertEventProperty> findAllByAlertEvent(AlertEvent alertEvent) {
		// TODO Auto-generated method stub
		return alertEventPropertyRepository.findByAlertEvent(alertEvent);
	}

}
