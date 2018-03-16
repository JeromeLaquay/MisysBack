package com.jerome.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Prix {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PRIX_SEQ")
	@SequenceGenerator(sequenceName = "prix_seq", initialValue = 1, allocationSize = 1, name = "PRIX_SEQ")
	private Long id;
	@ManyToOne
	private Produit produit;
	@ManyToOne
	private Typep typep;
	@Column
	private double prix;	
	
	public Prix() {}
	
	public Prix(Produit produit, Typep typep, double prix) {
		super();
		this.produit = produit;
		this.typep = typep;
		this.prix = prix;
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public Typep getTypep() {
		return typep;
	}

	public void setTypep(Typep typep) {
		this.typep = typep;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	
	
}
