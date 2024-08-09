package com.techqualitysolutions.leadrecover.improvepersonalization.domain.model.aggregates;

import com.techqualitysolutions.leadrecover.manageoffer.domain.model.valueobjects.Segment;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import javax.money.MonetaryAmount;


@Setter
@Getter
public class OfferItem {
    private Long offerId;
    private Long campaignId;
    private Segment segment;
    private Long interestRate;
    private String terms;
    private MonetaryAmount amount;
}
