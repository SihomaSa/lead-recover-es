package com.techqualitysolutions.leadrecover.improvepersonalization.domain.model.aggregates;

import com.techqualitysolutions.leadrecover.improvepersonalization.domain.commands.GetDiscount;
import com.techqualitysolutions.leadrecover.improvepersonalization.domain.events.DiscountSelected;
import com.techqualitysolutions.leadrecover.improvepersonalization.domain.model.valueobjects.AnalyticStatus;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

import java.time.LocalDateTime;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@Aggregate
public class Analytic {
    @AggregateIdentifier
    private Long id;
    private String description;
    private AnalyticStatus status;
    private LocalDateTime startDate;
    private LocalDateTime expirationDate;
    private OfferItem offerItem;

    public Analytic() {
    }

    @CommandHandler
    public Analytic(GetDiscount command) {
        DiscountSelected event = new DiscountSelected(
                command.getId(),
                command.getDescription(),
                command.getStatus(),
                command.getStartDate(),
                command.getExpirationDate(),
                command.getCreatedAt()
        );
        apply(event);
    }

    @EventSourcingHandler
    protected void on(DiscountSelected event) {
        this.id = event.getId();
        this.description = event.getDescription();
        this.status = AnalyticStatus.SUCCESS;
        this.startDate = event.getStartDate();
        this.expirationDate = event.getExpirationDate();
    }
}
