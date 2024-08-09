package com.techqualitysolutions.leadrecover.publishoffer.application.services;

import com.techqualitysolutions.leadrecover.manageoffer.domain.projections.OfferAuditLogProjection;
import com.techqualitysolutions.leadrecover.manageoffer.domain.projections.OfferProjection;
import com.techqualitysolutions.leadrecover.manageoffer.domain.queries.GetOfferAuditLogsByOfferId;
import com.techqualitysolutions.leadrecover.manageoffer.domain.queries.GetOffers;
import com.techqualitysolutions.leadrecover.publishoffer.domain.projections.PublishProjection;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PublishQueryService {
    private final QueryGateway queryGateway;

    public PublishQueryService(QueryGateway queryGateway) {
        this.queryGateway = queryGateway;
    }

    public List<PublishProjection> getPublishers(Integer page, Integer limit) throws Exception {
        var query = new GetOffers(page, limit);
        return queryGateway.query(query, ResponseTypes.multipleInstancesOf(PublishProjection.class)).join();
    }
}
