package com.growhub.sn.couture.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.growhub.sn.couture.model.Client;
import com.growhub.sn.couture.service.ClientService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;


@Controller
@Tag(name = "Client", description = "Client management APIs")
public class ClientController {

    @Autowired
    public ClientService service;

    @Operation(
      summary = "Retrieve all LOcations by name",
      description = "Get a Client object by specifying its id. The response is Client object with name.",
      tags = { "tutorials", "get" })
  @ApiResponses({
      @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Client.class), mediaType = "application/json") }),
      @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
      @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @RequestMapping(value="/clients", method=RequestMethod.GET)
    public String getAllClients(Model model) {
        model.addAttribute("clients", service.findAll());
        return "clients";
    }
    
}
