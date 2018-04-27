package com.jerome.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Typep {
	
	@Id
    @GeneratedValue
	private Long id;
	private String typeProduit;
	@JsonIgnore
	@OneToMany(mappedBy="typep", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Produit> produits;
	
	public Typep() {}

	public Typep(Long id, String typeProduit, List<Produit> produits) {
		super();
		this.id = id;
		this.typeProduit = typeProduit;
		this.produits = produits;
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

	public List<Produit> getProduits() {
		return produits;
	}

	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}

	
	
}
