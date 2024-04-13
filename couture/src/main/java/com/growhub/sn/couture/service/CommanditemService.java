package com.growhub.sn.couture.service;

import java.util.List;
import java.util.Optional;

import com.growhub.sn.couture.model.Commanditem;


public interface CommanditemService {

     List<Commanditem> findAll();

     Optional<Commanditem> findById(int id);

     void delete(int id);

     void save(Commanditem commanditem);
	

}
