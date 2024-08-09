package com.techqualitysolutions.leadrecover.manageoffer.domain.queries;

import lombok.Value;

@Value
public class GetOffers {
    private final Integer page;
    private final Integer limit;

    public GetOffers(Integer page, Integer limit) {
        page = page <= 0 ? 1 : page;
        limit = (limit <= 0 || limit > 100) ? 100 : limit;
        this.page = page;
        this.limit = limit;
    }
}
