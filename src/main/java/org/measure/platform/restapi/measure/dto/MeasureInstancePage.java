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

import org.measure.platform.core.data.entity.MeasureInstance;
import org.measure.platform.core.data.entity.MeasureView;
import org.measure.smm.measure.api.IMeasurement;

public class MeasureInstancePage {
	private MeasureView view;
	private List<IMeasurement> measurements;
	private int page;
	private int pageSize;
	private int totalMeasurements;
	
	
	public MeasureInstancePage() {
		this.measurements = new ArrayList<IMeasurement>();
	}
	
	public List<IMeasurement> getMeasurements() {
		return measurements;
	}
	public void setMeasurements(List<IMeasurement> measurements) {
		this.measurements = measurements;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalMeasurements() {
		return totalMeasurements;
	}
	public void setTotalMeasurements(int totalMeasurements) {
		this.totalMeasurements = totalMeasurements;
	}

	public MeasureView getView() {
		return view;
	}

	public void setView(MeasureView view) {
		this.view = view;
	}
}
