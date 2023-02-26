package com.promineotech.location.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.promineotech.book.entity.Location;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

@Validated
@RequestMapping("/Location")
@OpenAPIDefinition(info = @Info(title = "Leslie's Library"), servers = {
    @Server(url = "http://localhost:8080", description = "Local server")})

public interface LocationController {

  // @formatter:off
  @Operation(
      summary = "Returns list of locations",
      description = "Returns list of locations",
      responses = {
          @ApiResponse(
              responseCode = "200", 
              description = "Locations are returned", 
              content = @Content(
                  mediaType = "application/json", 
                  schema = @Schema(implementation = Location.class))),
          @ApiResponse(
              responseCode = "400", 
              description = "The request parameters are invalid", 
              content = @Content(mediaType = "application/json")), 
          @ApiResponse(
              responseCode = "404", 
              description = "No locations were found with input criteria", 
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "500", 
              description = "An uplanned error occurred", 
              content = @Content(mediaType = "application/json"))
      
      },
      parameters = {
          @Parameter(
              name = "locationName",
              allowEmptyValue = false,
              required = false,
              description = "Name of location")
          
      }
   )

@GetMapping
@ResponseStatus(code = HttpStatus.OK)
List<Location> fetchAvailableLocations(
    @RequestParam(required = false)
    String locationName);
//@formatter:on
}




