package com.techqualitysolutions.leadrecover.manageoffer.application.services;

import com.techqualitysolutions.leadrecover.manageoffer.domain.projections.OfferAuditLogProjection;
import com.techqualitysolutions.leadrecover.manageoffer.domain.projections.OfferProjection;
import com.techqualitysolutions.leadrecover.manageoffer.domain.queries.GetOfferAuditLogsByOfferId;
import com.techqualitysolutions.leadrecover.manageoffer.domain.queries.GetOffers;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OfferQueryService {
    private final QueryGateway queryGateway;

    public OfferQueryService(QueryGateway queryGateway) {
        this.queryGateway = queryGateway;
    }

    public List<OfferAuditLogProjection> getAuditLogsByOfferId(Long offerId) throws Exception {
        var query = new GetOfferAuditLogsByOfferId(offerId);
        return queryGateway.query(query, ResponseTypes.multipleInstancesOf(OfferAuditLogProjection.class)).join();
    }

    public List<OfferProjection> getOffers(Integer page, Integer limit) throws Exception {
        var query = new GetOffers(page, limit);
        return queryGateway.query(query, ResponseTypes.multipleInstancesOf(OfferProjection.class)).join();
    }
}
