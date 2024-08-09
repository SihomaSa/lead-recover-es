package com.techqualitysolutions.leadrecover.improvepersonalization.infrastructure.persistence.jpa.repository;

import com.techqualitysolutions.leadrecover.improvepersonalization.domain.projections.AnalyticProjection;
import com.techqualitysolutions.leadrecover.manageoffer.domain.projections.OfferProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnalyticRepository extends JpaRepository<AnalyticProjection, Long> {

}
