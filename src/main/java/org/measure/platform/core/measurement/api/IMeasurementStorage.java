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
package org.measure.platform.core.measurement.api;

import java.util.List;

import org.measure.platform.restapi.measure.dto.KibanaVisualisation;
import org.measure.smm.measure.api.IMeasurement;

public interface IMeasurementStorage {
    
    void putMeasurement(String measureInstance, IMeasurement measurement);

    List<IMeasurement> getMeasurement(String measureId, Integer numberRef, String filter);

    List<KibanaVisualisation> findKibanaVisualisation();

    List<KibanaVisualisation> findKibanaDashboard();

	List<IMeasurement> getMeasurementPage(String measureInstance, Integer size, Integer page, String filter);
	
	
	IMeasurement getLastMeasurement(String measureInstance);

}
