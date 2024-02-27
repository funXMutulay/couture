package com.growhub.sn.couture.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.growhub.sn.couture.model.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location,Integer>{

}
