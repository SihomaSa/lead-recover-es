package com.techqualitysolutions.leadrecover.improvepersonalization.application.handlers;

import com.techqualitysolutions.leadrecover.improvepersonalization.domain.projections.AnalyticAuditLogProjection;
import com.techqualitysolutions.leadrecover.improvepersonalization.domain.projections.AnalyticProjection;
import com.techqualitysolutions.leadrecover.improvepersonalization.domain.queries.GetAnalyticAuditLogsByAnalyticId;
import com.techqualitysolutions.leadrecover.improvepersonalization.infrastructure.persistence.jpa.repository.AnalyticAuditLogRepository;
import com.techqualitysolutions.leadrecover.improvepersonalization.infrastructure.persistence.jpa.repository.AnalyticRepository;
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
public class AnalyticAggregateQueryHandler {
    private final AnalyticRepository analyticRepository;
    private final AnalyticAuditLogRepository analyticAuditLogRepository;

    public AnalyticAggregateQueryHandler(AnalyticRepository analyticRepository, AnalyticAuditLogRepository analyticAuditLogRepository) {
        this.analyticRepository = analyticRepository;
        this.analyticAuditLogRepository = analyticAuditLogRepository;
    }

    @QueryHandler
    public List<AnalyticAuditLogProjection> handle(GetAnalyticAuditLogsByAnalyticId query) {
        return this.analyticAuditLogRepository.getByAnalyticId(query.getId());
    }
}
