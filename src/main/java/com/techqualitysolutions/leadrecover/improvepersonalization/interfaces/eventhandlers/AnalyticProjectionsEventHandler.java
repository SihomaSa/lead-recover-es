package com.techqualitysolutions.leadrecover.improvepersonalization.interfaces.eventhandlers;

import com.techqualitysolutions.leadrecover.improvepersonalization.domain.events.DiscountSelected;
import com.techqualitysolutions.leadrecover.improvepersonalization.domain.model.valueobjects.AnalyticStatus;
import com.techqualitysolutions.leadrecover.improvepersonalization.domain.projections.AnalyticProjection;
import com.techqualitysolutions.leadrecover.improvepersonalization.infrastructure.persistence.jpa.repository.AnalyticRepository;
import com.techqualitysolutions.leadrecover.manageoffer.domain.events.OfferEdited;
import com.techqualitysolutions.leadrecover.manageoffer.domain.events.OfferRegistered;
import com.techqualitysolutions.leadrecover.manageoffer.domain.model.valueobjects.OfferStatus;
import com.techqualitysolutions.leadrecover.manageoffer.domain.projections.OfferProjection;
import com.techqualitysolutions.leadrecover.manageoffer.infrastructure.persistence.jpa.repository.OfferRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AnalyticProjectionsEventHandler {
    private final AnalyticRepository analyticRepository;

    public AnalyticProjectionsEventHandler(AnalyticRepository analyticRepository) {
        this.analyticRepository = analyticRepository;
    }

    @EventHandler
    public void on(DiscountSelected event) {
        AnalyticProjection analytic = new AnalyticProjection(
            event.getId(),
            event.getDescription(),
            AnalyticStatus.SUCCESS.name(),
            event.getStartDate(),
            event.getExpirationDate(),
                event.getCreatedAt()
        );
        analyticRepository.save(analytic);
    }
}
