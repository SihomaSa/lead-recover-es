package com.techqualitysolutions.leadrecover.publishoffer.interfaces.rest.resources;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record SubmitOfferResource(
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    Long id,
    Long offerId,
    Long campaignId,
    String segment,
    String channel,
    String source,
    String status,
    Long interestRate,
    LocalDateTime datePublish,

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    LocalDateTime updatedAt
) {
    public SubmitOfferResource withId(Long id) {
        LocalDateTime createdAt = LocalDateTime.now();
        return new SubmitOfferResource(id, offerId, campaignId, segment, channel, source, status, interestRate, datePublish, createdAt);
    }

}