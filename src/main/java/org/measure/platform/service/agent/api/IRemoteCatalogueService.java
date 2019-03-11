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
package org.measure.platform.service.agent.api;

import java.util.Collection;
import java.util.List;

import org.measure.platform.service.agent.data.RemoteAgent;
import org.measure.smm.measure.model.SMMMeasure;
import org.measure.smm.remote.RemoteMeasureExternal;

public interface IRemoteCatalogueService {
    void registerRemoteMeasure(SMMMeasure remoteMeasure, String agentName);

    List<SMMMeasure> getAllMeasures();

    RemoteAgent getAgent(String agentId);

    void unregisterAgent(String agentId);

    Collection<RemoteAgent> getAllAgents();

    SMMMeasure getMeasureByName(String measure, String agentId);
}
