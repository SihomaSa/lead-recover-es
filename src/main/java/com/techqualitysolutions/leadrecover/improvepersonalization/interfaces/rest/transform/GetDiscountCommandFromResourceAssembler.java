package com.techqualitysolutions.leadrecover.improvepersonalization.interfaces.rest.transform;

import com.techqualitysolutions.leadrecover.improvepersonalization.domain.commands.GetDiscount;
import com.techqualitysolutions.leadrecover.improvepersonalization.domain.model.valueobjects.AnalyticStatus;
import com.techqualitysolutions.leadrecover.improvepersonalization.interfaces.rest.resources.GetDiscountResource;
import com.techqualitysolutions.leadrecover.manageoffer.domain.commands.RegisterOffer;
import com.techqualitysolutions.leadrecover.manageoffer.domain.model.valueobjects.Channel;
import com.techqualitysolutions.leadrecover.manageoffer.domain.model.valueobjects.OfferStatus;
import com.techqualitysolutions.leadrecover.manageoffer.domain.model.valueobjects.Segment;
import com.techqualitysolutions.leadrecover.manageoffer.domain.model.valueobjects.Source;

public class GetDiscountCommandFromResourceAssembler {
    public static GetDiscount toCommandFromResource(GetDiscountResource resource) {

        return new GetDiscount(
                resource.id(),
                resource.description(),
                AnalyticStatus.SUCCESS,
                resource.startDate(),
                resource.expirationDate(),
                resource.createdAt()
        );
    }
}
