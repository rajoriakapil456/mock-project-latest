package com.Bootcamp.core.models;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
 
import org.apache.sling.models.annotations.Model;

@Model(adaptables = Resource.class)
public class Modelformycarousel {
	 
    @Inject
    private List<DetailsModel> details; 
    
    public List<DetailsModel> getDetails() 
    {
    return new ArrayList<>(details);
    }
}
