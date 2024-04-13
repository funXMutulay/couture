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

import com.growhub.sn.couture.model.Coupon;
import com.growhub.sn.couture.repository.CouponRepository;
import com.growhub.sn.couture.service.CouponService;

import io.github.wimdeblauwe.htmx.spring.boot.mvc.HtmxResponse;


@CrossOrigin(origins="*" , maxAge=3600)
@Controller
public class CouponController {

    @Autowired
private final CouponRepository repository;

@Autowired
private CouponService service;
@Autowired
private final ApplicationEventPublisher publisher;

    public CouponController(CouponRepository repository ,
                            ApplicationEventPublisher publisher) {
        this.repository = repository;
        this.publisher = publisher;
    }

    @ModelAttribute("coupons")
    public List <Coupon> populateCoupons(){
        return this.repository.findAll();
    }

    @GetMapping(value="/coupons")
   String getCoupons(Model model ){
    
    model.addAttribute("coupons", this.repository.findAll());
    return "coupons";
   }

   //Add Client
	@PostMapping(value="/coupons/addNew")
	public HtmxResponse addNewCoupon(@ModelAttribute ("new-coupon") Coupon coupon) {
		service.save(coupon);
		return  new HtmxResponse()
                    .addTemplate("coupons :: coupons-list")
                    .addTemplate("coupons :: coupons-form") ;
	}	
    

   @PostMapping("/coupons/reset")
   HtmxResponse reset(Model model){
    
    model.addAttribute("coupons", this.repository.findAll());
    return new HtmxResponse()
               .addTemplate("coupons :: coupons-list ")
               .addTemplate("coupons :: coupons-form") ;
   }

   @ResponseBody
   @DeleteMapping(value="/coupons/{id}" , produces = MediaType.TEXT_HTML_VALUE)
   String delete(@PathVariable Integer id){

    System.out.println("Going to delete Coupon #" + id);
    repository.deleteById(id);
    return "redirect:/ " ;
   }
}