package com.growhub.sn.couture.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.growhub.sn.couture.model.Client;
import com.growhub.sn.couture.repository.ClientRepository;

@Service
public class ClientServiceImpl implements ClientService{
    
    @Autowired
    ClientRepository clientRepository;

    
    public ClientRepository getClientRepository() {
        return clientRepository;
    }



    public void setClientRepository(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
   public  List<Client>  findAll(){
        return clientRepository.findAll();
    }



}
