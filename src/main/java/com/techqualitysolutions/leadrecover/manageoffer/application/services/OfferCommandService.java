package com.techqualitysolutions.leadrecover.manageoffer.application.services;

import com.techqualitysolutions.leadrecover.manageoffer.application.validators.EditOfferValidator;
import com.techqualitysolutions.leadrecover.manageoffer.application.validators.RegisterOfferValidator;
import com.techqualitysolutions.leadrecover.manageoffer.domain.commands.EditOffer;
import com.techqualitysolutions.leadrecover.manageoffer.domain.commands.RegisterOffer;
import com.techqualitysolutions.leadrecover.shared.domain.model.valueobjects.Notification;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Component;

@Component
public class OfferCommandService {
    private final CommandGateway commandGateway;
    private final RegisterOfferValidator registerOfferValidator;
    private final EditOfferValidator editOfferValidator;

    public OfferCommandService(CommandGateway commandGateway, RegisterOfferValidator registerOfferValidator, EditOfferValidator editOfferValidator) {
        this.commandGateway = commandGateway;
        this.registerOfferValidator = registerOfferValidator;
        this.editOfferValidator = editOfferValidator;
    }


    public Notification register(RegisterOffer command) throws Exception {
        Notification notification = this.registerOfferValidator.validate(command);
        if (notification.hasErrors()) return notification;
        commandGateway.sendAndWait(command);
        return notification;
    }

    public Notification edit(EditOffer command) throws Exception {
        Notification notification = this.editOfferValidator.validate(command);
        if (notification.hasErrors()) return notification;
        commandGateway.sendAndWait(command);
        return notification;
    }
}
