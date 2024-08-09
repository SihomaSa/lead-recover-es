package com.techqualitysolutions.leadrecover.improvepersonalization.infrastructure.persistence.jpa.repository;

import com.techqualitysolutions.leadrecover.improvepersonalization.domain.projections.AnalyticAuditLogProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AnalyticAuditLogRepository extends JpaRepository<AnalyticAuditLogProjection, Long> {
    @Query(
            value = "SELECT * FROM analytic_audit_log_projections WHERE analytic_id = :analyticId ORDER BY created_at DESC LIMIT 1",
            nativeQuery = true
    )
    Optional<AnalyticAuditLogProjection> getLastByAnalyticId(@Param("analyticId") Long analyticId);

    @Query(
            value = "SELECT * FROM analytic_audit_log_projections WHERE analytic_id = :analyticId ORDER BY created_at",
            nativeQuery = true
    )
    List<AnalyticAuditLogProjection> getByAnalyticId(Long analyticId);
}
