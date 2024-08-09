package com.techqualitysolutions.leadrecover.improvepersonalization.application.services;

import com.techqualitysolutions.leadrecover.improvepersonalization.domain.projections.AnalyticAuditLogProjection;
import com.techqualitysolutions.leadrecover.improvepersonalization.domain.queries.GetAnalyticAuditLogsByAnalyticId;
import com.techqualitysolutions.leadrecover.manageoffer.domain.projections.OfferAuditLogProjection;
import com.techqualitysolutions.leadrecover.manageoffer.domain.projections.OfferProjection;
import com.techqualitysolutions.leadrecover.manageoffer.domain.queries.GetOfferAuditLogsByOfferId;
import com.techqualitysolutions.leadrecover.manageoffer.domain.queries.GetOffers;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AnalyticQueryService {
    private final QueryGateway queryGateway;

    public AnalyticQueryService(QueryGateway queryGateway) {
        this.queryGateway = queryGateway;
    }

    public List<AnalyticAuditLogProjection> getAuditLogsByAnalyticId(Long offerId) throws Exception {
        var query = new GetAnalyticAuditLogsByAnalyticId(offerId);
        return queryGateway.query(query, ResponseTypes.multipleInstancesOf(AnalyticAuditLogProjection.class)).join();
    }

}
