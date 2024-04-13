package com.growhub.sn.couture.service;

import java.util.List;
import java.util.Optional;

import com.growhub.sn.couture.model.Garniture;


public interface GarnitureService {

     List<Garniture> findAll();

     Optional<Garniture> findById(int id);

     void delete(int id);

     void save(Garniture garniture);
	

}
