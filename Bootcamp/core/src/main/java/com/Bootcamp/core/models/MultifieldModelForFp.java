package com.Bootcamp.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import javax.inject.Inject;

@Model(adaptables = Resource.class,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class MultifieldModelForFp {

    @Inject
    @Default(values = "AEM")
    private String techtitle;

    @Inject
    @Default(values = "/content/dam/myapp/1.jpg")
    private String feature;

    @Inject
    @Default(values = "/content/dam/myapp/1.jpg")
    private String img;
    
    @Inject
    @Default(values = "11-04-2021")
    private String postdate;
    
    @Inject
    @Default(values = "/content/dam/myapp/1.jpg")
    private String link;
    
    @Inject
    @Default(values = "This is first featured post")
    private String description;

	public String getTechtitle() {
		return techtitle;
	}

	public void setTechtitle(String techtitle) {
		this.techtitle = techtitle;
	}

	public String getFeature() {
		return feature;
	}

	public void setFeature(String feature) {
		this.feature = feature;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getPostdate() {
		return postdate;
	}

	public void setPostdate(String postdate) {
		this.postdate = postdate;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
    
}
