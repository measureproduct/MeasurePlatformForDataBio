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
package org.measure.platform.service.analysis.data.alert;

import java.util.Arrays;
import java.util.List;

public enum AlertType {	
	ANALYSIS_ENABLE(Arrays.asList("ANALYSISTOOL"),Arrays.asList("ANALYSISID")),
	ANALYSIS_DESABLE(Arrays.asList("ANALYSISTOOL"),Arrays.asList("ANALYSISID")),
	MEASURE_ADDED(Arrays.asList(),Arrays.asList("MEASUREID")),
	MEASURE_REMOVED(Arrays.asList(),Arrays.asList("MEASUREID")),
	MEASURE_SCHEDULED(Arrays.asList(),Arrays.asList("MEASUREID")),
	MEASURE_UNSCHEDULED(Arrays.asList(),Arrays.asList("MEASUREID"));
	
	private List<String> requestProperties;
	
	private List<String> responsProperties;

	
	private AlertType(List<String> requestProperties,List<String> responsProperties){	
		this.requestProperties = requestProperties;
		this.responsProperties = responsProperties;
	}
	
	public List<String> getRequestProperties(){
		return this.requestProperties;
	}
	

	public List<String> getResponsProperties() {
		return responsProperties;
	}

	public static AlertType fromString(String value){
		if("ANALYSIS_ENABLE".equals(value)){
			return ANALYSIS_ENABLE;			
		}else if("ANALYSIS_DESABLE".equals(value)){
			return ANALYSIS_DESABLE;			
		}else if("MEASURE_ADDED".equals(value)){
			return MEASURE_ADDED;		
		}else if("MEASURE_REMOVED".equals(value)){
			return MEASURE_REMOVED;		
		}else if("MEASURE_SCHEDULED".equals(value)){
			return MEASURE_SCHEDULED;			
		}else if("MEASURE_UNSCHEDULED".equals(value)){
			return MEASURE_UNSCHEDULED;			
		}
		
		return null;
	}
}
