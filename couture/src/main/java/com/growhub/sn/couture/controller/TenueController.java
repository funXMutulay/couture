package com.growhub.sn.couture.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.growhub.sn.couture.model.Tenue;
import com.growhub.sn.couture.service.TenueService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;


@Controller
@Tag(name = "Tenue", description = "Tenue management APIs")
public class TenueController {

    @Autowired
    public TenueService service;

    @Operation(
      summary = "Retrieve all LOcations by name",
      description = "Get a Tenue object by specifying its id. The response is Tenue object with name.",
      tags = { "tutorials", "get" })
  @ApiResponses({
      @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Tenue.class), mediaType = "application/json") }),
      @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
      @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @RequestMapping(value="/tenues", method=RequestMethod.GET)
    public String getAllTenues(Model model) {
        model.addAttribute("tenues", service.findAll());
        return "tenues";
    }
    
}
