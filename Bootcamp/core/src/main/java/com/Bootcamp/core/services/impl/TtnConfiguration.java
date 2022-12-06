package com.Bootcamp.core.services.impl;

import org.osgi.service.metatype.annotations.AttributeDefinition;
//import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(name = "Ttn Configuration",description="This is TTN's configuration by Kapil")
public @interface TtnConfiguration {

	@AttributeDefinition(
			name = "Name", required = true,
			description = "Enter the name of Organization: ")
	        String setting_name();


	@AttributeDefinition(
			name = "Noe", required = true,
			description = "Enter the no. of Employees: ")
	        int setting_noe();
	
	@AttributeDefinition(
			name = "Desc", required = true,
			description = "Enter the descripion: ")
	        String setting_desc();
	
	@AttributeDefinition(
			name = "Loc", required = true,
			description = "Enter the location: ")
	        String setting_loc();
	
	@AttributeDefinition(
			name = "Serv", required = true,
			description = "Enter the services provided by the Organization: ")
	        String setting_serv();

}