package com.growhub.sn.couture.service;

import java.util.List;
import java.util.Optional;

import com.growhub.sn.couture.model.Chargestenues;


public interface ChargestenuesService {

     List<Chargestenues> findAll();

     Optional<Chargestenues> findById(int id);

     void delete(int id);

     void save(Chargestenues chargestenues);
	

}
