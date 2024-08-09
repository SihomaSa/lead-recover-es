package com.techqualitysolutions.leadrecover.manageoffer.domain.projections;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class OfferAuditLogProjection {
    @Id
    @GeneratedValue
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

    @Column
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long offerId;

    @Column
    private Long campaignId;

    @Column(length=100)
    private String description;

    @Column
    private String segment;

    @Column
    private String channel;

    @Column
    private String source;

    @Column
    private String status;

    @Column
    private BigDecimal amount;

    @Column
    private Long interestRate;

    @Column
    private String terms;

    @Column
    private LocalDateTime startDate;

    @Column
    private LocalDateTime expirationDate;
    @Column
    private LocalDateTime createdAt;

    public OfferAuditLogProjection() {
    }

    public OfferAuditLogProjection(Long offerId, Long campaignId, String description, String segment, String channel, String source, String status, BigDecimal amount, Long interestRate, String terms, LocalDateTime startDate, LocalDateTime expirationDate, LocalDateTime createdAt) {
        this.offerId = offerId;
        this.campaignId = campaignId;
        this.description = description;
        this.segment = segment;
        this.channel = channel;
        this.source = source;
        this.status = status;
        this.amount = amount;
        this.interestRate = interestRate;
        this.terms = terms;
        this.startDate = startDate;
        this.expirationDate = expirationDate;
        this.createdAt = createdAt;
    }

    public OfferAuditLogProjection(OfferAuditLogProjection view) {
        this.offerId = view.getOfferId();
        this.campaignId = view.getCampaignId();
        this.description = view.getDescription();
        this.segment = view.getSegment();
        this.channel = view.getChannel();
        this.source = view.getSource();
        this.status = view.getStatus();
        this.amount = view.getAmount();
        this.interestRate = view.getInterestRate();
        this.terms = view.getTerms();
        this.startDate = view.getStartDate();
        this.expirationDate = view.getExpirationDate();
        this.createdAt = view.getCreatedAt();
    }
}
