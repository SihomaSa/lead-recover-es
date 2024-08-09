package com.techqualitysolutions.leadrecover.publishoffer.application.services;

import com.techqualitysolutions.leadrecover.publishoffer.application.validators.DiscardOfferValidator;
import com.techqualitysolutions.leadrecover.publishoffer.application.validators.PublishOfferValidator;
import com.techqualitysolutions.leadrecover.publishoffer.application.validators.SubmitOfferValidator;
import com.techqualitysolutions.leadrecover.publishoffer.application.validators.UnPublishOfferValidator;
import com.techqualitysolutions.leadrecover.publishoffer.domain.commands.DiscardOffer;
import com.techqualitysolutions.leadrecover.publishoffer.domain.commands.PublishOffer;
import com.techqualitysolutions.leadrecover.publishoffer.domain.commands.SubmitOffer;
import com.techqualitysolutions.leadrecover.publishoffer.domain.commands.UnPublishOffer;
import com.techqualitysolutions.leadrecover.shared.domain.model.valueobjects.Notification;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Component;

@Component
public class PublishCommandService {
    private final CommandGateway commandGateway;
    private final SubmitOfferValidator submitOfferValidator;
    private final DiscardOfferValidator discardOfferValidator;
    private final PublishOfferValidator publishOfferValidator;
    private final UnPublishOfferValidator unPublishOfferValidator;

    public PublishCommandService(CommandGateway commandGateway, SubmitOfferValidator submitOfferValidator, DiscardOfferValidator discardOfferValidator, PublishOfferValidator publishOfferValidator, UnPublishOfferValidator unPublishOfferValidator) {
        this.commandGateway = commandGateway;
        this.submitOfferValidator = submitOfferValidator;
        this.discardOfferValidator = discardOfferValidator;
        this.publishOfferValidator = publishOfferValidator;
        this.unPublishOfferValidator = unPublishOfferValidator;
    }

    public Notification submit(SubmitOffer command) throws Exception {
        Notification notification = this.submitOfferValidator.validate(command);
        if (notification.hasErrors()) return notification;
        commandGateway.sendAndWait(command);
        return notification;
    }

    public Notification discard(DiscardOffer command) throws Exception {
        Notification notification = this.discardOfferValidator.validate(command);
        if (notification.hasErrors()) return notification;
        commandGateway.sendAndWait(command);
        return notification;
    }


    public Notification publish(PublishOffer command) throws Exception {
        Notification notification = this.publishOfferValidator.validate(command);
        if (notification.hasErrors()) return notification;
        commandGateway.sendAndWait(command);
        return notification;
    }


    public Notification unPublish(UnPublishOffer command) throws Exception {
        Notification notification = this.unPublishOfferValidator.validate(command);
        if (notification.hasErrors()) return notification;
        commandGateway.sendAndWait(command);
        return notification;
    }
}
