package com.techqualitysolutions.leadrecover.improvepersonalization.domain.projections;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.techqualitysolutions.leadrecover.manageoffer.domain.projections.OfferAuditLogProjection;
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
public class AnalyticAuditLogProjection {
    @Id
    @GeneratedValue
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

    @Column
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long analyticId;

    @Column(length=100)
    private String description;

    @Column
    private String status;

    @Column
    private LocalDateTime startDate;

    @Column
    private LocalDateTime expirationDate;

    @Column
    private LocalDateTime createdAt;

    public AnalyticAuditLogProjection() {
    }

    public AnalyticAuditLogProjection(Long analyticId, String description, String status, LocalDateTime startDate, LocalDateTime expirationDate, LocalDateTime createdAt) {
        this.analyticId = analyticId;
        this.description = description;
        this.status = status;
        this.startDate = startDate;
        this.expirationDate = expirationDate;
        this.createdAt = createdAt;
    }


    public AnalyticAuditLogProjection(AnalyticAuditLogProjection view) {
        this.analyticId = view.getAnalyticId();
        this.description = view.getDescription();
        this.status = view.getStatus();
        this.startDate = view.getStartDate();
        this.expirationDate = view.getExpirationDate();
        this.createdAt = view.getCreatedAt();
    }
}