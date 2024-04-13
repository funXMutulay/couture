package com.growhub.sn.couture.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.growhub.sn.couture.model.Tenue;
import com.growhub.sn.couture.repository.TenueRepository;

@Service
public class TenueServiceImpl implements TenueService{
    
    @Autowired
    TenueRepository tenueRepository;

    
    public TenueRepository getTenueRepository() {
        return tenueRepository;
    }



    public void setTenueRepository(TenueRepository tenueRepository) {
        this.tenueRepository = tenueRepository;
    }

    @Override
   public  List<Tenue>  findAll(){
        return tenueRepository.findAll();
    }



}
