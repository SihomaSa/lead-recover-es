package com.techqualitysolutions.leadrecover.improvepersonalization.domain.projections;

import com.techqualitysolutions.leadrecover.manageoffer.domain.projections.OfferAuditLogProjection;
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
public class AnalyticProjection {
    @Id
    @Column
    private Long id;

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

    @Column(nullable = true)
    private LocalDateTime updatedAt;

    public AnalyticProjection() {
    }

    public AnalyticProjection(Long id, String description, String status, LocalDateTime startDate, LocalDateTime expirationDate, LocalDateTime createdAt) {
        this.id = id;
        this.description = description;
        this.status = status;
        this.startDate = startDate;
        this.expirationDate = expirationDate;
        this.createdAt = createdAt;
    }

    public AnalyticProjection(AnalyticProjection view) {
        this.description = view.getDescription();
        this.status = view.getStatus();
        this.startDate = view.getStartDate();
        this.expirationDate = view.getExpirationDate();
        this.createdAt = view.getCreatedAt();
    }
}
