package com.techqualitysolutions.leadrecover.manageoffer.interfaces.rest.resources;

import com.techqualitysolutions.leadrecover.manageoffer.domain.projections.OfferAuditLogProjection;

import java.util.List;

public record OfferAuditLogResponseResource(
    List<OfferAuditLogProjection> success,
    List<Error> errors
) {}
