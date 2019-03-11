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
package org.measure.platform.service.application.impl.dto;


public class ApplicationProperty {
	
	private String name;
	
	private String description;
	
	private ApplicationPropertyType type;
	
	private ApplicationPropertyEnum enumType;
	
	private String value;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ApplicationPropertyType getType() {
		return type;
	}

	public void setType(ApplicationPropertyType type) {
		this.type = type;
	}

	public ApplicationPropertyEnum getEnumType() {
		return enumType;
	}

	public void setEnumType(ApplicationPropertyEnum enumType) {
		this.enumType = enumType;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	
}
