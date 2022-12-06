package com.Bootcamp.core.servlets;

import javax.jcr.Node;
import javax.jcr.RepositoryException;
import javax.servlet.Servlet;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.ModifiableValueMap;
import org.apache.sling.api.resource.PersistenceException;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(service = Servlet.class, property = { Constants.SERVICE_DESCRIPTION + "=Simple Demo Servlet",
		"sling.servlet.methods=" + HttpConstants.METHOD_POST, "sling.servlet.paths=" + "/bin/submitdata" })
public class SampleSlingPostServlet extends SlingAllMethodsServlet {

	private static final long serialVersionUID = -159625176093879129L;
	
	private static final Logger log = LoggerFactory.getLogger(SampleSlingPostServlet.class);
	
	@Override
	protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response) {

		try {
			
			
			ResourceResolver resourceResolver = request.getResourceResolver();
			

			//Resource resource = resourceResolver.getResource("/content");
			Resource resource2 = resourceResolver.getResource("/content/Bootcamp/us/en/temppage/jcr:content/root/container/comment");
			
			log.info("Resource is at path {}", resource2.getPath());

			//Node node = resource.adaptTo(Node.class);
			//Node node2 = resource2.adaptTo(Node.class);

			
			//Node newNode = node.addNode("demoNode", "nt:unstructured");
			//newNode.setProperty("name", "Demo Node");
			
			
			//Node n2 = node2.getNode("/apps/Bootcamp/components/Comment");
			//n2.setProperty("Name","kapil rajoria"); 
			
		
			//node2.setProperty("Name", "Kapil r");
			//node2.getSession().save();
			
			ModifiableValueMap map = resource2.adaptTo(ModifiableValueMap.class);
			map.put("Name", "Kapil r");
			resource2.getResourceResolver().commit();
			
			//resourceResolver.commit();
			
		
		} catch (PersistenceException e) {
			
			log.error(e.getMessage(), e);
			
			e.printStackTrace();		
		}
	}
}
