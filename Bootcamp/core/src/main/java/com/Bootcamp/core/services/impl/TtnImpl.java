package com.Bootcamp.core.services.impl;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
//import org.osgi.service.component.annotations.Deactivate;
//import org.osgi.service.component.annotations.Modified;
import org.osgi.service.metatype.annotations.Designate;

import com.Bootcamp.core.services.Ttn;


@Component(service = Ttn.class, immediate = true)
@Designate(ocd = TtnConfiguration.class)
public class TtnImpl implements Ttn {

	String Name;
	int Noe;
	String Desc;
	String Loc;
	String Serv;


	@Activate
	public void activate(TtnConfiguration config) {
		Name = config.setting_name();
		Noe = config.setting_noe();
		Desc = config.setting_desc();
		Loc = config.setting_loc();
		Serv = config.setting_serv();
	}


	public String getName() {
		return Name;
	}


	public int getNoe() {
		return Noe;
	}


	public String getDesc() {
		return Desc;
	}


	public String getLoc() {
		return Loc;
	}


	public String getServ() {
		return Serv;
	}

}