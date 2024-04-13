package com.growhub.sn.couture.service;

import java.util.List;
import java.util.Optional;

import com.growhub.sn.couture.model.Facture;


public interface FactureService {

     List<Facture> findAll();

     Optional<Facture> findById(int id);

     void delete(int id);

     void save(Facture facture);
	

}
