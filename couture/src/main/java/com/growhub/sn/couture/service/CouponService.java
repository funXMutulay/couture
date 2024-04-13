package com.growhub.sn.couture.service;

import java.util.List;
import java.util.Optional;

import com.growhub.sn.couture.model.Coupon;


public interface CouponService {

     List<Coupon> findAll();

     Optional<Coupon> findById(int id);

     void delete(int id);

     void save(Coupon coupon);
	

}
