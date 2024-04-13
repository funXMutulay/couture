package com.growhub.sn.couture.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.growhub.sn.couture.model.Chargesclassiques;
import com.growhub.sn.couture.repository.ChargesclassiquesRepository;
import com.growhub.sn.couture.service.ChargesclassiquesService;

import io.github.wimdeblauwe.htmx.spring.boot.mvc.HtmxResponse;


@CrossOrigin(origins="*" , maxAge=3600)
@Controller
public class ChargesclassiquesController {

    @Autowired
private final ChargesclassiquesRepository repository;

@Autowired
private ChargesclassiquesService service;

    public ChargesclassiquesController(ChargesclassiquesRepository repository ) {
        this.repository = repository;
        
    }

    @ModelAttribute("chargesclassiquess")
    public List <Chargesclassiques> populateChargesclassiquess(){
        return this.repository.findAll();
    }

    @GetMapping(value="/chargesclassiquess")
   String getChargesclassiquess(Model model ){
    
    model.addAttribute("chargesclassiquess", this.repository.findAll());
    return "chargesclassiquess";
   }

   //Add Client
	@PostMapping(value="/chargesclassiquess/addNew")
	public HtmxResponse addNewChargesclassiques(@ModelAttribute ("new-chargesclassiques") Chargesclassiques chargesclassiques) {
		service.save(chargesclassiques);
		return  new HtmxResponse()
                    .addTemplate("chargesclassiquess :: chargesclassiquess-list")
                    .addTemplate("chargesclassiquess :: chargesclassiquess-form") ;
	}	
    

   @PostMapping("/chargesclassiquess/reset")
   HtmxResponse reset(Model model){
    
    model.addAttribute("chargesclassiquess", this.repository.findAll());
    return new HtmxResponse()
               .addTemplate("chargesclassiquess :: chargesclassiquess-list ")
               .addTemplate("chargesclassiquess :: chargesclassiquess-form") ;
   }

   @ResponseBody
   @DeleteMapping(value="/chargesclassiquess/{id}" , produces = MediaType.TEXT_HTML_VALUE)
   String delete(@PathVariable Integer id){

    System.out.println("Going to delete Chargesclassiques #" + id);
    repository.deleteById(id);
    return "redirect:/ " ;
   }
}