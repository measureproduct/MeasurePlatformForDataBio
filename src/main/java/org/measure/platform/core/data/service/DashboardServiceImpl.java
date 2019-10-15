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

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;

import org.measure.platform.core.data.api.IDashboardService;
import org.measure.platform.core.data.api.IMeasureViewService;
import org.measure.platform.core.data.api.dto.DashboardDTO;
import org.measure.platform.core.data.api.dto.MappingDashboardDTO;
import org.measure.platform.core.data.entity.Dashboard;
import org.measure.platform.core.data.entity.MeasureView;
import org.measure.platform.core.data.querys.ApplicationRepository;
import org.measure.platform.core.data.querys.DashboardRepository;
import org.measure.platform.utils.domain.User;
import org.measure.platform.utils.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing Dashboard.
 */
@Service
@Transactional
public class DashboardServiceImpl implements IDashboardService {
    private final Logger log = LoggerFactory.getLogger(DashboardServiceImpl.class);

    @Autowired
    private MessageSource messageSource;

    @Value("${measureplatform.kibana.url}")
    private String kibanaUrl;

    @Inject
    private DashboardRepository dashboardRepository;

    @Inject
    private IMeasureViewService viewService;
    
    @Inject
    private ApplicationRepository applicationRepository;

    @Inject
    private UserService userService;

    /**
     * Save a dashboard.
     * @param dashboard the entity to save
     * @return the persisted entity
     */
    public Dashboard save(Dashboard dashboard) {
        if(dashboard.getMode().equals("KIBANA")){
             updateViewDataFromKibanaDashboard( dashboard);
        }
        
        User user = userService.findByCurrentLoggedIn();
        dashboard.setManager(user);
        
        Dashboard result = dashboardRepository.save(dashboard);
        return result;
    }

    private void updateViewDataFromKibanaDashboard(Dashboard dashboard) {
        String height = dashboard.getSize();
        if(height == null){
            height = "600";
        }
        
        String periode = dashboard.getTimePeriode();
        String refresh = dashboard.isAuto() ? "f" : "t";
        
        String value = messageSource.getMessage("viewtype.view4",new Object[] { height, kibanaUrl, dashboard.getKibanaId(),refresh,periode }, Locale.ENGLISH);
        dashboard.setContent(value);
    }

    /**
     * Get all the dashboards.
     * @return the list of entities
     */
    @Transactional(readOnly = true)
    public List<Dashboard> findAll() {
        log.debug("Request to get all Dashboards");
        List<Dashboard> result = dashboardRepository.findAll();
        return result;
    }

    /**
     * Get one dashboard by id.
     * @param id the id of the entity
     * @return the entity
     */
    @Transactional(readOnly = true)
    public Dashboard findOne(Long id) {
        log.debug("Request to get Dashboard : {}", id);
        Dashboard dashboard = dashboardRepository.findOne(id);
        return dashboard;
    }

    /**
     * Delete the  dashboard by id.
     * @param id the id of the entity
     */
    public void delete(Long id) {
        for(MeasureView view : viewService.findByDashboard(id)){
            viewService.delete(view.getId());
        }     
        dashboardRepository.delete(id);
    }

    @Override
    public List<Dashboard> findByProject(Long projectId) {
    	User currentUser = userService.findByCurrentLoggedIn();
    	return dashboardRepository.findByProjectAndUser(projectId, currentUser.getId());
    }
    
    @Override
    public List<DashboardDTO> findDTOByProject(Long projectId) {
    	User currentUser = userService.findByCurrentLoggedIn();
    	List<Dashboard> dashboards = dashboardRepository.findByProjectAndUser(projectId, currentUser.getId());
    	List<DashboardDTO> dashboardDTOs = new ArrayList<>();
    	MappingDashboardDTO mapping = new MappingDashboardDTO();
        for (Dashboard dashboard : dashboards) {
        	DashboardDTO dashboardDTO = new DashboardDTO();
        	dashboardDTO = mapping.convertDashboardToDashboardDto(dashboard);
        	if (isCurrentUserHasManagerRole(dashboard.getId())) {
        		dashboardDTO.setHasEditionRole(true);
        	} else {
        		dashboardDTO.setHasEditionRole(false);
        	}
    		dashboardDTOs.add(dashboardDTO);
		}
    	return dashboardDTOs;
    }
    
    /**
     * Share Dashboard with User.
     * @param dashboard
     * @param userId
     * @return
     */
    public Dashboard shareDashboardWithUser(Dashboard dashboard, Long userId) {
    	User inviter = userService.findOne(userId);
    	dashboard.addUsers(inviter);
    	Dashboard result = dashboardRepository.save(dashboard);
    	return result;
    }
    
    public Dashboard removeUserOnDashboard(Dashboard dashboard, Long userId) {
    	User inviter = userService.findOne(userId);
    	dashboard.removeUsers(inviter);
    	return dashboard;
    }

	@Override
	public boolean isCurrentUserHasManagerRole(Long dashboardId) {
		User currentUser = userService.findByCurrentLoggedIn();
		Dashboard dashboard = dashboardRepository.findOne(dashboardId);
		if(dashboard.getManager().equals(currentUser)) {
			return true;
		}
		return false;
	}
	
	@Override
    public List<Dashboard> findByApplication(Long applicationId) {
        return dashboardRepository.findByApplication(applicationRepository.getOne(applicationId));
    }

}
