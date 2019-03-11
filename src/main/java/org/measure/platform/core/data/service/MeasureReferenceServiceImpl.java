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

import org.measure.platform.core.data.api.IMeasureReferenceService;
import org.measure.platform.core.data.entity.MeasureInstance;
import org.measure.platform.core.data.entity.MeasureReference;
import org.measure.platform.core.data.querys.MeasureReferenceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing MeasureReference.
 */
@Service
@Transactional
public class MeasureReferenceServiceImpl implements IMeasureReferenceService {
    private final Logger log = LoggerFactory.getLogger(MeasureReferenceServiceImpl.class);

    @Inject
    private MeasureReferenceRepository measureReferenceRepository;

    /**
     * Save a MeasureReference.
     * @param MeasureReference the entity to save
     * @return the persisted entity
     */
    public MeasureReference save(MeasureReference MeasureReference) {
        log.debug("Request to save MeasureReference : {}", MeasureReference);
        MeasureReference result = measureReferenceRepository.save(MeasureReference);
        return result;
    }

    /**
     * Get all the measureProperties.
     * @return the list of entities
     */
    @Transactional(readOnly = true)
    public List<MeasureReference> findAll() {
        log.debug("Request to get all MeasureProperties");
        List<MeasureReference> result = measureReferenceRepository.findAll();
        return result;
    }

    /**
     * Get one MeasureReference by id.
     * @param id the id of the entity
     * @return the entity
     */
    @Transactional(readOnly = true)
    public MeasureReference findOne(Long id) {
        log.debug("Request to get MeasureReference : {}", id);
        MeasureReference MeasureReference = measureReferenceRepository.findOne(id);
        return MeasureReference;
    }

    /**
     * Delete the  MeasureReference by id.
     * @param id the id of the entity
     */
    public void delete(Long id) {
        log.debug("Request to delete MeasureReference : {}", id);
        measureReferenceRepository.delete(id);
    }

    @Override
    public List<MeasureReference> findByInstance(MeasureInstance instance) {
        List<MeasureReference> result = measureReferenceRepository.findByMeasure(instance);
        return result;
    }

}
