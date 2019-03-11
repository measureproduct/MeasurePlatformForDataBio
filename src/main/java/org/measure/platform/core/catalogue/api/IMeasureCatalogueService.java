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
package org.measure.platform.core.catalogue.api;

import java.nio.file.Path;
import java.util.List;

import org.measure.smm.measure.api.IMeasure;
import org.measure.smm.measure.model.SMMMeasure;

/**
 * Service Interface for managing measure repository.
 */
public interface IMeasureCatalogueService {
    void storeMeasure(Path measure);

    List<SMMMeasure> getAllMeasures();

    void deleteMeasure(String measureId);
    
    SMMMeasure getMeasure(String application,String measure);

    IMeasure getMeasureImplementation(String application,String measure);

}
