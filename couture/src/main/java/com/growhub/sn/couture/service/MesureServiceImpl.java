package com.growhub.sn.couture.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.growhub.sn.couture.model.Mesure;
import com.growhub.sn.couture.repository.MesureRepository;

@Service
public class MesureServiceImpl implements MesureService{
    
    @Autowired
    MesureRepository mesureRepository;

    
    public MesureRepository getMesureRepository() {
        return mesureRepository;
    }



    public void setMesureRepository(MesureRepository mesureRepository) {
        this.mesureRepository = mesureRepository;
    }
	
	//Get All Mesures
	public List<Mesure> findAll(){
		return mesureRepository.findAll();
	}	
	
	//Get Mesure By Id
	public Optional<Mesure> findById(int id) {
		return mesureRepository.findById(id);
	}	
	
	//Delete Mesure
	public void delete(int id) {
		mesureRepository.deleteById(id);
	}
	
	//Update Mesure
	public void save( Mesure mesure) {
		mesureRepository.save(mesure);
	}

}
