package com.techqualitysolutions.leadrecover.manageoffer.interfaces.rest.resources;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record RegisterOfferResource(
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    Long id,

    Long campaignId,
    String description,
    String segment,
    String channel,
    String source,
    BigDecimal amount,
    Long interestRate,
    String terms,
    LocalDateTime startDate,
    LocalDateTime expirationDate,

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    LocalDateTime createdAt
) {
    public RegisterOfferResource withId(Long id) {
        LocalDateTime createdAt = LocalDateTime.now();
        return new RegisterOfferResource(id, campaignId,description, segment, channel, source, amount, interestRate, terms, startDate,expirationDate, createdAt);
    }

}
