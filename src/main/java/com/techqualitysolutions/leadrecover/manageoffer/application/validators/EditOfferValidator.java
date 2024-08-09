package com.techqualitysolutions.leadrecover.manageoffer.application.validators;

import com.techqualitysolutions.leadrecover.manageoffer.domain.commands.EditOffer;
import com.techqualitysolutions.leadrecover.manageoffer.domain.projections.OfferProjection;
import com.techqualitysolutions.leadrecover.manageoffer.infrastructure.persistence.jpa.repository.OfferRepository;
import com.techqualitysolutions.leadrecover.shared.domain.model.valueobjects.Notification;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

@Component
public class EditOfferValidator {

    private final OfferRepository offerRepository;

    private static final int DESCRIPTION_MAX_LENGTH = 100;

    public EditOfferValidator(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    public Notification validate(EditOffer command)
    {
        Notification notification = new Notification();

        Long id = command.getId();
        if (id <= 0) {
            notification.addError("Offer id must be greater than zero");
            return notification;
        }

        Long campaignId = command.getCampaignId();
        if (campaignId.intValue() == 0) notification.addError("Campaing is required");

        String description = command.getDescription().trim();
        if (description.isEmpty()) notification.addError("Description is required");

        if (description.length() > DESCRIPTION_MAX_LENGTH) notification.addError("Description must be less than " + DESCRIPTION_MAX_LENGTH + " characters");

        String segment = command.getSegment().toString().trim();
        if (segment.isEmpty()) notification.addError("Segment is required");

        String channel = command.getChannel().toString().trim();
        if (channel.isEmpty()) notification.addError("Channel is required");

        String source = command.getSource().toString().trim();
        if (source.isEmpty()) notification.addError("Source is required");

        BigDecimal amount = command.getAmount();
        if (amount.doubleValue() <= 0 ) notification.addError("Amount must be greater than zero");

        Long interestRate = command.getInterestRate();
        if (interestRate.intValue() <= 0 ) notification.addError("InterestRate must be greater than zero");

        String terms = command.getTerms().trim();
        if (terms.isEmpty()) notification.addError("Terms is required");

        LocalDateTime startDate = command.getStartDate();
        if (startDate == null) notification.addError("StartDate is required");

        LocalDateTime expirationDate = command.getExpirationDate();
        if (expirationDate == null) notification.addError("ExpirationDate is required");

        if (notification.hasErrors()) return notification;

        Optional<OfferProjection> optional = offerRepository.findById(id);
        if (optional.isEmpty()) {
            notification.addError("Account not found");
            return notification;
        }
        return notification;
    }
}
