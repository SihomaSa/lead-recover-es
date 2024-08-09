package com.techqualitysolutions.leadrecover.manageoffer.application.handlers;

import com.techqualitysolutions.leadrecover.manageoffer.domain.projections.OfferAuditLogProjection;
import com.techqualitysolutions.leadrecover.manageoffer.domain.projections.OfferProjection;
import com.techqualitysolutions.leadrecover.manageoffer.domain.queries.GetOfferAuditLogsByOfferId;
import com.techqualitysolutions.leadrecover.manageoffer.domain.queries.GetOffers;
import com.techqualitysolutions.leadrecover.manageoffer.infrastructure.persistence.jpa.repository.OfferAuditLogRepository;
import com.techqualitysolutions.leadrecover.manageoffer.infrastructure.persistence.jpa.repository.OfferRepository;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OfferAggregateQueryHandler {
    private final OfferRepository offerRepository;
    private final OfferAuditLogRepository offerAuditLogRepository;

    public OfferAggregateQueryHandler(OfferRepository offerRepository, OfferAuditLogRepository offerAuditLogRepository) {
        this.offerRepository = offerRepository;
        this.offerAuditLogRepository = offerAuditLogRepository;
    }

    @QueryHandler
    public List<OfferAuditLogProjection> handle(GetOfferAuditLogsByOfferId query) {
        return this.offerAuditLogRepository.getByOfferId(query.getId());
    }

    @QueryHandler
    public List<OfferProjection> handle(GetOffers query) {
        return this.offerRepository.getPaginated(query.getPage(), query.getLimit());
    }
}
