package com.techqualitysolutions.leadrecover.improvepersonalization.interfaces.rest.resources;

import com.techqualitysolutions.leadrecover.manageoffer.domain.projections.OfferProjection;

import java.util.List;

public record GetOffersResponseResource(
    List<OfferProjection> success,
    List<Error> errors
) {}
