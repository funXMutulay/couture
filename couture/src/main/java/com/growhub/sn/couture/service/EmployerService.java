package com.growhub.sn.couture.service;

import java.util.List;
import java.util.Optional;

import com.growhub.sn.couture.model.Employer;


public interface EmployerService {

     List<Employer> findAll();

     Optional<Employer> findById(int id);

     void delete(int id);

     void save(Employer employer);
	

}
