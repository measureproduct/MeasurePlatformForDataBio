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

import org.measure.platform.core.data.api.IMeasurePropertyService;
import org.measure.platform.core.data.entity.MeasureInstance;
import org.measure.platform.core.data.entity.MeasureProperty;
import org.measure.platform.core.data.querys.MeasurePropertyRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing MeasureProperty.
 */
@Service
@Transactional
public class MeasurePropertyServiceImpl implements IMeasurePropertyService {
    private final Logger log = LoggerFactory.getLogger(MeasurePropertyServiceImpl.class);

    @Inject
    private MeasurePropertyRepository measurePropertyRepository;

    /**
     * Save a measureProperty.
     * @param measureProperty the entity to save
     * @return the persisted entity
     */
    public MeasureProperty save(MeasureProperty measureProperty) {
        log.debug("Request to save MeasureProperty : {}", measureProperty);
        MeasureProperty result = measurePropertyRepository.save(measureProperty);
        return result;
    }

    /**
     * Get all the measureProperties.
     * @return the list of entities
     */
    @Transactional(readOnly = true)
    public List<MeasureProperty> findAll() {
        log.debug("Request to get all MeasureProperties");
        List<MeasureProperty> result = measurePropertyRepository.findAll();
        return result;
    }

    /**
     * Get one measureProperty by id.
     * @param id the id of the entity
     * @return the entity
     */
    @Transactional(readOnly = true)
    public MeasureProperty findOne(Long id) {
        log.debug("Request to get MeasureProperty : {}", id);
        MeasureProperty measureProperty = measurePropertyRepository.findOne(id);
        return measureProperty;
    }

    /**
     * Delete the  measureProperty by id.
     * @param id the id of the entity
     */
    public void delete(Long id) {
        log.debug("Request to delete MeasureProperty : {}", id);
        measurePropertyRepository.delete(id);
    }

    @Override
    public List<MeasureProperty> findByInstance(MeasureInstance instance) {
        List<MeasureProperty> result = measurePropertyRepository.findByMeasure(instance);
        return result;
    }

}
