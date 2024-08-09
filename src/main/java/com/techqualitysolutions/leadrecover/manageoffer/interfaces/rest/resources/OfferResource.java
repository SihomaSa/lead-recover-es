package com.techqualitysolutions.leadrecover.manageoffer.interfaces.rest.resources;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record OfferResource(
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    Long id,
    Long campaignId,
    String description,
    String segment,
    String channel,
    String source,
    String status,
    BigDecimal amount,
    Long interestRate,
    String terms,
    LocalDateTime startDate,
    LocalDateTime expirationDate
) {}
