package com.techqualitysolutions.leadrecover.publishoffer.domain.events;

import com.techqualitysolutions.leadrecover.publishoffer.domain.model.valueobjects.Channel;
import com.techqualitysolutions.leadrecover.publishoffer.domain.model.valueobjects.PublishStatus;
import com.techqualitysolutions.leadrecover.publishoffer.domain.model.valueobjects.Segment;
import com.techqualitysolutions.leadrecover.publishoffer.domain.model.valueobjects.Source;
import lombok.Value;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.time.LocalDateTime;

@Value
public class OfferDiscarded {
    private Long id;
    private Long offerId;
    private Long campaignId;
    private Segment segment;
    private Channel channel;
    private Source source;
    private PublishStatus status;
    private Long interestRate;
    private LocalDateTime datePublish;
    private LocalDateTime updatedAt;
}
