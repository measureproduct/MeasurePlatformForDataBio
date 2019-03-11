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
package org.measure.platform.service.analysis.api;

import java.util.List;

import org.measure.platform.service.analysis.data.analysis.AnalysisService;
import org.measure.platform.service.analysis.data.analysis.RegistredAnalysisService;

public interface IAnalysisCatalogueService {
	
	
	/**
	 * Register a new AnalysisService
	 * @param service The service to register
	 */
	public void registerAnalysisService(AnalysisService service);
	
	/**
	 * Unregister an analysis service
	 * @param service The service to unregister
	 */
	public void unregisterAnalysisService(AnalysisService service);
	
	/**
	 * Find an Analysis Service by is name
	 * @param name The name of the required service
	 * @return The find analysis service
	 */
	public AnalysisService getAnalysisServiceByName(String name);
	
	/**
	 * Find all registred analysis service
	 * @return List of all analysis services
	 */
	public List<RegistredAnalysisService> getAllAnalysisService();

	
	/**
	 * 
	 * @param analysisTool
	 */
	void updateLiveSign(String analysisTool);

}
