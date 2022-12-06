package com.Bootcamp.core.services.impl;

import com.Bootcamp.core.services.Message;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.metatype.annotations.Designate;

@Component(service=Message.class)
@Designate(ocd=MessageConfiguration.class)
public class MessageImpl implements Message {
    String message;

    @Activate
    public void activate(MessageConfiguration config)
    {
        message=config.message_here();
    }

    @Override
    public String getMessage() {
        return message;
    }

}
