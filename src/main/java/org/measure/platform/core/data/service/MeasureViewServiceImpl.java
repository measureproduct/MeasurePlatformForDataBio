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

import org.measure.platform.core.catalogue.api.IMeasureVisaulisationManagement;
import org.measure.platform.core.data.api.IAnalysisCardService;
import org.measure.platform.core.data.api.IDashboardService;
import org.measure.platform.core.data.api.IMeasureInstanceService;
import org.measure.platform.core.data.api.IMeasureViewService;
import org.measure.platform.core.data.api.IProjectService;
import org.measure.platform.core.data.entity.AnalysisCard;
import org.measure.platform.core.data.entity.Dashboard;
import org.measure.platform.core.data.entity.MeasureInstance;
import org.measure.platform.core.data.entity.MeasureView;
import org.measure.platform.core.data.entity.Project;
import org.measure.platform.core.data.querys.MeasureViewRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing MeasureView.
 */
@Service
@Transactional
public class MeasureViewServiceImpl implements IMeasureViewService {
    private final Logger log = LoggerFactory.getLogger(MeasureViewServiceImpl.class);



    @Inject
    private MeasureViewRepository measureViewRepository;

    @Inject
    private IProjectService projectService;
    
    @Inject
    private IMeasureInstanceService measureInstanceService;
    
    @Inject
    private IAnalysisCardService analysisCardService;


    @Inject
    private IDashboardService dashboardService;
    
    @Inject
    private IMeasureVisaulisationManagement visualisationManager;


    /**
     * Save a measureView.
     * @param measureView the entity to save
     * @return the persisted entity
     */
    public MeasureView save(MeasureView measureView) {
        log.debug("Request to save MeasureView : {}", measureView);
        
        String mode = measureView.getMode();
        if ("AUTO".equals(mode)) {
            measureView.setViewData(visualisationManager.formatViewDataAsKibanaURL(measureView));
        } else if ("KVIS".equals(mode)) {
            measureView.setViewData(visualisationManager.formatViewDataAsKibanaViewReference(measureView));
        } else if ("KDASH".equals(mode)) {
            measureView.setViewData(visualisationManager.formatViewDataAsKibanaDashboardReference(measureView));
        } else if ("CARD".equals(mode)) {
            measureView.setViewData(visualisationManager.formatViewDataAsAnalysisCard(measureView));
        }
        
        MeasureView result = measureViewRepository.save(measureView);
        return result;
    }

    /**
     * Get all the measureViews.
     * @return the list of entities
     */
    @Transactional(readOnly = true)
    public List<MeasureView> findAll() {
        log.debug("Request to get all MeasureViews");
        List<MeasureView> result = measureViewRepository.findAll();
        return result;
    }

    /**
     * Get one measureView by id.
     * @param id the id of the entity
     * @return the entity
     */
    @Transactional(readOnly = true)
    public MeasureView findOne(Long id) {
        log.debug("Request to get MeasureView : {}", id);
        MeasureView measureView = measureViewRepository.findOne(id);
        return measureView;
    }

    /**
     * Delete the measureView by id.
     * @param id the id of the entity
     */
    public void delete(Long id) {
        log.debug("Request to delete MeasureView : {}", id);
        measureViewRepository.delete(id);
    }

    public List<MeasureView> findByProject(Long id) {
        Project project = projectService.findOne(id);
        return measureViewRepository.findByProject(project);
    }
    
    public List<MeasureView> findDefaulsByMeasureInstance(Long id) {
        MeasureInstance instance = measureInstanceService.findOne(id);
        return measureViewRepository.findDefaultViewByMeasureInstance(instance);
    }

    public List<MeasureView> findByProjectOverview(Long id) {
        Project project = projectService.findOne(id);
        return measureViewRepository.findByProjectOverview(project);
    }

    public List<MeasureView> findByDashboard(Long id) {
        Dashboard dashboard = dashboardService.findOne(id);
        return measureViewRepository.findByDashboard(dashboard);
    }
    
	@Override
	public List<MeasureView> findByAnalysisCard(Long id) {
		AnalysisCard analysisCard = analysisCardService.findOne(id);
		return measureViewRepository.findByAnalysisCard(analysisCard);
	}



}
