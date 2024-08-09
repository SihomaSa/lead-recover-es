package com.techqualitysolutions.leadrecover.improvepersonalization.application.validators;

import com.techqualitysolutions.leadrecover.improvepersonalization.domain.commands.GetDiscount;
import com.techqualitysolutions.leadrecover.manageoffer.domain.commands.RegisterOffer;
import com.techqualitysolutions.leadrecover.shared.domain.model.valueobjects.Notification;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Component
public class GetDiscountValidator {
    private static final int DESCRIPTION_MAX_LENGTH = 100;
    public Notification validate(GetDiscount command)
    {
        Notification notification = new Notification();

        String description = command.getDescription().trim();
        if (description.isEmpty()) notification.addError("Description is required");

        if (description.length() > DESCRIPTION_MAX_LENGTH) notification.addError("Description must be less than " + DESCRIPTION_MAX_LENGTH + " characters");

        LocalDateTime startDate = command.getStartDate();
        if (startDate == null) notification.addError("StartDate is required");

        LocalDateTime expirationDate = command.getExpirationDate();
        if (expirationDate == null) notification.addError("ExpirationDate is required");

        return notification;
    }
}
