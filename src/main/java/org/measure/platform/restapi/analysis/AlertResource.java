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
package org.measure.platform.restapi.analysis;

import javax.inject.Inject;
import javax.validation.Valid;

import org.measure.platform.service.analysis.api.IAlertEngineService;
import org.measure.platform.service.analysis.api.IAlertSubscriptionManager;
import org.measure.platform.service.analysis.api.IAnalysisCatalogueService;
import org.measure.platform.service.analysis.data.alert.AlertReport;
import org.measure.platform.service.analysis.data.alert.AlertSubscription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codahale.metrics.annotation.Timed;

@RestController
@RequestMapping(value = "api//analysis/alert")
public class AlertResource {

	private final Logger log = LoggerFactory.getLogger(AlertResource.class);

	
	@Inject
	private IAlertEngineService alertEngineService;
	
	@Inject
	private IAlertSubscriptionManager alertSubscriptionManager;
	
	@Inject
	private IAnalysisCatalogueService catalogueService;
	
	/**
	 * PUT /subscribe : Subscribe to Alerts Events
	 * @param suscribtion Subscription informations
	 */
    @PutMapping("/subscribe")
    @Timed
    public void suscribeToNotification(@Valid @RequestBody AlertSubscription suscribtion) {
        log.debug("REST request to suscribe to AlertResource : {}", suscribtion);
        alertSubscriptionManager.subscribe(suscribtion);     
    }
    /**
     * PUT /unsubscribe : Unsubscribe to Alerts Events
     * @param suscribtion Subscription informations
     */
    @PutMapping("/unsubscribe")
    @Timed
    public void unsubscribeToNotification(@Valid @RequestBody AlertSubscription suscribtion ) {
        log.debug("REST request to unsubscribe to AlertResource : {}", suscribtion);
        alertSubscriptionManager.unsubscribe(suscribtion);     
    }
    
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public AlertReport startMeasureSheduling(@RequestParam("id") String analysisTool) {   
    	catalogueService.updateLiveSign(analysisTool);
        return alertEngineService.getAlerts(analysisTool);
    }

}
