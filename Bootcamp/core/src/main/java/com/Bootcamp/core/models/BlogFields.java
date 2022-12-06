package com.Bootcamp.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

import javax.inject.Inject;

@Model(adaptables = Resource.class,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class BlogFields {

    @Inject
    private String img;

    @Inject
    private String link;

    @Inject
    private String heading;

    @Inject
    private String tags;

    @Inject
    private String subHeading;

    public String getImg() {
        return img;
    }

    public String getLink() {
        return link;
    }

    public String getHeading() {
        return heading;
    }

    public String getTags() {
        return tags;
    }

    public String getSubHeading() {
        return subHeading;
    }
}
