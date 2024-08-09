package com.techqualitysolutions.leadrecover.manageoffer.interfaces.rest.transform;

import com.techqualitysolutions.leadrecover.manageoffer.domain.commands.RegisterOffer;
import com.techqualitysolutions.leadrecover.manageoffer.domain.model.valueobjects.Channel;
import com.techqualitysolutions.leadrecover.manageoffer.domain.model.valueobjects.Segment;
import com.techqualitysolutions.leadrecover.manageoffer.domain.model.valueobjects.Source;
import com.techqualitysolutions.leadrecover.manageoffer.interfaces.rest.resources.RegisterOfferResource;

public class RegisterOfferCommandFromResourceAssembler {
    public static RegisterOffer toCommandFromResource(RegisterOfferResource resource) {


        return new RegisterOffer(
                resource.id(),
                resource.campaignId(),
                resource.description(),
                Segment.valueOf(resource.segment().toUpperCase()),
                Channel.valueOf(resource.channel().toUpperCase()),
                Source.valueOf(resource.source().toUpperCase()),
                resource.amount(),
                resource.interestRate(),
                resource.terms(),
                resource.startDate(),
                resource.expirationDate(),
                resource.createdAt()
        );
    }
}
