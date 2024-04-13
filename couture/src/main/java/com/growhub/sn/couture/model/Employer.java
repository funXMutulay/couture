package com.growhub.sn.couture.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Employer{
    
   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    private String nom;
	private String prenom;	
	private String profession;	
	private Integer numIdentite;
    private Integer telephone;
    private String typeContrat;
    private String modePaiement;
    private String frequencePaiement;
    private String montantPaiement;	  
}
