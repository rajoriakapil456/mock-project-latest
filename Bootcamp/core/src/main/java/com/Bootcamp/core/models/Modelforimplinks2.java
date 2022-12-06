package com.Bootcamp.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

import java.util.List;

import javax.inject.Inject;

@Model(adaptables = Resource.class,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class Modelforimplinks2 {

    @Inject
    private List<Modelforimplinks> fieldList;

	public List<Modelforimplinks> getFieldList() {
		return fieldList;
	}
    
    
}

