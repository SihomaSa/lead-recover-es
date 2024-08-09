package com.techqualitysolutions.leadrecover.publishoffer.interfaces.rest.resources;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record PublishResource(
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    Long id,
    Long offerId,
    Long campaignId,
    String segment,
    String channel,
    String source,
    String status,
    Long interestRate,
    LocalDateTime datePublish
) {}
