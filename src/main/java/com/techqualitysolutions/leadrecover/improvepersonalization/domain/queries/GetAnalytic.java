package com.techqualitysolutions.leadrecover.improvepersonalization.domain.queries;

import lombok.Value;

@Value
public class GetAnalytic {
    private final Integer page;
    private final Integer limit;

    public GetAnalytic(Integer page, Integer limit) {
        page = page <= 0 ? 1 : page;
        limit = (limit <= 0 || limit > 100) ? 100 : limit;
        this.page = page;
        this.limit = limit;
    }
}
