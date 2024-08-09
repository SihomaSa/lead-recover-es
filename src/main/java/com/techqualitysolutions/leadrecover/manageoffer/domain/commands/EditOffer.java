package com.techqualitysolutions.leadrecover.manageoffer.domain.commands;

import com.techqualitysolutions.leadrecover.manageoffer.domain.model.valueobjects.Channel;
import com.techqualitysolutions.leadrecover.manageoffer.domain.model.valueobjects.OfferStatus;
import com.techqualitysolutions.leadrecover.manageoffer.domain.model.valueobjects.Segment;
import com.techqualitysolutions.leadrecover.manageoffer.domain.model.valueobjects.Source;
import lombok.Value;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Value
public class EditOffer {
    @TargetAggregateIdentifier
    private Long id;
    private Long campaignId;
    private String description;
    private Segment segment;
    private Channel channel;
    private Source source;
    private OfferStatus status;
    private BigDecimal amount;
    private Long interestRate;
    private String terms;
    private LocalDateTime startDate;
    private LocalDateTime expirationDate;
    private LocalDateTime updatedAt;
}
