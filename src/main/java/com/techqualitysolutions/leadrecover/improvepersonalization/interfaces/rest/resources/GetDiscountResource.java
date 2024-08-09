package com.techqualitysolutions.leadrecover.improvepersonalization.interfaces.rest.resources;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record GetDiscountResource(
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    Long id,

    String description,
    LocalDateTime startDate,
    LocalDateTime expirationDate,

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    LocalDateTime createdAt
) {
    public GetDiscountResource withId(Long id) {
        LocalDateTime createdAt = LocalDateTime.now();
        return new GetDiscountResource(id,description, startDate,expirationDate, createdAt);
    }

}
