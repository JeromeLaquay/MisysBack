package com.jerome.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jerome.model.Produit;
import com.jerome.repository.ProduitRepository;

@RestController
public class ProduitController {

	@Autowired
	ProduitRepository repo;
    
	@RequestMapping(method = RequestMethod.GET, value="/produit/{id}")
    public Produit findTypep(@PathVariable("id") Long id) {
    	Produit produit= repo.findById(id);
    	return produit;
    }

}
