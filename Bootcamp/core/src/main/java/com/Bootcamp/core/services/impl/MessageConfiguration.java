package com.Bootcamp.core.services.impl;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(name="Message Configuration")
public @interface MessageConfiguration {

    @AttributeDefinition(
            name = "Message", required = true,
            description = "Enter your message here: "
    ) String message_here();

}
