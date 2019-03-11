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
package org.measure.platform.service.smmengine.impl.logger;

import java.util.ArrayList;
import java.util.List;

import org.measure.platform.service.smmengine.api.ILoggerService;
import org.measure.smm.log.MeasureLog;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class LoggerService implements ILoggerService {
    private List<MeasureLog> logs = new ArrayList<>();

    @Override
    public List<MeasureLog> getMeasureExecutionLogs() {
        return logs;
    }

    @Override
    public void addMeasureExecutionLog(MeasureLog log) {
        if(logs.size() > 20){
            logs.remove(logs.size()-1);
        }
        logs.add(0,log);
    }

}
