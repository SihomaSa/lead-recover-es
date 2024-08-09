package com.techqualitysolutions.leadrecover.manageoffer.infrastructure.persistence.jpa.repository;

import com.techqualitysolutions.leadrecover.manageoffer.domain.projections.OfferAuditLogProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OfferAuditLogRepository extends JpaRepository<OfferAuditLogProjection, Long> {
    @Query(
            value = "SELECT * FROM offer_audit_log_projections WHERE offer_id = :offerId ORDER BY created_at DESC LIMIT 1",
            nativeQuery = true
    )
    Optional<OfferAuditLogProjection> getLastByOfferId(@Param("offerId") Long offerId);

    @Query(
            value = "SELECT * FROM offer_audit_log_projections WHERE offer_id = :offerId ORDER BY created_at",
            nativeQuery = true
    )
    List<OfferAuditLogProjection> getByOfferId(Long offerId);
}
