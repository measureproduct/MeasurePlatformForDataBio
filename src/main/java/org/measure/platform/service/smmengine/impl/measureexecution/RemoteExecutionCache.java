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
package org.measure.platform.service.smmengine.impl.measureexecution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.measure.smm.remote.RemoteMeasureExternal;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class RemoteExecutionCache {
	
	private Map<String,List<RemoteMeasureExternal>> pendingExecutions = new HashMap<>();

	public List<RemoteMeasureExternal> getPendingExecutione(String agentId) {
		 List<RemoteMeasureExternal>  result =  pendingExecutions.get(agentId);
		 if(result != null){
			 pendingExecutions.put(agentId, new ArrayList<>());		 
			 return result;
		 }	 
		return new ArrayList<>();
	}
	
	
	public void registerSingleMeasureExecution(RemoteMeasureExternal executionRequest) {
		String agentId = executionRequest.getMeasureName().substring(executionRequest.getMeasureName().indexOf("(") +1, executionRequest.getMeasureName().length() - 1) ;

		List<RemoteMeasureExternal> agentExecs = pendingExecutions.get(agentId);
		if (agentExecs == null) {
			agentExecs = new ArrayList<>();
		}
		agentExecs.add(executionRequest);
		pendingExecutions.put(agentId, agentExecs);
	}
}
