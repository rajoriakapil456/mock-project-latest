package com.Bootcamp.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

import javax.inject.Inject;

@Model(adaptables = Resource.class,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class BlogsHomepage {

    @Inject
    private String postLink;


    @Inject
    private String img;

    @Inject
    private String postTag;

    @Inject
    private String postTitle;

    @Inject
    private String postDescription;

    public String getPostLink() {
        return postLink;
    }

    public String getPostTag() {
        return postTag;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public String getPostDescription() {
        return postDescription;
    }

    public String getImg() {
        return img;
    }

}
