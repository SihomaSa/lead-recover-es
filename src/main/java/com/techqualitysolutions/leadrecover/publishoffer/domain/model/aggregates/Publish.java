package com.techqualitysolutions.leadrecover.publishoffer.domain.model.aggregates;

import com.techqualitysolutions.leadrecover.publishoffer.domain.commands.DiscardOffer;
import com.techqualitysolutions.leadrecover.publishoffer.domain.commands.PublishOffer;
import com.techqualitysolutions.leadrecover.publishoffer.domain.commands.SubmitOffer;
import com.techqualitysolutions.leadrecover.publishoffer.domain.commands.UnPublishOffer;
import com.techqualitysolutions.leadrecover.publishoffer.domain.events.OfferDiscarded;
import com.techqualitysolutions.leadrecover.publishoffer.domain.events.OfferPublished;
import com.techqualitysolutions.leadrecover.publishoffer.domain.events.OfferSubmited;
import com.techqualitysolutions.leadrecover.publishoffer.domain.events.OfferUnPublished;
import com.techqualitysolutions.leadrecover.publishoffer.domain.model.valueobjects.Channel;
import com.techqualitysolutions.leadrecover.publishoffer.domain.model.valueobjects.PublishStatus;
import com.techqualitysolutions.leadrecover.publishoffer.domain.model.valueobjects.Segment;
import com.techqualitysolutions.leadrecover.publishoffer.domain.model.valueobjects.Source;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;
import org.javamoney.moneta.Money;

import java.time.LocalDateTime;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@Aggregate
public class Publish {
    @AggregateIdentifier
    private Long id;
    private Long offerId;
    private Long campaignId;
    private Segment segment;
    private Channel channel;
    private Source source;
    private PublishStatus status;
    private Long interestRate;
    private LocalDateTime datePublish;

    public Publish() {
    }

    @CommandHandler
    public Publish(SubmitOffer command) {
        OfferSubmited event = new OfferSubmited(
                command.getId(),
                command.getOfferId(),
                command.getCampaignId(),
                command.getSegment(),
                command.getChannel(),
                command.getSource(),
                command.getStatus(),
                command.getInterestRate(),
                command.getDatePublish(),
                command.getUpdatedAt()
        );
        apply(event);
    }

    @CommandHandler
    public void discard(DiscardOffer command) {
        OfferDiscarded event = new OfferDiscarded(
                command.getId(),
                command.getOfferId(),
                command.getCampaignId(),
                command.getSegment(),
                command.getChannel(),
                command.getSource(),
                command.getStatus(),
                command.getInterestRate(),
                command.getDatePublish(),
                command.getUpdatedAt()
        );
        apply(event);
    }

    @CommandHandler
    public void publish(PublishOffer command) {
        OfferPublished event = new OfferPublished(
                command.getId(),
                command.getOfferId(),
                command.getCampaignId(),
                command.getSegment(),
                command.getChannel(),
                command.getSource(),
                command.getStatus(),
                command.getInterestRate(),
                command.getDatePublish(),
                command.getUpdatedAt()
        );
        apply(event);
    }

    @CommandHandler
    public void unpublish(UnPublishOffer command) {
        OfferUnPublished event = new OfferUnPublished(
                command.getId(),
                command.getOfferId(),
                command.getCampaignId(),
                command.getSegment(),
                command.getChannel(),
                command.getSource(),
                command.getStatus(),
                command.getInterestRate(),
                command.getDatePublish(),
                command.getUpdatedAt()
        );
        apply(event);
    }

    @EventSourcingHandler
    protected void on(OfferSubmited event) {
        this.id = event.getId();
        this.offerId = event.getOfferId();
        this.campaignId = event.getCampaignId();
        this.segment = event.getSegment();
        this.channel = event.getChannel();
        this.source = event.getSource();
        this.status = PublishStatus.SUBMITED;
        this.interestRate = event.getInterestRate();
        this.datePublish = event.getDatePublish();
    }

    @EventSourcingHandler
    protected void on(OfferDiscarded event) {
        this.id = event.getId();
        this.offerId = event.getOfferId();
        this.campaignId = event.getCampaignId();
        this.segment = event.getSegment();
        this.channel = event.getChannel();
        this.source = event.getSource();
        this.status = PublishStatus.DISCARED;
        this.interestRate = event.getInterestRate();
        this.datePublish = event.getDatePublish();
    }

    @EventSourcingHandler
    protected void on(OfferPublished event) {
        this.id = event.getId();
        this.offerId = event.getOfferId();
        this.campaignId = event.getCampaignId();
        this.segment = event.getSegment();
        this.channel = event.getChannel();
        this.source = event.getSource();
        this.status = PublishStatus.PUBLISH;
        this.interestRate = event.getInterestRate();
        this.datePublish = event.getDatePublish();
    }

    @EventSourcingHandler
    protected void on(OfferUnPublished event) {
        this.id = event.getId();
        this.offerId = event.getOfferId();
        this.campaignId = event.getCampaignId();
        this.segment = event.getSegment();
        this.channel = event.getChannel();
        this.source = event.getSource();
        this.status = PublishStatus.UNPUBLISH;
        this.interestRate = event.getInterestRate();
        this.datePublish = event.getDatePublish();
    }
}
