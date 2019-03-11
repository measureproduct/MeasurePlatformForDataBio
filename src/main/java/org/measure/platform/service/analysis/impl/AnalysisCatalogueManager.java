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
package org.measure.platform.service.analysis.impl;

import java.util.Date;

import javax.inject.Inject;

import org.measure.platform.core.data.api.IProjectAnalysisService;
import org.measure.platform.core.data.entity.ProjectAnalysis;
import org.measure.platform.service.analysis.api.IAnalysisCatalogueService;
import org.measure.platform.service.analysis.data.analysis.RegistredAnalysisService;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@Configuration
@EnableScheduling
public class AnalysisCatalogueManager {
	
	@Inject
	private IAnalysisCatalogueService analyseCatalogue;
	
	@Inject 
	private IProjectAnalysisService analysisService;
	
	/**
	 * Remove Analysis Service form Catalogue which are not active from more than 1 minute
	 */
    @Scheduled(fixedRate = 30000)
    public void reportCurrentTime() {
    	 for (RegistredAnalysisService service : analyseCatalogue.getAllAnalysisService()) {
             if (new Date().getTime() - service.getLiveSign().getTime() > 30000) {
            	analyseCatalogue.unregisterAnalysisService(service);        	 
             }
         }
    	 
    	 
    	 for(ProjectAnalysis analyse : analysisService.findAll()) {
    		if( analyseCatalogue.getAnalysisServiceByName(analyse.getAnalysisToolId()) == null) {
    			analysisService.delete(analyse.getId());
    		}
    	 }
    }

}
