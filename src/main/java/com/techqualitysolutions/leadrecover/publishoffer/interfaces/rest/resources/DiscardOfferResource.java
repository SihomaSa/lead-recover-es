package com.techqualitysolutions.leadrecover.publishoffer.interfaces.rest.resources;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;

public record DiscardOfferResource(
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
    public DiscardOfferResource withId(Long id) {
        LocalDateTime updatedAt = LocalDateTime.now();
        return new DiscardOfferResource(id,offerId, campaignId, segment, channel, source,
                status, interestRate, datePublish, updatedAt);
    }
}
