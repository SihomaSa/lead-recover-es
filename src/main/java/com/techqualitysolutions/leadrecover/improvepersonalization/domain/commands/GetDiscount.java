package com.techqualitysolutions.leadrecover.improvepersonalization.domain.commands;

import com.techqualitysolutions.leadrecover.improvepersonalization.domain.model.valueobjects.AnalyticStatus;
import lombok.Value;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.time.LocalDateTime;

@Value
public class GetDiscount {
    @TargetAggregateIdentifier
    private Long id;
    private String description;
    private AnalyticStatus status;
    private LocalDateTime startDate;
    private LocalDateTime expirationDate;
    private LocalDateTime createdAt;
}
