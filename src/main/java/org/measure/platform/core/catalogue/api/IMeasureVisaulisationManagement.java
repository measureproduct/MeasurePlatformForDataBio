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

import java.util.List;

import org.measure.platform.core.data.entity.Dashboard;
import org.measure.platform.core.data.entity.MeasureInstance;
import org.measure.platform.core.data.entity.MeasureView;
import org.measure.smm.measure.model.SMMMeasure;
import org.measure.smm.measure.model.View;

public interface IMeasureVisaulisationManagement {

	String formatViewDataAsAnalysisCard(MeasureView measureView);

	String formatViewDataAsKibanaDashboardReference(MeasureView measureView);

	String formatViewDataAsKibanaViewReference(MeasureView measureView);

	String formatViewDataAsKibanaURL(MeasureView measureView);

	List<MeasureView> createDefaultMeasureView(SMMMeasure measure, Long measureInstanceId);

	MeasureView createDefaultMeasureView(SMMMeasure measure, Long measureInstanceId, String viewName);

	MeasureView createMeasureView(View mView, Dashboard dashboard, MeasureInstance measure);

}
