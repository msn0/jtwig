/**
 * Copyright 2012 Lyncode
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.lyncode.jtwig.tree;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * @author "João Melo <jmelo@lyncode.com>"
 *
 */
public class JtwigFilter extends JtwigElement {
	private static Logger log = LogManager.getLogger(JtwigFilter.class);
	private String filterName;
	private List<JtwigValue> parameters;
	
	public JtwigFilter(String filterName) {
		super();
		this.filterName = filterName;
		this.parameters = new ArrayList<JtwigValue>();
		log.debug("Filter "+filterName);
	}

	public String getFilterName() {
		return filterName;
	}

	public List<JtwigValue> getParameters() {
		return parameters;
	}
	
	public boolean add (JtwigValue parameter) {
		log.debug("Adding parameter: "+parameter.toString());
		this.parameters.add(parameter);
		return true;
	}
}