package com.techqualitysolutions.leadrecover.publishoffer.interfaces.rest.transform;

import com.techqualitysolutions.leadrecover.publishoffer.domain.commands.DiscardOffer;
import com.techqualitysolutions.leadrecover.publishoffer.domain.commands.PublishOffer;
import com.techqualitysolutions.leadrecover.publishoffer.domain.commands.SubmitOffer;
import com.techqualitysolutions.leadrecover.publishoffer.domain.commands.UnPublishOffer;
import com.techqualitysolutions.leadrecover.publishoffer.domain.model.valueobjects.PublishStatus;
import com.techqualitysolutions.leadrecover.publishoffer.interfaces.rest.resources.PublishResource;

public class PublishResourceFromCommandAssembler {
    public static PublishResource toResourceFromSubmitOffer(SubmitOffer command) {
        return new PublishResource(
                command.getId(),
                command.getOfferId(),
                command.getCampaignId(),
                command.getSegment().name(),
                command.getChannel().name(),
                command.getSource().name(),
                PublishStatus.SUBMITED.name(),
                command.getInterestRate(),
                command.getDatePublish()
        );
    }

    public static PublishResource toResourceFromDiscardOffer(DiscardOffer command) {
        return new PublishResource(
                command.getId(),
                command.getOfferId(),
                command.getCampaignId(),
                command.getSegment().name(),
                command.getChannel().name(),
                command.getSource().name(),
                command.getStatus().name(),
                command.getInterestRate(),
                command.getDatePublish()
        );
    }

    public static PublishResource toResourceFromPublishOffer(PublishOffer command) {
        return new PublishResource(
                command.getId(),
                command.getOfferId(),
                command.getCampaignId(),
                command.getSegment().name(),
                command.getChannel().name(),
                command.getSource().name(),
                command.getStatus().name(),
                command.getInterestRate(),
                command.getDatePublish()
        );
    }

    public static PublishResource toResourceFromUnPublishOffer(UnPublishOffer command) {
        return new PublishResource(
                command.getId(),
                command.getOfferId(),
                command.getCampaignId(),
                command.getSegment().name(),
                command.getChannel().name(),
                command.getSource().name(),
                command.getStatus().name(),
                command.getInterestRate(),
                command.getDatePublish()
        );
    }
}
