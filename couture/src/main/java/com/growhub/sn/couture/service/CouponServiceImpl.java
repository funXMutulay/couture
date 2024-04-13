package com.growhub.sn.couture.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.growhub.sn.couture.model.Coupon;
import com.growhub.sn.couture.repository.CouponRepository;

@Service
public class CouponServiceImpl implements CouponService{
    
    @Autowired
    CouponRepository couponRepository;

    
    public CouponRepository getCouponRepository() {
        return couponRepository;
    }



    public void setCouponRepository(CouponRepository couponRepository) {
        this.couponRepository = couponRepository;
    }
	
	//Get All Coupons
	public List<Coupon> findAll(){
		return couponRepository.findAll();
	}	
	
	//Get Coupon By Id
	public Optional<Coupon> findById(int id) {
		return couponRepository.findById(id);
	}	
	
	//Delete Coupon
	public void delete(int id) {
		couponRepository.deleteById(id);
	}
	
	//Update Coupon
	public void save( Coupon coupon) {
		couponRepository.save(coupon);
	}

}
