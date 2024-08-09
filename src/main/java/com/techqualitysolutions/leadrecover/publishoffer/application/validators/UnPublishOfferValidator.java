package com.techqualitysolutions.leadrecover.publishoffer.application.validators;

import com.techqualitysolutions.leadrecover.publishoffer.domain.commands.UnPublishOffer;
import com.techqualitysolutions.leadrecover.shared.domain.model.valueobjects.Notification;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class UnPublishOfferValidator {

    public Notification validate(UnPublishOffer command)
    {
        Notification notification = new Notification();

        Long campaignId = command.getCampaignId();
        if (campaignId.intValue() == 0) notification.addError("Campaing is required");

        String segment = command.getSegment().toString().trim();
        if (segment.isEmpty()) notification.addError("Segment is required");

        String channel = command.getChannel().toString().trim();
        if (channel.isEmpty()) notification.addError("Channel is required");

        String source = command.getSource().toString().trim();
        if (source.isEmpty()) notification.addError("Source is required");

        Long interestRate = command.getInterestRate();
        if (interestRate.intValue() <= 0 ) notification.addError("InterestRate must be greater than zero");

        LocalDateTime expirationDate = command.getDatePublish();
        if (expirationDate == null) notification.addError("Publish date is required");

        return notification;
    }
}
