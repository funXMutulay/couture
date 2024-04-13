package com.growhub.sn.couture.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.growhub.sn.couture.model.Mesure;
import com.growhub.sn.couture.service.MesureService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;


@Controller
@Tag(name = "Mesure", description = "Mesure management APIs")
@RequestMapping("/mesures") 
public class MesureController {

    @Autowired
    public MesureService service;

    @Operation(
      summary = "Retrieve all LOcations by name",
      description = "Get a Mesure object by specifying its id. The response is Mesure object with name.",
      tags = { "tutorials", "get" })
  @ApiResponses({
      @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Mesure.class), mediaType = "application/json") }),
      @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
      @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @RequestMapping(value="/", method=RequestMethod.GET)
    public String getAllMesures(Model model) {
        model.addAttribute("mesures", service.findAll());
        return "mesures";
    }
	
	@RequestMapping("/findById") 
	@ResponseBody
	public Optional<Mesure> findById(Integer id)
	{
		return service.findById(id);
	}
	
	/*
	//Add Mesure
	@PostMapping(value="mesures/addNew")
	public String addNew(Mesure mesure) {
		service.save(mesure);
		return "redirect:/mesures";
	}	
	 */
	
	//Add Mesure
	@PostMapping(value="/mesures/addNew")
	public String addNew(@RequestBody Mesure mesure) {
		service.save(mesure);
		return "redirect:/mesures";
	}
	
	@RequestMapping(value="/mesures/update", method = {RequestMethod.PUT, RequestMethod.GET})
	public String update(Mesure mesure) {
		service.save(mesure);
		return "redirect:/mesures";
	}
	
	@RequestMapping(value="mesures/delete", method = {RequestMethod.DELETE, RequestMethod.GET})	
	public String delete(Integer id) {
        service.delete(id);
		return "redirect:/mesures";
	}

    
}
