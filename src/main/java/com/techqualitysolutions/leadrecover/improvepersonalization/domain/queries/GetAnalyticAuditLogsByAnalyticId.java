package com.techqualitysolutions.leadrecover.improvepersonalization.domain.queries;

import lombok.Value;

@Value
public class GetAnalyticAuditLogsByAnalyticId {
    private final Long id;

    public GetAnalyticAuditLogsByAnalyticId(Long id) {
        this.id = id;
    }
}
