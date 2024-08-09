package com.techqualitysolutions.leadrecover.manageoffer.domain.model.aggregates;

import com.techqualitysolutions.leadrecover.manageoffer.domain.commands.EditOffer;
import com.techqualitysolutions.leadrecover.manageoffer.domain.commands.RegisterOffer;
import com.techqualitysolutions.leadrecover.manageoffer.domain.events.OfferEdited;
import com.techqualitysolutions.leadrecover.manageoffer.domain.events.OfferRegistered;
import com.techqualitysolutions.leadrecover.manageoffer.domain.model.valueobjects.*;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;
import org.javamoney.moneta.Money;

import javax.money.MonetaryAmount;
import java.time.LocalDateTime;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@Aggregate
public class Offer {
    @AggregateIdentifier
    private Long id;
    private Long campaignId;
    private String description;
    private Segment segment;
    private Channel channel;
    private Source source;
    private OfferStatus status;
    private MonetaryAmount amount;
    private Long interestRate;
    private String terms;
    private LocalDateTime startDate;
    private LocalDateTime expirationDate;

    public Offer() {
    }

    @CommandHandler
    public Offer(RegisterOffer command) {
        OfferRegistered event = new OfferRegistered(
                command.getId(),
                command.getCampaignId(),
                command.getDescription(),
                command.getSegment(),
                command.getChannel(),
                command.getSource(),
                command.getAmount(),
                command.getInterestRate(),
                command.getTerms(),
                command.getStartDate(),
                command.getExpirationDate(),
                command.getCreatedAt()
        );
        apply(event);
    }

    @CommandHandler
    public void handle(EditOffer command) {
        OfferEdited event = new OfferEdited(
                command.getId(),
                command.getCampaignId(),
                command.getDescription(),
                command.getSegment(),
                command.getChannel(),
                command.getSource(),
                command.getStatus(),
                command.getAmount(),
                command.getInterestRate(),
                command.getTerms(),
                command.getStartDate(),
                command.getExpirationDate(),
                command.getUpdatedAt()
        );
        apply(event);
    }

    @EventSourcingHandler
    protected void on(OfferRegistered event) {
        this.id = event.getId();
        this.campaignId = event.getCampaignId();
        this.description = event.getDescription();
        this.segment = event.getSegment();
        this.channel = event.getChannel();
        this.source = event.getSource();
        this.interestRate = event.getInterestRate();
        this.terms = event.getTerms();
        this.startDate = event.getStartDate();
        this.expirationDate = event.getExpirationDate();
        this.amount = Money.of(event.getAmount(), "USD");
        this.status = OfferStatus.STARTED;
    }

    @EventSourcingHandler
    protected void on(OfferEdited event) {
        this.amount = Money.of(event.getAmount(), "USD");
    }
}
