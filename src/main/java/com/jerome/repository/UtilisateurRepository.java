package com.jerome.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.jerome.model.Utilisateur;

public interface UtilisateurRepository extends CrudRepository<Utilisateur, Long> {
	
	List<Utilisateur> findByNom(String nom);
	
	Utilisateur findByMail(String mail);
	
	
}
