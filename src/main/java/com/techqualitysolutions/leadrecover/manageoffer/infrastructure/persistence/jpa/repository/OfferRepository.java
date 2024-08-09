package com.techqualitysolutions.leadrecover.manageoffer.infrastructure.persistence.jpa.repository;

import com.techqualitysolutions.leadrecover.manageoffer.domain.projections.OfferProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OfferRepository extends JpaRepository<OfferProjection, Long> {

    @Procedure(procedureName = "get_offers")
    List<OfferProjection> getPaginated(long page, long limit);


}
