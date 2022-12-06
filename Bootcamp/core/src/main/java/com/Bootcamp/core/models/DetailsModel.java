package com.Bootcamp.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = Resource.class)

public class DetailsModel {
	@ValueMapValue
	private String title;
	@ValueMapValue
	private String link;
	@ValueMapValue
	private String putasset;
	
	public String getTitle()
	{
		return title;
	}
	public String getLink()
	{
		return link;
	}
	public String getPutasset()
	{
		return putasset;
	}
}
