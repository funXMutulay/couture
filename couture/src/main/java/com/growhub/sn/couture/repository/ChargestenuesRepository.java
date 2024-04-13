package com.growhub.sn.couture.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.growhub.sn.couture.model.Chargestenues;



@Repository

public interface ChargestenuesRepository extends JpaRepository<Chargestenues,Integer>{

}
