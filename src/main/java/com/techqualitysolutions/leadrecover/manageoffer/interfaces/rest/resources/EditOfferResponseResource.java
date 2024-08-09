package com.techqualitysolutions.leadrecover.manageoffer.interfaces.rest.resources;

import com.techqualitysolutions.leadrecover.shared.domain.model.valueobjects.Error;

import java.util.List;

public record EditOfferResponseResource(
        OfferResource success,
        List<Error> errors
) {}
