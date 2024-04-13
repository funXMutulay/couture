package com.growhub.sn.couture.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.growhub.sn.couture.model.Facture;
import com.growhub.sn.couture.repository.FactureRepository;

@Service
public class FactureServiceImpl implements FactureService{
    
    @Autowired
    FactureRepository factureRepository;

    
    public FactureRepository getFactureRepository() {
        return factureRepository;
    }



    public void setFactureRepository(FactureRepository factureRepository) {
        this.factureRepository = factureRepository;
    }
	
	//Get All Factures
	public List<Facture> findAll(){
		return factureRepository.findAll();
	}	
	
	//Get Facture By Id
	public Optional<Facture> findById(int id) {
		return factureRepository.findById(id);
	}	
	
	//Delete Facture
	public void delete(int id) {
		factureRepository.deleteById(id);
	}
	
	//Update Facture
	public void save( Facture facture) {
		factureRepository.save(facture);
	}

}
