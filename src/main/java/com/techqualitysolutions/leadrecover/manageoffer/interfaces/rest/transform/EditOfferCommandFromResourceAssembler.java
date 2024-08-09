package com.techqualitysolutions.leadrecover.manageoffer.interfaces.rest.transform;

import com.techqualitysolutions.leadrecover.manageoffer.domain.commands.EditOffer;
import com.techqualitysolutions.leadrecover.manageoffer.domain.model.valueobjects.Channel;
import com.techqualitysolutions.leadrecover.manageoffer.domain.model.valueobjects.OfferStatus;
import com.techqualitysolutions.leadrecover.manageoffer.domain.model.valueobjects.Segment;
import com.techqualitysolutions.leadrecover.manageoffer.domain.model.valueobjects.Source;
import com.techqualitysolutions.leadrecover.manageoffer.interfaces.rest.resources.EditOfferResource;

public class EditOfferCommandFromResourceAssembler {
    public static EditOffer toCommandFromResource(EditOfferResource resource) {
        return new EditOffer(
            resource.id(),
            resource.campaignId(),
            resource.description(),
                Segment.valueOf(resource.segment().toUpperCase()),
                Channel.valueOf(resource.channel().toUpperCase()),
                Source.valueOf(resource.source().toUpperCase()),
                OfferStatus.valueOf(resource.status().toUpperCase()),
                resource.amount(),
                resource.interestRate(),
                resource.terms(),
                resource.startDate(),
                resource.expirationDate(),
            resource.updatedAt());
    }
}
