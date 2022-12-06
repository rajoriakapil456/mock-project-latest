package com.Bootcamp.core.servlets;

import java.io.IOException;
import java.util.Set;

import javax.inject.Inject;
import javax.servlet.Servlet;
import javax.servlet.ServletException;

import com.Bootcamp.core.models.ModelForMessage;
import com.day.cq.commons.Externalizer;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.servlets.annotations.SlingServletPaths;
import org.apache.sling.settings.SlingSettingsService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;
import org.osgi.service.component.annotations.Reference;

import com.Bootcamp.core.services.Message;

@Component(service = { Servlet.class })
@SlingServletPaths(value = "/bin/myservlet")

public class ServletForMessage extends SlingSafeMethodsServlet {

    private static final long serialVersionUID = 1L;

    @Reference
    Message message;


    @Override
    protected void doGet(final SlingHttpServletRequest req,
                         final SlingHttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write(message.getMessage());
        //resp.getWriter().write(message.getPublishMessage());

    }

}
