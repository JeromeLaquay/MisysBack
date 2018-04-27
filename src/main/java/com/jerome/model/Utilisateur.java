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
public class Utilisateur {
  @Id
  @GeneratedValue
  private Long idutilisateur;

  private String nom;
  
  private String prenom;
  
  private String mail;
  
  private String password;
  
  private int role;
  

  

	public Utilisateur() {
		super();
	}


	public Utilisateur(Long idutilisateur, String nom, String prenom, String mail, String password, int role
			) {
		super();
		this.idutilisateur = idutilisateur;
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.password = password;
		this.role = role;
	}


	public Long getIdutilisateur() {
		return idutilisateur;
	}


	public void setIdutilisateur(Long idutilisateur) {
		this.idutilisateur = idutilisateur;
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


	public String getMail() {
		return mail;
	}


	public void setMail(String mail) {
		this.mail = mail;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public int getRole() {
		return role;
	}


	public void setRole(int role) {
		this.role = role;
	}
  
 }