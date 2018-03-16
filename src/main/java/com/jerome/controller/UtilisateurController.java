package com.jerome.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jerome.model.Utilisateur;
import com.jerome.repository.UtilisateurRepository;

@RestController
public class UtilisateurController {

	@Autowired
	UtilisateurRepository repo;
    
    @RequestMapping(method = RequestMethod.GET, value="/utilisateur")
    public Iterable<Utilisateur> findAll() {
    	Iterable<Utilisateur> users= repo.findAll();
    	return users;
    }
    
    @RequestMapping(method = RequestMethod.GET, value="/utilisateur/{mail}")
    public Utilisateur findUserByEmail(@PathVariable("mail") String mail) {
    	Utilisateur user= repo.findByMail(mail);
    	return user;
    }
    
    @RequestMapping(method = RequestMethod.POST, value = "/utilisateur", produces={MediaType.APPLICATION_JSON_VALUE}, consumes={MediaType.APPLICATION_JSON_VALUE})
 	public ResponseEntity<String> createPodium(@RequestBody Utilisateur utilisateur)  {
     	try{
     		repo.save(utilisateur);
     		return new ResponseEntity<String>("The podium was created", HttpStatus.OK);
     	}catch(Exception e){
     		return new ResponseEntity<String>("Bad request", HttpStatus.BAD_REQUEST);
     	}
 	}
}
