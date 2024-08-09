package com.techqualitysolutions.leadrecover.manageoffer.domain.events;

import com.techqualitysolutions.leadrecover.manageoffer.domain.model.valueobjects.Channel;
import com.techqualitysolutions.leadrecover.manageoffer.domain.model.valueobjects.OfferStatus;
import com.techqualitysolutions.leadrecover.manageoffer.domain.model.valueobjects.Segment;
import com.techqualitysolutions.leadrecover.manageoffer.domain.model.valueobjects.Source;
import lombok.Value;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Value
public class OfferRegistered {
    private Long id;
    private Long campaignId;
    private String description;
    private Segment segment;
    private Channel channel;
    private Source source;
    private BigDecimal amount;
    private Long interestRate;
    private String terms;
    private LocalDateTime startDate;
    private LocalDateTime expirationDate;
    private LocalDateTime createdAt;
}
