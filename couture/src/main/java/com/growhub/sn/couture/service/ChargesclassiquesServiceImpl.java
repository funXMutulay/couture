package com.growhub.sn.couture.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.growhub.sn.couture.model.Chargesclassiques;
import com.growhub.sn.couture.repository.ChargesclassiquesRepository;

@Service
public class ChargesclassiquesServiceImpl implements ChargesclassiquesService{
    
    @Autowired
    ChargesclassiquesRepository chargesclassiquesRepository;

    
    public ChargesclassiquesRepository getChargesclassiquesRepository() {
        return chargesclassiquesRepository;
    }



    public void setChargesclassiquesRepository(ChargesclassiquesRepository chargesclassiquesRepository) {
        this.chargesclassiquesRepository = chargesclassiquesRepository;
    }
	
	//Get All Chargesclassiquess
	public List<Chargesclassiques> findAll(){
		return chargesclassiquesRepository.findAll();
	}	
	
	//Get Chargesclassiques By Id
	public Optional<Chargesclassiques> findById(int id) {
		return chargesclassiquesRepository.findById(id);
	}	
	
	//Delete Chargesclassiques
	public void delete(int id) {
		chargesclassiquesRepository.deleteById(id);
	}
	
	//Update Chargesclassiques
	public void save( Chargesclassiques chargesclassiques) {
		chargesclassiquesRepository.save(chargesclassiques);
	}

}
