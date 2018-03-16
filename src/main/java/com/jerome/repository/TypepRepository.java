package com.jerome.repository;

import org.springframework.data.repository.CrudRepository;

import com.jerome.model.Typep;

public interface TypepRepository extends CrudRepository<Typep, Long>{
	
	Typep findByTypeProduit(String typeproduit);
	
	Typep findById(Long id);
}
