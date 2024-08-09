package com.techqualitysolutions.leadrecover.manageoffer.interfaces.rest.transform;

import com.techqualitysolutions.leadrecover.manageoffer.domain.commands.EditOffer;
import com.techqualitysolutions.leadrecover.manageoffer.domain.commands.RegisterOffer;
import com.techqualitysolutions.leadrecover.manageoffer.domain.model.valueobjects.OfferStatus;
import com.techqualitysolutions.leadrecover.manageoffer.domain.model.valueobjects.Segment;
import com.techqualitysolutions.leadrecover.manageoffer.interfaces.rest.resources.OfferResource;

public class OfferResourceFromCommandAssembler {
    public static OfferResource toResourceFromRegisterOffer(RegisterOffer command) {
        return new OfferResource(
                command.getId(),
                command.getCampaignId(),
                command.getDescription(),
                command.getSegment().name(),
                command.getChannel().name(),
                command.getSource().name(),
                OfferStatus.STARTED.name(),
                command.getAmount(),
                command.getInterestRate(),
                command.getTerms(),
                command.getStartDate(),
                command.getExpirationDate()
        );
    }

    public static OfferResource toResourceFromEditOffer(EditOffer command) {
        return new OfferResource(
                command.getId(),
                command.getCampaignId(),
                command.getDescription(),
                command.getSegment().name(),
                command.getChannel().name(),
                command.getSource().name(),
                command.getStatus().name(),
                command.getAmount(),
                command.getInterestRate(),
                command.getTerms(),
                command.getStartDate(),
                command.getExpirationDate()
        );
    }
}
