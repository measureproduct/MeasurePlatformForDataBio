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
package org.measure.platform.restapi.measure;

import java.util.List;

import javax.inject.Inject;

import org.measure.platform.service.smmengine.api.ILoggerService;
import org.measure.smm.log.MeasureLog;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.codahale.metrics.annotation.Timed;

@RestController
@RequestMapping(value = "api/measure-logger")
public class MeasureLoggerResource {
    @Inject
    private ILoggerService logger;

    @Timed
    @RequestMapping(value = "/measure-execution", method = RequestMethod.GET)
    public List<MeasureLog> executeMeasure() {
        return logger.getMeasureExecutionLogs();
    }

}
