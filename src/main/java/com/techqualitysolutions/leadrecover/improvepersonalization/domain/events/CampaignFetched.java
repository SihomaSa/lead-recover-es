package com.techqualitysolutions.leadrecover.improvepersonalization.domain.events;

import com.techqualitysolutions.leadrecover.improvepersonalization.domain.model.valueobjects.AnalyticStatus;
import com.techqualitysolutions.leadrecover.improvepersonalization.domain.model.valueobjects.CampaignStatus;
import com.techqualitysolutions.leadrecover.improvepersonalization.domain.model.valueobjects.Segment;
import lombok.Value;

import java.time.LocalDateTime;

@Value
public class CampaignFetched {
    private Long id;
    private String description;
    private Segment segment;
    private Long interestRate;
    private String terms;
    private CampaignStatus status;
    private LocalDateTime startDate;
    private LocalDateTime expirationDate;
}
