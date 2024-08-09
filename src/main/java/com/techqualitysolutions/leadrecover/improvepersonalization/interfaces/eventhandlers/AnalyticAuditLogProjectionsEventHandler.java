package com.techqualitysolutions.leadrecover.improvepersonalization.interfaces.eventhandlers;

import com.techqualitysolutions.leadrecover.improvepersonalization.domain.events.DiscountSelected;
import com.techqualitysolutions.leadrecover.improvepersonalization.domain.model.valueobjects.AnalyticStatus;
import com.techqualitysolutions.leadrecover.improvepersonalization.domain.projections.AnalyticAuditLogProjection;
import com.techqualitysolutions.leadrecover.improvepersonalization.infrastructure.persistence.jpa.repository.AnalyticAuditLogRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

@Component
public class AnalyticAuditLogProjectionsEventHandler {
    private final AnalyticAuditLogRepository analyticAuditLogRepository;

    public AnalyticAuditLogProjectionsEventHandler(AnalyticAuditLogRepository analyticAuditLogRepository) {
        this.analyticAuditLogRepository = analyticAuditLogRepository;
    }

    @EventHandler
    public void on(DiscountSelected event) {
        AnalyticAuditLogProjection view = new AnalyticAuditLogProjection(
                event.getId(),
                event.getDescription(),
                AnalyticStatus.SUCCESS.name(),
                event.getStartDate(),
                event.getExpirationDate(),
                event.getCreatedAt()
        );
        analyticAuditLogRepository.save(view);
    }
}
