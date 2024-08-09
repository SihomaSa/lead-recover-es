package com.techqualitysolutions.leadrecover.improvepersonalization.interfaces.rest;

import com.techqualitysolutions.leadrecover.improvepersonalization.application.services.AnalyticCommandService;
import com.techqualitysolutions.leadrecover.improvepersonalization.application.services.AnalyticQueryService;
import com.techqualitysolutions.leadrecover.improvepersonalization.domain.projections.AnalyticAuditLogProjection;
import com.techqualitysolutions.leadrecover.improvepersonalization.interfaces.rest.resources.*;
import com.techqualitysolutions.leadrecover.improvepersonalization.interfaces.rest.transform.AnalyticResourceFromCommandAssembler;
import com.techqualitysolutions.leadrecover.improvepersonalization.interfaces.rest.transform.GetDiscountCommandFromResourceAssembler;
import com.techqualitysolutions.leadrecover.manageoffer.domain.projections.OfferAuditLogProjection;
import io.hypersistence.tsid.TSID;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/analytic", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Analytis", description = "Improve Personalization Endpoints")
public class AnalyticsController {
    private final AnalyticCommandService analyticCommandService;
    private final AnalyticQueryService analyticQueryService;

    public AnalyticsController(AnalyticCommandService analyticCommandService, AnalyticQueryService analyticQueryService) {
        this.analyticCommandService = analyticCommandService;
        this.analyticQueryService = analyticQueryService;
    }

    @Operation(summary = "Get Discount")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Get Discount received successfully"),
        @ApiResponse(responseCode = "400", description = "Bad request, validation errors"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PostMapping
    public ResponseEntity<GetDiscountResponseResource> register(@RequestBody GetDiscountResource resource) {
        try {
            Long id = TSID.Factory.getTsid().toLong();
            resource = resource.withId(id);
            var command = GetDiscountCommandFromResourceAssembler.toCommandFromResource(resource);
            var notification = analyticCommandService.getDiscount(command);
            if (notification.hasErrors()) {
                var response = new GetDiscountResponseResource(null, notification.getErrors());
                return ResponseEntity.badRequest().body(response);
            }
            var clientResource = AnalyticResourceFromCommandAssembler.toResourceFromGetDiscount(command);
            var responseResource = new GetDiscountResponseResource(clientResource, null);
            return new ResponseEntity<>(responseResource, HttpStatus.CREATED);
        } catch(Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new GetDiscountResponseResource(null, null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}/audit-logs")
    @Operation(summary = "Get Discount audit logs")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = ""),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<AnalyticAuditLogResponseResource> getAuditLogsByAnalyticId(@PathVariable("id") Long analyticId) {
        try {
            List<AnalyticAuditLogProjection> auditLog = analyticQueryService.getAuditLogsByAnalyticId(analyticId);
            var response = new AnalyticAuditLogResponseResource(auditLog, null);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch(Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new AnalyticAuditLogResponseResource(null, null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
