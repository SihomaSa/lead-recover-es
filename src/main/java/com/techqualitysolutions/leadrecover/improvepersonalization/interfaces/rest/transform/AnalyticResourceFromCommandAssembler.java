package com.techqualitysolutions.leadrecover.improvepersonalization.interfaces.rest.transform;

import com.techqualitysolutions.leadrecover.improvepersonalization.domain.commands.GetDiscount;
import com.techqualitysolutions.leadrecover.improvepersonalization.interfaces.rest.resources.AnalyticsResource;
import com.techqualitysolutions.leadrecover.manageoffer.domain.model.valueobjects.OfferStatus;

public class AnalyticResourceFromCommandAssembler {
    public static AnalyticsResource toResourceFromGetDiscount(GetDiscount command) {
        return new AnalyticsResource(
                command.getId(),
                command.getDescription(),
                OfferStatus.STARTED.name(),
                command.getStartDate(),
                command.getExpirationDate()
        );
    }
}
