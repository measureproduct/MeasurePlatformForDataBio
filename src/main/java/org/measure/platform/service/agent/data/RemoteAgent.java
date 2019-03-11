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
package org.measure.platform.service.agent.data;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.measure.smm.measure.model.SMMMeasure;

public class RemoteAgent {
    private Map<String, SMMMeasure> measures;

    private String label;

    private Date lastLifeSign;

    public RemoteAgent(String label) {
        this.label = label;
        this.lastLifeSign = new Date();
        this.measures = new HashMap<>();
    }

    public Map<String, SMMMeasure> getMeasures() {
        return measures;
    }

    public void setMeasures(Map<String, SMMMeasure> measures) {
        this.measures = measures;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Date getLastLifeSign() {
        return lastLifeSign;
    }

    public void setLastLifeSign(Date lastLifeSign) {
        this.lastLifeSign = lastLifeSign;
    }

}
