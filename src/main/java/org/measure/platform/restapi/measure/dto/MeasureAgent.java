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
package org.measure.platform.restapi.measure.dto;

import java.util.ArrayList;
import java.util.List;

import org.measure.smm.measure.model.SMMMeasure;

public class MeasureAgent {
    private String agentName;

    private List<SMMMeasure> providedMeasures;

    public MeasureAgent() {
        this.providedMeasures = new ArrayList<>();
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public List<SMMMeasure> getProvidedMeasures() {
        return providedMeasures;
    }

    public void setProvidedMeasures(List<SMMMeasure> providedMeasures) {
        this.providedMeasures = providedMeasures;
    }

}
