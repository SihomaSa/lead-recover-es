package com.techqualitysolutions.leadrecover.manageoffer.interfaces.rest;

import com.techqualitysolutions.leadrecover.manageoffer.application.services.OfferCommandService;
import com.techqualitysolutions.leadrecover.manageoffer.application.services.OfferQueryService;
import com.techqualitysolutions.leadrecover.manageoffer.domain.projections.OfferAuditLogProjection;
import com.techqualitysolutions.leadrecover.manageoffer.domain.projections.OfferProjection;
import com.techqualitysolutions.leadrecover.manageoffer.interfaces.rest.resources.*;
import com.techqualitysolutions.leadrecover.manageoffer.interfaces.rest.transform.EditOfferCommandFromResourceAssembler;
import com.techqualitysolutions.leadrecover.manageoffer.interfaces.rest.transform.OfferResourceFromCommandAssembler;
import com.techqualitysolutions.leadrecover.manageoffer.interfaces.rest.transform.RegisterOfferCommandFromResourceAssembler;
import com.techqualitysolutions.leadrecover.shared.interfaces.rest.Pagination;
import io.hypersistence.tsid.TSID;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/offers", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Offers", description = "Offers Management Endpoints")
public class OffersController {
    private final OfferCommandService offerCommandService;
    private final OfferQueryService offerQueryService;

    public OffersController(OfferCommandService offerCommandService, OfferQueryService offerQueryService) {
        this.offerCommandService = offerCommandService;
        this.offerQueryService = offerQueryService;
    }

    @Operation(summary = "Register a new offer")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Register Offer received successfully"),
        @ApiResponse(responseCode = "400", description = "Bad request, validation errors"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PostMapping
    public ResponseEntity<RegisterOfferResponseResource> register(@RequestBody RegisterOfferResource resource) {
        try {
            Long id = TSID.Factory.getTsid().toLong();
            resource = resource.withId(id);
            var command = RegisterOfferCommandFromResourceAssembler.toCommandFromResource(resource);
            var notification = offerCommandService.register(command);
            if (notification.hasErrors()) {
                var response = new RegisterOfferResponseResource(null, notification.getErrors());
                return ResponseEntity.badRequest().body(response);
            }
            var clientResource = OfferResourceFromCommandAssembler.toResourceFromRegisterOffer(command);
            var responseResource = new RegisterOfferResponseResource(clientResource, null);
            return new ResponseEntity<>(responseResource, HttpStatus.CREATED);
        } catch(Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new RegisterOfferResponseResource(null, null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Operation(summary = "Edit a offer")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Edit Offer received successfully"),
        @ApiResponse(responseCode = "400", description = "Bad request, validation errors"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PutMapping("/{id}")
    public ResponseEntity<EditOfferResponseResource> edit(@PathVariable("id") Long id, @RequestBody EditOfferResource resource) {
        try {
            resource = resource.withId(id);
            var command = EditOfferCommandFromResourceAssembler.toCommandFromResource(resource);
            var notification = offerCommandService.edit(command);
            if (notification.hasErrors()) {
                var response = new EditOfferResponseResource(null, notification.getErrors());
                return ResponseEntity.badRequest().body(response);
            }
            var clientResource = OfferResourceFromCommandAssembler.toResourceFromEditOffer(command);
            var responseResource = new EditOfferResponseResource(clientResource, null);
            return new ResponseEntity<>(responseResource, HttpStatus.OK);
        } catch(Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new EditOfferResponseResource(null, null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/page/{page}/limit/{limit}")
    @Operation(summary = "Get offers")
    public ResponseEntity<GetOffersResponseResource> getOffers(@PathVariable("page") Integer page, @PathVariable("limit") Integer limit) {
        try {
            List<OfferProjection> clients = offerQueryService.getOffers(page, limit);
            var response = new GetOffersResponseResource(clients, null);
            HttpHeaders headers = Pagination.createPaginationHeaders(clients.size(), page, limit);
            return new ResponseEntity<>(response, headers, HttpStatus.OK);
        } catch(Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new GetOffersResponseResource(null, null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}/audit-logs")
    @Operation(summary = "Get offer audit logs")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = ""),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<OfferAuditLogResponseResource> getAuditLogsByOfferId(@PathVariable("id") Long offerId) {
        try {
            List<OfferAuditLogProjection> auditLog = offerQueryService.getAuditLogsByOfferId(offerId);
            var response = new OfferAuditLogResponseResource(auditLog, null);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch(Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new OfferAuditLogResponseResource(null, null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
