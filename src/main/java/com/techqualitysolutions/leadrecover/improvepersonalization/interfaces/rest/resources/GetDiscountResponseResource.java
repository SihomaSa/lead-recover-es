package com.techqualitysolutions.leadrecover.improvepersonalization.interfaces.rest.resources;

import com.techqualitysolutions.leadrecover.shared.domain.model.valueobjects.Error;

import java.util.List;

public record GetDiscountResponseResource(
        AnalyticsResource success,
        List<Error> errors
) {}
