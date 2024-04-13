package com.growhub.sn.couture.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.growhub.sn.couture.model.Facture;


@Repository
public interface FactureRepository extends JpaRepository<Facture,Integer>{

}
