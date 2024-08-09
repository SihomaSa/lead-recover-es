package com.techqualitysolutions.leadrecover.improvepersonalization.interfaces.rest.resources;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record AnalyticsResource(
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    Long id,
    String description,
    String status,
    LocalDateTime startDate,
    LocalDateTime expirationDate
) {}
