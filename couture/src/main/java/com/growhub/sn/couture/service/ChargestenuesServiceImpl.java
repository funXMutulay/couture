package com.growhub.sn.couture.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.growhub.sn.couture.model.Chargestenues;
import com.growhub.sn.couture.repository.ChargestenuesRepository;

@Service
public class ChargestenuesServiceImpl implements ChargestenuesService{
    
    @Autowired
    ChargestenuesRepository chargestenuesRepository;

    
    public ChargestenuesRepository getChargestenuesRepository() {
        return chargestenuesRepository;
    }



    public void setChargestenuesRepository(ChargestenuesRepository chargestenuesRepository) {
        this.chargestenuesRepository = chargestenuesRepository;
    }
	
	//Get All Chargestenuess
	public List<Chargestenues> findAll(){
		return chargestenuesRepository.findAll();
	}	
	
	//Get Chargestenues By Id
	public Optional<Chargestenues> findById(int id) {
		return chargestenuesRepository.findById(id);
	}	
	
	//Delete Chargestenues
	public void delete(int id) {
		chargestenuesRepository.deleteById(id);
	}
	
	//Update Chargestenues
	public void save( Chargestenues chargestenues) {
		chargestenuesRepository.save(chargestenues);
	}

}
