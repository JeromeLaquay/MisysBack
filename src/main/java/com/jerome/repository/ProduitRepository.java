package com.jerome.repository;

import org.springframework.data.repository.CrudRepository;

import com.jerome.model.Produit;

public interface ProduitRepository extends CrudRepository<Produit, Long>{
	
	Produit findById(Long id);
	
}
