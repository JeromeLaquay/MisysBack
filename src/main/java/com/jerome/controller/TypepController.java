package com.jerome.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jerome.model.Typep;
import com.jerome.repository.TypepRepository;

@RestController
public class TypepController {

	@Autowired
	TypepRepository repo;
    
	@RequestMapping(method = RequestMethod.GET, value="/typep/{typeproduit}")
    public Typep findTypep(@PathVariable("typeproduit") Long typeproduit) {
    	Typep typep= repo.findById(typeproduit);
    	return typep;
    }

}
