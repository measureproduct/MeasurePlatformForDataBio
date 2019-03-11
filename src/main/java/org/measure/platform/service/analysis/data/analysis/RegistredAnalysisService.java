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
package org.measure.platform.service.analysis.data.analysis;

import java.util.Date;

/**
 * Analysis Service registre into Measure Platform
 *
 */
public class RegistredAnalysisService extends AnalysisService {

	private Date liveSign;
	public RegistredAnalysisService(AnalysisService service,Date liveSign) {
		this.setName(service.getName());
		this.setDescription(service.getDescription());
		this.setConfigurationURL(service.getConfigurationURL());
		this.setLiveSign(liveSign);
	}
	public Date getLiveSign() {
		return liveSign;
	}
	public void setLiveSign(Date liveSign) {
		this.liveSign = liveSign;
	}

}
