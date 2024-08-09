package com.techqualitysolutions.leadrecover.improvepersonalization.application.services;

import com.techqualitysolutions.leadrecover.improvepersonalization.application.validators.GetDiscountValidator;
import com.techqualitysolutions.leadrecover.improvepersonalization.domain.commands.GetDiscount;
import com.techqualitysolutions.leadrecover.shared.domain.model.valueobjects.Notification;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Component;

@Component
public class AnalyticCommandService {
    private final CommandGateway commandGateway;
    private final GetDiscountValidator getDiscountValidator;

    public AnalyticCommandService(CommandGateway commandGateway, GetDiscountValidator registerOfferValidator) {
        this.commandGateway = commandGateway;
        this.getDiscountValidator = registerOfferValidator;
    }


    public Notification getDiscount(GetDiscount command) throws Exception {
        Notification notification = this.getDiscountValidator.validate(command);
        if (notification.hasErrors()) return notification;
        commandGateway.sendAndWait(command);
        return notification;
    }

}
