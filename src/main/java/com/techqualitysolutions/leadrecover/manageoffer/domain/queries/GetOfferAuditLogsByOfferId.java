package com.techqualitysolutions.leadrecover.manageoffer.domain.queries;

import lombok.Value;

@Value
public class GetOfferAuditLogsByOfferId {
    private final Long id;

    public GetOfferAuditLogsByOfferId(Long id) {
        this.id = id;
    }
}
