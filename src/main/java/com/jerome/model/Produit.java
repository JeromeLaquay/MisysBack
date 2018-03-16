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
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PRODUIT_SEQ")
	@SequenceGenerator(sequenceName = "produit_seq", initialValue = 1, allocationSize = 1, name = "PRODUIT_SEQ")
	private Long id;
	private String title;
	private String image_url;
	private int annee_sortie;
	private String genre;
	private String description;
	@ManyToOne
	private Auteur auteur;
	
	public Produit() {}

	public Produit(String title, String image_url, int annee_sortie, String genre, String description, Auteur auteur) {
		super();
		this.title = title;
		this.image_url = image_url;
		this.annee_sortie = annee_sortie;
		this.genre = genre;
		this.description = description;
		this.auteur = auteur;
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
	
	
}
