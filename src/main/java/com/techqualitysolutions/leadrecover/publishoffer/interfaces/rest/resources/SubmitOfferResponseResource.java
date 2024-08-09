package com.techqualitysolutions.leadrecover.publishoffer.interfaces.rest.resources;

import com.techqualitysolutions.leadrecover.shared.domain.model.valueobjects.Error;

import java.util.List;

public record SubmitOfferResponseResource(
        PublishResource success,
        List<Error> errors
) {}
