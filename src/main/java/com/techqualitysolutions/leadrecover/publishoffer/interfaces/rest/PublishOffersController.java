package com.techqualitysolutions.leadrecover.publishoffer.interfaces.rest;

import com.techqualitysolutions.leadrecover.publishoffer.application.services.PublishCommandService;
import com.techqualitysolutions.leadrecover.publishoffer.interfaces.rest.resources.*;
import com.techqualitysolutions.leadrecover.publishoffer.interfaces.rest.transform.*;
import io.hypersistence.tsid.TSID;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/publishOffers", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Publish Offers", description = "Publish Offers Endpoints")
public class PublishOffersController {
    private final PublishCommandService publishCommandService;

    public PublishOffersController(PublishCommandService publishCommandService) {
        this.publishCommandService = publishCommandService;
    }

    @Operation(summary = "Submit Offer")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Submit Offer successfully"),
        @ApiResponse(responseCode = "400", description = "Bad request, validation errors"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PostMapping("/submit")
    public ResponseEntity<SubmitOfferResponseResource> submit(@RequestBody SubmitOfferResource resource) {
        try {
            Long id = TSID.Factory.getTsid().toLong();
            resource = resource.withId(id);
            var command = SubmitOfferCommandFromResourceAssembler.toCommandFromResource(resource);
            var notification = publishCommandService.submit(command);
            if (notification.hasErrors()) {
                var response = new SubmitOfferResponseResource(null, notification.getErrors());
                return ResponseEntity.badRequest().body(response);
            }
            var clientResource = PublishResourceFromCommandAssembler.toResourceFromSubmitOffer(command);
            var responseResource = new SubmitOfferResponseResource(clientResource, null);
            return new ResponseEntity<>(responseResource, HttpStatus.CREATED);
        } catch(Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new SubmitOfferResponseResource(null, null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @Operation(summary = "Discard Offer")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Discard Offer successfully"),
            @ApiResponse(responseCode = "400", description = "Bad request, validation errors"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PostMapping("/discard")
    public ResponseEntity<DiscardOfferResponseResource> discard(@RequestBody DiscardOfferResource resource) {
        try {
            Long id = TSID.Factory.getTsid().toLong();
            resource = resource.withId(id);
            var command = DiscardOfferCommandFromResourceAssembler.toCommandFromResource(resource);
            var notification = publishCommandService.discard(command);
            if (notification.hasErrors()) {
                var response = new DiscardOfferResponseResource(null, notification.getErrors());
                return ResponseEntity.badRequest().body(response);
            }
            var clientResource = PublishResourceFromCommandAssembler.toResourceFromDiscardOffer(command);
            var responseResource = new DiscardOfferResponseResource(clientResource, null);
            return new ResponseEntity<>(responseResource, HttpStatus.CREATED);
        } catch(Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new DiscardOfferResponseResource(null, null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Operation(summary = "Publish Offer")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Publish Offer successfully"),
            @ApiResponse(responseCode = "400", description = "Bad request, validation errors"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PostMapping("/publish")
    public ResponseEntity<PublishOfferResponseResource> publish(@RequestBody PublishOfferResource resource) {
        try {
            Long id = TSID.Factory.getTsid().toLong();
            resource = resource.withId(id);
            var command = PublishOfferCommandFromResourceAssembler.toCommandFromResource(resource);
            var notification = publishCommandService.publish(command);
            if (notification.hasErrors()) {
                var response = new PublishOfferResponseResource(null, notification.getErrors());
                return ResponseEntity.badRequest().body(response);
            }
            var clientResource = PublishResourceFromCommandAssembler.toResourceFromPublishOffer(command);
            var responseResource = new PublishOfferResponseResource(clientResource, null);
            return new ResponseEntity<>(responseResource, HttpStatus.CREATED);
        } catch(Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new PublishOfferResponseResource(null, null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Operation(summary = "Un Publish Offer")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Un Publish Offer successfully"),
            @ApiResponse(responseCode = "400", description = "Bad request, validation errors"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PostMapping("/unbpublish")
    public ResponseEntity<UnPublishOfferResponseResource> unpublish(@RequestBody UnPublishOfferResource resource) {
        try {
            Long id = TSID.Factory.getTsid().toLong();
            resource = resource.withId(id);
            var command = UnPublishOfferCommandFromResourceAssembler.toCommandFromResource(resource);
            var notification = publishCommandService.unPublish(command);
            if (notification.hasErrors()) {
                var response = new UnPublishOfferResponseResource(null, notification.getErrors());
                return ResponseEntity.badRequest().body(response);
            }
            var clientResource = PublishResourceFromCommandAssembler.toResourceFromUnPublishOffer(command);
            var responseResource = new UnPublishOfferResponseResource(clientResource, null);
            return new ResponseEntity<>(responseResource, HttpStatus.CREATED);
        } catch(Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new UnPublishOfferResponseResource(null, null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
