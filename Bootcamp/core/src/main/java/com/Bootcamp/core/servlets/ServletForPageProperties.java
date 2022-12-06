package com.Bootcamp.core.servlets;


import com.day.cq.commons.jcr.JcrConstants;
import com.day.cq.wcm.api.Page;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.propertytypes.ServiceDescription;

import javax.jcr.Node;
import javax.jcr.RepositoryException;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;
import java.util.Objects;

import static org.apache.sling.api.servlets.ServletResolverConstants.SLING_SERVLET_METHODS;
import static org.apache.sling.api.servlets.ServletResolverConstants.SLING_SERVLET_RESOURCE_TYPES;

@Component(service = { Servlet.class },
property = {SLING_SERVLET_RESOURCE_TYPES+"=/apps/Bootcamp/components/page",
            SLING_SERVLET_METHODS+"=GET"
}
)

@ServiceDescription("Simple Demo Servlet")
public class ServletForPageProperties extends SlingSafeMethodsServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(final SlingHttpServletRequest req,
                         final SlingHttpServletResponse resp) throws ServletException, IOException {
        final Resource resource2 = req.getResource();
        resp.setContentType("text/plain");
        resp.getWriter().write("Title = " + resource2.getValueMap().get(JcrConstants.JCR_TITLE)+"\n");
        resp.getWriter().write("Created = " + resource2.getValueMap().get(JcrConstants.JCR_CREATED)+"\n");
        resp.getWriter().write("Created by = " + resource2.getValueMap().get(JcrConstants.JCR_CREATED_BY)+"\n");
        resp.getWriter().write("Data = " + resource2.getValueMap().get(JcrConstants.JCR_DATA)+"\n");
        resp.getWriter().write("Child = " + resource2.getValueMap().get(JcrConstants.JCR_CHILD)+"\n");
        resp.getWriter().write("Last modified by = " + resource2.getValueMap().get(JcrConstants.JCR_LAST_MODIFIED_BY)+"\n");
        resp.getWriter().write("Primary Type = " + resource2.getValueMap().get(JcrConstants.JCR_PRIMARYTYPE)+"\n");
        resp.getWriter().write("Path = " + resource2.getValueMap().get(JcrConstants.JCR_PATH)+"\n");
        resp.getWriter().write("CND = " + resource2.getValueMap().get(JcrConstants.JCR_CHILDNODEDEFINITION)+"\n");
        resp.getWriter().write("R_Children = " + resource2.getChildren() +"\n");
        resp.getWriter().write("R_Name = " + resource2.getName() +"\n");
        resp.getWriter().write("R_Resource Type = " + resource2.getResourceType() +"\n");
        resp.getWriter().write("R_Parent = " + resource2.getParent() +"\n");

        resp.getWriter().write("\n\n\n\n");

        String a = req.getParameter("a");
        resp.getWriter().write("Name is : " + a);
        String b = req.getParameter("b");
        resp.getWriter().write("Value is : " + b);

        resp.getWriter().write("\n\n\n\n");



        String requestURI = req.getRequestURI();
        String currentpagePath = requestURI.substring(0, requestURI.lastIndexOf("/"));
        resp.getWriter().write(currentpagePath);
        resp.getWriter().write("\n\n\n\n");
        ResourceResolver resourceResolver = req.getResourceResolver();
        Resource r = resourceResolver.getResource(currentpagePath);
        Resource resource = resourceResolver.getResource(currentpagePath+"/jcr:content");
        if (Objects.nonNull(r) && r.isResourceType("cq:Page")) {
            Page page = r.adaptTo(Page.class);
            ValueMap pageproperties = page.getProperties();
            try {
                resp.getWriter().println(pageproperties);
            }
            catch (IOException e) {

                e.printStackTrace();
            }
        }

        //ModifiableValueMap map = resource.adaptTo(ModifiableValueMap.class);
        //map.put(a,b);
        //resource.getResourceResolver().commit();
        try{
            /*ResourceResolver resourceResolver3 = req.getResourceResolver();
            Resource resource3 = resourceResolver3.getResource("/content");

            Node node3 = resource3.adaptTo(Node.class);
            Node newNode3 = node3.addNode("demoNodepavnesh", "nt:unstructured");
            newNode3.setProperty(a,b);*/

            //resourceResolver.commit();
            Node node = resource.adaptTo(Node.class);
            node.setProperty(a,b);
            resp.getWriter().write("\n\nbhai hogaa...\n\n");
        }

        catch (RepositoryException e) {
                resp.getWriter().write("\n\nbhai ham catch me aage...try me ja\n\n");
                e.printStackTrace();
            }


        resourceResolver.commit();
    }
}
