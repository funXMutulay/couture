package com.growhub.sn.couture.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.growhub.sn.couture.model.Location;
import com.growhub.sn.couture.service.LocationService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;


@Controller
@Tag(name = "Location", description = "Location management APIs")
public class LocationController {

    @Autowired
    public LocationService service;

    @Operation(
      summary = "Retrieve all LOcations by name",
      description = "Get a Location object by specifying its id. The response is Location object with name.",
      tags = { "tutorials", "get" })
  @ApiResponses({
      @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Location.class), mediaType = "application/json") }),
      @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
      @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @RequestMapping(value="/locations", method=RequestMethod.GET)
    public String getAllLocations(Model model) {
        model.addAttribute("locations", service.findAll());
        return "locations";
    }
    
}
