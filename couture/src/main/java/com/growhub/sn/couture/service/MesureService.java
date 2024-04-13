package com.growhub.sn.couture.service;

import java.util.List;
import java.util.Optional;

import com.growhub.sn.couture.model.Mesure;


public interface MesureService {

     List<Mesure> findAll();

     Optional<Mesure> findById(int id);

     void delete(int id);

     void save(Mesure mesure);
	

}
