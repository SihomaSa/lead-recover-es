package com.techqualitysolutions.leadrecover.improvepersonalization.domain.commands;

import com.techqualitysolutions.leadrecover.improvepersonalization.domain.model.valueobjects.AnalyticStatus;
import com.techqualitysolutions.leadrecover.improvepersonalization.domain.model.valueobjects.CampaignStatus;
import com.techqualitysolutions.leadrecover.improvepersonalization.domain.model.valueobjects.Segment;
import lombok.Value;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.time.LocalDateTime;

@Value
public class GetCampaign {
    @TargetAggregateIdentifier
    private Long id;
    private String description;
    private Segment segment;
    private Long interestRate;
    private String terms;
    private CampaignStatus status;
    private LocalDateTime startDate;
    private LocalDateTime expirationDate;
}
