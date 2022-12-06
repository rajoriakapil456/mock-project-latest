/*
 *  Copyright 2015 Adobe Systems Incorporated
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.Bootcamp.core.servlets;

import com.adobe.cq.commerce.common.ValueMapDecorator;
import com.adobe.granite.ui.components.ds.DataSource;
import com.adobe.granite.ui.components.ds.SimpleDataSource;
import com.adobe.granite.ui.components.ds.ValueMapResource;
import com.day.crx.JcrConstants;
import org.apache.commons.collections4.iterators.TransformIterator;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.request.RequestParameter;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceMetadata;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletPaths;
import org.apache.sling.servlets.annotations.SlingServletResourceTypes;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.propertytypes.ServiceDescription;
import org.apache.sling.api.resource.ResourceResolver;



import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//import org.json.simple.JSONObject;

/**
 * Servlet that writes some sample content into the response. It is mounted for
 * all resources of a specific Sling resource type. The
 * {@link SlingSafeMethodsServlet} shall be used for HTTP methods that are
 * idempotent. For write operations use the {@link SlingAllMethodsServlet}.
 */
@Component(service = { Servlet.class })
@SlingServletPaths(value = "/bin/myservlet2")
/*class Data{
    String firstname;
}*/
public class ServletForJson extends SlingSafeMethodsServlet {


    @Override
    protected void doGet(final SlingHttpServletRequest req,
                         final SlingHttpServletResponse resp) throws ServletException, IOException {
        //String a = req.getParameter("a");
        //String b = req.getParameter("b");
        JSONObject obj=new JSONObject();
        try {
            //JSONArray ja = new JSONArray();
            /*JSONObject jo = new JSONObject();
            //for(RequestParameter rp : )
            jo.put("1","kapil");
            jo.put("2","shivam");
            jo.put("3","sonali");
            resp.getWriter().write(jo.toString());*/
            ResourceResolver resourceResolver = req.getResourceResolver();
            JSONArray jsonArr = new JSONArray("[{'firstname':'kapil'},{'firstname':'shivam'},{'firstname':'sonali'}]");
            List<Data> dataList = new ArrayList<>();
            List<KeyValue> dropDownList = new ArrayList<>();
            for (int i = 0; i < jsonArr.length(); i++) {

                JSONObject jsonObj = jsonArr.getJSONObject(i);
                Data data = new Data();

                data.firstname = jsonObj.getString("firstname");


                dataList.add(data);
            }

            //resp.getWriter().write("chlra hu..");
            int i=0;
            for(Data s: dataList) {
               //resp.getWriter().write(s.firstname);
                dropDownList.add(new KeyValue(Integer.toString(i), s.firstname));
                i+=1;
           }

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
            req.setAttribute(DataSource.class.getName(), ds);


        } catch (JSONException e) {
            throw new RuntimeException(e);
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
