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
package org.measure.platform.service.analysis.api;

import org.measure.platform.service.analysis.data.alert.AlertSubscription;

public interface IAlertSubscriptionManager {
	
	/**
	 * Allow an analysis tool to subscribe to a new alert
	 * @param suscribtion Alert subscription data
	 */
	public void subscribe(AlertSubscription suscribtion);
		
	/**
	 * Unsubscribe to an alert
	 * @param alertId Id of the registred alerte
	 */
	public void unsubscribe(AlertSubscription suscribtion);

	/**
	 * Reload registered Subscribtion form database at application startup
	 */
	void init();

}
