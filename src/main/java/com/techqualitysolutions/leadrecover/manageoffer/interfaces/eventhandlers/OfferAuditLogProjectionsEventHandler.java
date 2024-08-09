package com.techqualitysolutions.leadrecover.manageoffer.interfaces.eventhandlers;

import com.techqualitysolutions.leadrecover.manageoffer.domain.events.OfferEdited;
import com.techqualitysolutions.leadrecover.manageoffer.domain.events.OfferRegistered;
import com.techqualitysolutions.leadrecover.manageoffer.domain.model.valueobjects.OfferStatus;
import com.techqualitysolutions.leadrecover.manageoffer.domain.projections.OfferAuditLogProjection;
import com.techqualitysolutions.leadrecover.manageoffer.infrastructure.persistence.jpa.repository.OfferAuditLogRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class OfferAuditLogProjectionsEventHandler {
    private final OfferAuditLogRepository offerAuditRepository;

    public OfferAuditLogProjectionsEventHandler(OfferAuditLogRepository offerAuditRepository) {
        this.offerAuditRepository = offerAuditRepository;
    }

    @EventHandler
    public void on(OfferRegistered event) {
        OfferAuditLogProjection view = new OfferAuditLogProjection(
                event.getId(),
                event.getCampaignId(),
                event.getDescription(),
                event.getSegment().toString(),
                event.getChannel().toString(),
                event.getSource().toString(),
                OfferStatus.STARTED.name(),
                event.getAmount(),
                event.getInterestRate(),
                event.getTerms(),
                event.getStartDate(),
                event.getExpirationDate(),
                event.getCreatedAt()
        );
        offerAuditRepository.save(view);
    }

    @EventHandler
    public void on(OfferEdited event) {
        Optional<OfferAuditLogProjection> viewOptional = offerAuditRepository.getLastByOfferId(event.getId());
        if (viewOptional.isPresent()) {
            OfferAuditLogProjection lastClientAudit = viewOptional.get();
            OfferAuditLogProjection clientAudit = new OfferAuditLogProjection(lastClientAudit);
            clientAudit.setCampaignId(event.getCampaignId());
           //

            clientAudit.setCreatedAt(event.getUpdatedAt());
            offerAuditRepository.save(clientAudit);
        }
    }
}
