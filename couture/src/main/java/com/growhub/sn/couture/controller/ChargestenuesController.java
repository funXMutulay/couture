package com.growhub.sn.couture.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
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

import com.growhub.sn.couture.model.Chargestenues;
import com.growhub.sn.couture.repository.ChargestenuesRepository;
import com.growhub.sn.couture.service.ChargestenuesService;

import io.github.wimdeblauwe.htmx.spring.boot.mvc.HtmxResponse;


@CrossOrigin(origins="*" , maxAge=3600)
@Controller
public class ChargestenuesController {

    @Autowired
private final ChargestenuesRepository repository;

@Autowired
private ChargestenuesService service;
@Autowired
private final ApplicationEventPublisher publisher;

    public ChargestenuesController(ChargestenuesRepository repository ,
                            ApplicationEventPublisher publisher) {
        this.repository = repository;
        this.publisher = publisher;
    }

    @ModelAttribute("chargestenuess")
    public List <Chargestenues> populateChargestenuess(){
        return this.repository.findAll();
    }

    @GetMapping(value="/chargestenuess")
   String getChargestenuess(Model model ){
    
    model.addAttribute("chargestenuess", this.repository.findAll());
    return "chargestenuess";
   }

   //Add Client
	@PostMapping(value="/chargestenuess/addNew")
	public HtmxResponse addNewChargestenues(@ModelAttribute ("new-chargestenues") Chargestenues chargestenues) {
		service.save(chargestenues);
		return  new HtmxResponse()
                    .addTemplate("chargestenuess :: chargestenuess-list")
                    .addTemplate("chargestenuess :: chargestenuess-form") ;
	}	
    

   @PostMapping("/chargestenuess/reset")
   HtmxResponse reset(Model model){
    
    model.addAttribute("chargestenuess", this.repository.findAll());
    return new HtmxResponse()
               .addTemplate("chargestenuess :: chargestenuess-list ")
               .addTemplate("chargestenuess :: chargestenuess-form") ;
   }

   @ResponseBody
   @DeleteMapping(value="/chargestenuess/{id}" , produces = MediaType.TEXT_HTML_VALUE)
   String delete(@PathVariable Integer id){

    System.out.println("Going to delete Chargestenues #" + id);
    repository.deleteById(id);
    return "redirect:/ " ;
   }
}