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
package org.measure.platform.service.agent.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.measure.platform.service.agent.api.IRemoteCatalogueService;
import org.measure.platform.service.agent.data.RemoteAgent;
import org.measure.smm.measure.model.SMMMeasure;
import org.measure.smm.remote.RemoteMeasureExternal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope(value = "singleton")
public class AgentCatalogueService implements IRemoteCatalogueService {
    private final Logger log = LoggerFactory.getLogger(AgentCatalogueService.class);

    private Map<String, RemoteAgent> agentMap = new HashMap<>();

    @Override
    public void registerRemoteMeasure(SMMMeasure remoteMeasure, String agentName) {
        RemoteAgent agent = agentMap.get(agentName);
        
        if(agent == null){
            agent = new RemoteAgent(agentName);
            agentMap.put(agentName, agent);
        }
        
        
        if(!agent.getMeasures().containsKey(remoteMeasure.getName())){
            agent.getMeasures().put(remoteMeasure.getName(),remoteMeasure);
        }
        
        log.info("Register Remote Measure \"" +remoteMeasure.getName()+ "\" form " + agentName);
    }

    @Override
    public List<SMMMeasure> getAllMeasures() {
        List<SMMMeasure> result = new ArrayList<>();    
        for(RemoteAgent agent : agentMap.values()){
            result.addAll(agent.getMeasures().values());
        }
        return result;
    }

    @Override
    public RemoteAgent getAgent(String agentId) {
        return agentMap.get(agentId);
    }

    @Override
    public void unregisterAgent(String agentId) {
        agentMap.remove(agentId);
    }

    @Override
    public Collection<RemoteAgent> getAllAgents() {
        return this.agentMap.values();
    }

    @Override
    public SMMMeasure getMeasureByName(String measure, String agentId) {
        RemoteAgent agent = this.agentMap.get(agentId);
        if(agent != null){
            return agent.getMeasures().get(measure);
        }
        return null;
    }


}
