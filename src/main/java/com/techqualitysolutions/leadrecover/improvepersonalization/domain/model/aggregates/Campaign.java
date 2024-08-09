package com.techqualitysolutions.leadrecover.improvepersonalization.domain.model.aggregates;

import com.techqualitysolutions.leadrecover.improvepersonalization.domain.commands.GetCampaign;
import com.techqualitysolutions.leadrecover.improvepersonalization.domain.commands.GetDiscount;
import com.techqualitysolutions.leadrecover.improvepersonalization.domain.events.CampaignFetched;
import com.techqualitysolutions.leadrecover.improvepersonalization.domain.events.DiscountSelected;
import com.techqualitysolutions.leadrecover.improvepersonalization.domain.model.valueobjects.AnalyticStatus;
import com.techqualitysolutions.leadrecover.improvepersonalization.domain.model.valueobjects.CampaignStatus;
import com.techqualitysolutions.leadrecover.improvepersonalization.domain.model.valueobjects.Segment;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

import java.time.LocalDateTime;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@Aggregate
public class Campaign {
    @AggregateIdentifier
    private Long id;
    private String description;
    private Segment segment;
    private Long interestRate;
    private String terms;
    private CampaignStatus status;
    private LocalDateTime startDate;
    private LocalDateTime expirationDate;

    public Campaign() {
    }

    @CommandHandler
    public Campaign(GetCampaign command) {
        CampaignFetched event = new CampaignFetched(
                command.getId(),
                command.getDescription(),
                command.getSegment(),
                command.getInterestRate(),
                command.getTerms(),
                command.getStatus(),
                command.getStartDate(),
                command.getExpirationDate()
        );
        apply(event);
    }

    @EventSourcingHandler
    protected void on(CampaignFetched event) {
        this.id = event.getId();
        this.description = event.getDescription();
        this.segment = event.getSegment();
        this.interestRate = event.getInterestRate();
        this.terms = event.getTerms();
        this.status = CampaignStatus.SUCCESS;
        this.startDate = event.getStartDate();
        this.expirationDate = event.getExpirationDate();
    }
}
