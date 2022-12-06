package com.Bootcamp.core.servlets;

import com.Bootcamp.core.models.ResolverUtil;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.servlet.Servlet;
import javax.servlet.ServletException;

import java.io.IOException;

import static org.apache.sling.api.servlets.ServletResolverConstants.*;


@Component(
service = { Servlet.class },
property = { 
    SLING_SERVLET_RESOURCE_TYPES + "=/apps/my/type",
    SLING_SERVLET_METHODS + "=GET",
    SLING_SERVLET_EXTENSIONS + "=html",
    SLING_SERVLET_SELECTORS + "=hello",
  }
)


public class MyServlet extends SlingSafeMethodsServlet {
    @Reference
    ResourceResolverFactory resolverFactory;
    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException {
       try{
    	   ResourceResolver resourceResolver = ResolverUtil.newResolver(resolverFactory);
       String title =resourceResolver.getResource("/content/Bootcamp/jcr:content").getValueMap().get("jcr:title",String.class);
       response.setContentType("text/plain");
       response.getWriter().write(title);
       }
       catch(LoginException e) {throw new RuntimeException(e);}
    }
}
