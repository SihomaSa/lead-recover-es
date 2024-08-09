package com.techqualitysolutions.leadrecover.manageoffer.domain.projections;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class OfferProjection {
    @Id
    @Column
    private Long id;

    @Column
    private Long campaignId;

    @Column(length=100)
    private String description;

    @Column
    private String segment;

    @Column
    private String channel;//

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

    @Column(nullable = true)
    private LocalDateTime updatedAt;

    public OfferProjection() {
    }

    public OfferProjection(Long id, Long campaignId, String description, String segment, String channel, String source, String status, BigDecimal amount, Long interestRate, String terms, LocalDateTime startDate, LocalDateTime expirationDate, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
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
        this.updatedAt = updatedAt;
    }
}
