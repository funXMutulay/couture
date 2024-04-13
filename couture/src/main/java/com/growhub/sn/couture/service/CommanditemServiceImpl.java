package com.growhub.sn.couture.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.growhub.sn.couture.model.Commanditem;
import com.growhub.sn.couture.repository.CommanditemRepository;

@Service
public class CommanditemServiceImpl implements CommanditemService{
    
    @Autowired
    CommanditemRepository commanditemRepository;

    
    public CommanditemRepository getCommanditemRepository() {
        return commanditemRepository;
    }



    public void setCommanditemRepository(CommanditemRepository commanditemRepository) {
        this.commanditemRepository = commanditemRepository;
    }
	
	//Get All Commanditems
	public List<Commanditem> findAll(){
		return commanditemRepository.findAll();
	}	
	
	//Get Commanditem By Id
	public Optional<Commanditem> findById(int id) {
		return commanditemRepository.findById(id);
	}	
	
	//Delete Commanditem
	public void delete(int id) {
		commanditemRepository.deleteById(id);
	}
	
	//Update Commanditem
	public void save( Commanditem commanditem) {
		commanditemRepository.save(commanditem);
	}

}
