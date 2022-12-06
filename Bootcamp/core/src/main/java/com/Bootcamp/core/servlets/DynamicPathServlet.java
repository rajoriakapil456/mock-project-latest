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

import static org.apache.sling.api.servlets.ServletResolverConstants.*;

@Component(service = { Servlet.class },
property = {SLING_SERVLET_RESOURCE_TYPES+"=/apps/Bootcamp/components/page",
            SLING_SERVLET_METHODS+"=GET",
            SLING_SERVLET_SELECTORS+"=hello",
            SLING_SERVLET_EXTENSIONS+"=html"
}
)

@ServiceDescription("Simple Demo Servlet")
public class DynamicPathServlet extends SlingSafeMethodsServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(final SlingHttpServletRequest req,
                         final SlingHttpServletResponse resp) throws ServletException, IOException {
        final Resource resource2 = req.getResource();
        resp.setContentType("text/plain");

        String path = req.getParameter("path");
        resp.getWriter().write("Path is : " + path);

        try{
            ResourceResolver resourceResolver = req.getResourceResolver();
            Resource resource = resourceResolver.getResource(path);

            Node node = resource.adaptTo(Node.class);
            Node newNode = node.addNode("KapilNode", "nt:unstructured");
            newNode.setProperty("Kapil","Rajoria");
            resourceResolver.commit();
            resp.getWriter().write("\n\nNode Created at the specified path successfully!\n\n");
        }

        catch (RepositoryException e) {
                e.printStackTrace();
            }

    }
}
