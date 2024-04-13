package com.growhub.sn.couture.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.growhub.sn.couture.model.Garniture;
import com.growhub.sn.couture.repository.GarnitureRepository;


@Service
public class GarnitureServiceImpl implements GarnitureService{
    
    @Autowired
    GarnitureRepository garnitureRepository;

    
    public GarnitureRepository getGarnitureRepository() {
        return garnitureRepository;
    }



    public void setGarnitureRepository(GarnitureRepository garnitureRepository) {
        this.garnitureRepository = garnitureRepository;
    }
	
	//Get All Garnitures
	public List<Garniture> findAll(){
		return garnitureRepository.findAll();
	}	
	
	//Get Garniture By Id
	public Optional<Garniture> findById(int id) {
		return garnitureRepository.findById(id);
	}	
	
	//Delete Garniture
	public void delete(int id) {
		garnitureRepository.deleteById(id);
	}
	
	//Update Garniture
	public void save( Garniture garniture) {
		garnitureRepository.save(garniture);
	}

}
