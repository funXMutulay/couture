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

import com.growhub.sn.couture.model.Garniture;
import com.growhub.sn.couture.repository.GarnitureRepository;
import com.growhub.sn.couture.service.GarnitureService;

import io.github.wimdeblauwe.htmx.spring.boot.mvc.HtmxResponse;


@CrossOrigin(origins="*" , maxAge=3600)
@Controller
public class GarnitureController {

    @Autowired
private final GarnitureRepository repository;

@Autowired
private GarnitureService service;
@Autowired
private final ApplicationEventPublisher publisher;

    public GarnitureController(GarnitureRepository repository ,
                            ApplicationEventPublisher publisher) {
        this.repository = repository;
        this.publisher = publisher;
    }

    @ModelAttribute("garnitures")
    public List <Garniture> populateGarnitures(){
        return this.repository.findAll();
    }

    @GetMapping(value="/garnitures")
   String getGarnitures(Model model ){
    
    model.addAttribute("garnitures", this.repository.findAll());
    return "garnitures";
   }

   //Add Client
	@PostMapping(value="/garnitures/addNew")
	public HtmxResponse addNewGarniture(@ModelAttribute ("new-garniture") Garniture garniture) {
		service.save(garniture);
		return  new HtmxResponse()
                    .addTemplate("garnitures :: garnitures-list")
                    .addTemplate("garnitures :: garnitures-form") ;
	}	
    

   @PostMapping("/garnitures/reset")
   HtmxResponse reset(Model model){
    
    model.addAttribute("garnitures", this.repository.findAll());
    return new HtmxResponse()
               .addTemplate("garnitures :: garnitures-list ")
               .addTemplate("garnitures :: garnitures-form") ;
   }

   @ResponseBody
   @DeleteMapping(value="/garnitures/{id}" , produces = MediaType.TEXT_HTML_VALUE)
   String delete(@PathVariable Integer id){

    System.out.println("Going to delete Garniture #" + id);
    repository.deleteById(id);
    return "redirect:/ " ;
   }
}