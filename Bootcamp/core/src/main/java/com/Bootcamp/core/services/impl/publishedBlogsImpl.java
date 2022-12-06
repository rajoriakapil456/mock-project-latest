package com.Bootcamp.core.services.impl;

import com.Bootcamp.core.services.PublishedBlogs;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.metatype.annotations.Designate;

@Component(service = PublishedBlogs.class)
@Designate(ocd = publishedBlogsConfiguration.class)
public class publishedBlogsImpl implements PublishedBlogs {
    int blogs;

    @Activate
    public void activate(publishedBlogsConfiguration config){
        blogs = config.noOfBlogs();
    }


    @Override
    public int noOfPages() {
        return blogs;
    }
}
