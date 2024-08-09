package com.techqualitysolutions.leadrecover.publishoffer.domain.projections;

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
public class PublishProjection {
    @Id
    @Column
    private Long id;

    @Column
    private Long offerId;

    @Column
    private Long campaignId;

    @Column
    private String segment;

    @Column
    private String channel;

    @Column
    private String source;

    @Column
    private String status;

    @Column
    private Long interestRate;

    @Column
    private LocalDateTime datePublish;

    @Column
    private LocalDateTime createdAt;

    @Column(nullable = true)
    private LocalDateTime updatedAt;

    public PublishProjection(Long id, Long offerId, Long campaignId, String segment, String channel, String source, String status, LocalDateTime datePublish, Long interestRate, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.offerId = offerId;
        this.campaignId = campaignId;
        this.segment = segment;
        this.channel = channel;
        this.source = source;
        this.status = status;
        this.datePublish = datePublish;
        this.interestRate = interestRate;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public PublishProjection() {
    }


}
