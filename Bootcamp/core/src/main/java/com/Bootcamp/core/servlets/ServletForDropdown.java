package com.Bootcamp.core.servlets;

import com.adobe.cq.commerce.common.ValueMapDecorator;
import com.adobe.granite.ui.components.ds.DataSource;
import com.adobe.granite.ui.components.ds.SimpleDataSource;
import com.adobe.granite.ui.components.ds.ValueMapResource;
import com.day.cq.wcm.api.Page;
import com.day.crx.JcrConstants;
import org.apache.commons.collections4.iterators.TransformIterator;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceMetadata;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.Servlet;
import java.util.*;


@Component(
        service = Servlet.class,
        property = {
                Constants.SERVICE_DESCRIPTION + "= Dynamic Drop Down",
                //"sling.servlet.resourceTypes=" + "/apps/dropDownLIsting"
                "sling.servlet.paths=" + "/apps/dropDownLIsting"
        })
public class ServletForDropdown extends SlingSafeMethodsServlet {

    private static Logger LOGGER = LoggerFactory.getLogger(ServletForDropdown.class);

    @Override
    protected void doGet(SlingHttpServletRequest request,
                         SlingHttpServletResponse response) {
        try {
            //response.getWriter().write("Chalra hu m...");
            //Resource resource = request.getResource();
            //Resource dataSource = resource.getChild("datasource");
            //ValueMap valueMap = dataSource.getValueMap();
            //String path = valueMap.get("rootPath", String.class);
            String path = "/content/Bootcamp/us/en";
            //String selector = valueMap.get("selector", String.class);
            ResourceResolver resourceResolver = request.getResourceResolver();
            List<KeyValue> dropDownList = new ArrayList<>();

            Resource resourcePath = resourceResolver.getResource(path);

                if (resourcePath != null) {
                    Page page = resourcePath.adaptTo(Page.class);
                    if (page != null) {
                        Iterator<Page> iterator = page.listChildren();
                        List<Page> list = new ArrayList<>();
                        iterator.forEachRemaining(list::add);
                        list.forEach(pageChild -> {
                            String name = pageChild.getName();
                            String title = pageChild.getTitle();
                            dropDownList.add(new KeyValue(name, title));
                        });
                    }
            }

            @SuppressWarnings("unchecked")
            DataSource ds =
                    new SimpleDataSource(
                            new TransformIterator(
                                    dropDownList.iterator(),
                                    input -> {
                                        KeyValue keyValue = (KeyValue) input;
                                        ValueMap vm = new ValueMapDecorator(new HashMap<>());
                                        vm.put("value", keyValue.key);
                                        vm.put("text", keyValue.value);
                                        return new ValueMapResource(
                                                resourceResolver, new ResourceMetadata(),
                                                JcrConstants.NT_UNSTRUCTURED, vm);
                                    }));
            request.setAttribute(DataSource.class.getName(), ds);
        } catch (Exception e) {
            LOGGER.error("Error in Get Drop Down Values", e);
        }
    }

    private class KeyValue {

        /**
         * key property.
         */
        private String key;
        /**
         * value property.
         */
        private String value;

        /**
         * constructor instance intance.
         *
         * @param newKey   -
         * @param newValue -
         */
        private KeyValue(final String newKey, final String newValue) {
            this.key = newKey;
            this.value = newValue;
        }
    }
}
