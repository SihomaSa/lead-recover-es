package com.techqualitysolutions.leadrecover.publishoffer.interfaces.rest.transform;

import com.techqualitysolutions.leadrecover.publishoffer.domain.commands.SubmitOffer;
import com.techqualitysolutions.leadrecover.publishoffer.domain.model.valueobjects.Channel;
import com.techqualitysolutions.leadrecover.publishoffer.domain.model.valueobjects.PublishStatus;
import com.techqualitysolutions.leadrecover.publishoffer.domain.model.valueobjects.Segment;
import com.techqualitysolutions.leadrecover.publishoffer.domain.model.valueobjects.Source;
import com.techqualitysolutions.leadrecover.publishoffer.interfaces.rest.resources.SubmitOfferResource;

public class SubmitOfferCommandFromResourceAssembler {
    public static SubmitOffer toCommandFromResource(SubmitOfferResource resource) {


        return new SubmitOffer(
                resource.id(),
                resource.offerId(),
                resource.campaignId(),
                Segment.valueOf(resource.segment().toUpperCase()),
                Channel.valueOf(resource.channel().toUpperCase()),
                Source.valueOf(resource.source().toUpperCase()),
                PublishStatus.valueOf(resource.status().toUpperCase()),
                resource.interestRate(),
                resource.datePublish(),
                resource.updatedAt()
        );
    }
}
