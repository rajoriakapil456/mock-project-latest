/*
 *  Copyright 2015 Adobe Systems Incorporated
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.Bootcamp.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import com.Bootcamp.core.services.Ttn;
import com.adobe.cq.export.json.ExporterConstants;


@Model(adaptables = Resource.class)
@Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, extensions = ExporterConstants.SLING_MODEL_EXTENSION)

public class DemoModel {


	private String Name;
	private int Noe;
	private String Desc;
	private String Loc;
	private String Serv;
    
    @OSGiService
    Ttn ttn;


	public String getName() {
		Name=ttn.getName();
		return Name;
	}

	public int getNoe() {
		Noe=ttn.getNoe();
		return Noe;
	}

	public String getDesc() {
		Desc= ttn.getDesc();
		return Desc;
	}

	public String getLoc() {
		Loc= ttn.getLoc();
		return Loc;
	}

	public String getServ() {
		Serv=ttn.getServ();
		return Serv;
	}

}
