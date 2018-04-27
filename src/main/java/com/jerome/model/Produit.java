package com.jerome.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Produit {

	@Id
    @GeneratedValue
	private Long id;
	private String title;
	private String image_url;
	private int annee_sortie;
	private String genre;
	private String description;
	private double prix;
	@ManyToOne
	private Auteur auteur;
	@ManyToOne
	private Typep typep;
	
	public Produit() {}

	public Produit(Long id, String title, String image_url, int annee_sortie, String genre, String description,
			double prix, Auteur auteur, Typep typep) {
		super();
		this.id = id;
		this.title = title;
		this.image_url = image_url;
		this.annee_sortie = annee_sortie;
		this.genre = genre;
		this.description = description;
		this.prix = prix;
		this.auteur = auteur;
		this.typep = typep;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImage_url() {
		return image_url;
	}

	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}

	public int getAnnee_sortie() {
		return annee_sortie;
	}

	public void setAnnee_sortie(int annee_sortie) {
		this.annee_sortie = annee_sortie;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Auteur getAuteur() {
		return auteur;
	}

	public void setAuteur(Auteur auteur) {
		this.auteur = auteur;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public Typep getTypep() {
		return typep;
	}

	public void setTypep(Typep typep) {
		this.typep = typep;
	}
	
	
}
