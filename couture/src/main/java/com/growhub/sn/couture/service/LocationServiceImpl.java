package com.growhub.sn.couture.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.growhub.sn.couture.model.Location;
import com.growhub.sn.couture.repository.LocationRepository;

@Service
public class LocationServiceImpl implements LocationService{
    
    @Autowired
    LocationRepository locationRepository;

    
    public LocationRepository getLocationRepository() {
        return locationRepository;
    }



    public void setLocationRepository(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @Override
   public  List<Location>  findAll(){
        return locationRepository.findAll();
    }



}
