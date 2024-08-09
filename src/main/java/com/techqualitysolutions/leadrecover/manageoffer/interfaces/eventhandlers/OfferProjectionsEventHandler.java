package com.techqualitysolutions.leadrecover.manageoffer.interfaces.eventhandlers;

import com.techqualitysolutions.leadrecover.manageoffer.domain.events.OfferEdited;
import com.techqualitysolutions.leadrecover.manageoffer.domain.events.OfferRegistered;
import com.techqualitysolutions.leadrecover.manageoffer.domain.model.valueobjects.OfferStatus;
import com.techqualitysolutions.leadrecover.manageoffer.domain.projections.OfferProjection;
import com.techqualitysolutions.leadrecover.manageoffer.infrastructure.persistence.jpa.repository.OfferRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class OfferProjectionsEventHandler {
    private final OfferRepository offerRepository;

    public OfferProjectionsEventHandler(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    @EventHandler
    public void on(OfferRegistered event) {
        OfferProjection offer = new OfferProjection(
            event.getId(),
            event.getCampaignId(),
            event.getDescription(),
            event.getSegment().toString(),
            event.getChannel().toString(),
            event.getSource().toString(),
            OfferStatus.STARTED.toString(),
            event.getAmount(),
            event.getInterestRate(),
            event.getTerms(),
            event.getStartDate(),
            event.getExpirationDate(),
            event.getCreatedAt(),
            null
        );
        offerRepository.save(offer);
    }

    @EventHandler
    public void on(OfferEdited event) {
        Optional<OfferProjection> viewOptional = offerRepository.findById(event.getId());
        if (viewOptional.isPresent()) {
            OfferProjection view = viewOptional.get();
            view.setCampaignId(event.getCampaignId());
            view.setDescription(event.getDescription());
            view.setSegment(event.getSegment().toString());
            view.setChannel(event.getChannel().toString());
            view.setSource(event.getSource().toString());
            view.setStatus(event.getStatus().toString());
            view.setAmount(event.getAmount());
            view.setInterestRate(event.getInterestRate());
            view.setTerms(event.getTerms());
            view.setStartDate(event.getStartDate());
            view.setExpirationDate(event.getExpirationDate());
            view.setUpdatedAt(event.getUpdatedAt());
            offerRepository.save(view);
        }
    }

}
