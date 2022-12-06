package com.Bootcamp.core.models;

import com.day.cq.commons.Externalizer;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.settings.SlingSettingsService;

import javax.inject.Inject;
import java.util.Set;

@Model(adaptables = {SlingHttpServletRequest.class, Resource.class},defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)

public class ModelForMessage {

    @Inject
    SlingSettingsService slingSettingsService;

    public boolean isAuthorRunMode() {
        Set<String> runModes = slingSettingsService.getRunModes();
        return runModes.contains(Externalizer.AUTHOR);
    }
}
