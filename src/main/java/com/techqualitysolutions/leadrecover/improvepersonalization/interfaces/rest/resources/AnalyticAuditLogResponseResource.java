package com.techqualitysolutions.leadrecover.improvepersonalization.interfaces.rest.resources;

import com.techqualitysolutions.leadrecover.improvepersonalization.domain.projections.AnalyticAuditLogProjection;

import java.util.List;

public record AnalyticAuditLogResponseResource(
    List<AnalyticAuditLogProjection> success,
    List<Error> errors
) {}
