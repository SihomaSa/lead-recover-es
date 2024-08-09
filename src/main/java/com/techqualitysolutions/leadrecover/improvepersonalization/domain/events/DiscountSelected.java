package com.techqualitysolutions.leadrecover.improvepersonalization.domain.events;

import com.techqualitysolutions.leadrecover.improvepersonalization.domain.model.valueobjects.AnalyticStatus;
import lombok.Value;

import java.time.LocalDateTime;

@Value
public class DiscountSelected {
    private Long id;
    private String description;
    private AnalyticStatus status;
    private LocalDateTime startDate;
    private LocalDateTime expirationDate;
    private LocalDateTime createdAt;
}
