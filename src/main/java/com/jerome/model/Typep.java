package com.jerome.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Typep {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TYPEP_SEQ")
	@SequenceGenerator(sequenceName = "typep_seq", initialValue = 1, allocationSize = 1, name = "TYPEP_SEQ")
	private Long id;
	private String typeProduit;
	
	public Typep() {}

	public Typep(String typeProduit) {
		super();
		this.typeProduit = typeProduit;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTypeProduit() {
		return typeProduit;
	}

	public void setTypeProduit(String typeProduit) {
		this.typeProduit = typeProduit;
	}

	
	
}
