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
package org.measure.platform.restapi.application;

import javax.inject.Inject;

import org.measure.platform.core.data.api.IApplicationService;
import org.measure.platform.core.data.api.IMeasureInstanceService;
import org.measure.platform.core.data.entity.Application;
import org.measure.platform.core.data.entity.MeasureInstance;
import org.measure.platform.service.analysis.data.alert.AlertData;
import org.measure.platform.service.analysis.data.alert.AlertProperty;
import org.measure.platform.service.analysis.data.alert.AlertType;
import org.measure.platform.service.application.api.IApplicationConfigurationService;
import org.measure.platform.service.application.api.IApplicationScheduling;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/application-execution")

public class ApplicationExecutionResource {

	private final Logger log = LoggerFactory.getLogger(ApplicationExecutionResource.class);
	
	
	@Inject
	private IApplicationScheduling applicationInstanceService;
	
    @RequestMapping(value = "/start", method = RequestMethod.GET)
    public Boolean startApplicationInstanceScheduling(@RequestParam("id") String id) {
    	log.debug("Request to start scheduling application instance id : " + id);

        if (id.matches("\\d+")) {
            Long instanceId = Long.valueOf(id);
            
            return applicationInstanceService.startApplication(instanceId);
        }
        return false;
    }

    @RequestMapping(value = "/stop", method = RequestMethod.GET)
    public Boolean stopApplicationInstanceScheduling(@RequestParam("id") String id) {
    	log.debug("Request to stop scheduling application instance id : " + id);
        if (id.matches("\\d+")) {
            Long instanceId = Long.valueOf(id);    
            return applicationInstanceService.stopApplication(instanceId);

        }
        return false;
    }


}
