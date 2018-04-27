package com.jerome.model;

import java.util.ArrayList;
import java.util.Date;
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
public class Auteur {
	@Id
    @GeneratedValue
	private Long id;
	private String nom;
	private String prenom;
	private Date date_naissance;
	@JsonIgnore
	@OneToMany(mappedBy="auteur", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Produit> produits = new ArrayList<>();
	
	public Auteur() {}

	public Auteur(String nom, String prenom, Date date_naissance, List<Produit> produits) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.date_naissance = date_naissance;
		this.produits = produits;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Date getDate_naissance() {
		return date_naissance;
	}

	public void setDate_naissance(Date date_naissance) {
		this.date_naissance = date_naissance;
	}

	public List<Produit> getProduits() {
		return produits;
	}

	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}

	
	
}
