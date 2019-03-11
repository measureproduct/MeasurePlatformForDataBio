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
package org.measure.platform.service.smmengine.api;

import java.util.Date;

import org.measure.platform.core.data.entity.MeasureInstance;
import org.measure.smm.log.MeasureLog;
import org.measure.smm.measure.api.IMeasure;

public interface IMeasureExecutionService {
    MeasureLog executeMeasure(MeasureInstance measure, IMeasure measureImpl);

    MeasureLog testMeasure(Long measureInstanceId);

    MeasureLog executeMeasure(Long instanceId);

	MeasureLog executeMeasure(Long instanceId, Date logDate,String dateField);

}
