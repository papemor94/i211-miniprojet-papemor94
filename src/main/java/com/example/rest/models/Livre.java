package com.example.rest.models;

import jdk.nashorn.internal.ir.annotations.Immutable;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table
@XmlRootElement
public class Livre implements Serializable{
	@XmlAttribute
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private UUID livreId;
	private String Categorie  ; 
	private String nom ;


	@ManyToOne(fetch = FetchType.EAGER, optional = true)
	@JoinColumn(nullable = false)

	@XmlElement
	private  Auteur   auteur ;


	public Livre() {
		livreId = UUID.randomUUID();
	}

	public UUID getId() {
		return livreId;
	}

	public Livre(String nom, Auteur auteur ,String categorie) {
		super();
		livreId = UUID.randomUUID();
		this.nom = nom;
		this.auteur = auteur;
		this.Categorie = categorie ;
	}
	public String getCategorie() {
		return Categorie;
	}
	public void setCategorie(String categorie) {
		Categorie = categorie;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Auteur getAuteur() {
		return auteur;
	}
	public void setAuteur(Auteur auteur) {
		this.auteur = auteur;
	}
	@Override
	public String toString() {
		return ""+livreId+"Livre [ Categorie=" + Categorie + ", nom=" + nom + ", auteur=" + auteur + "]";
	} 

}
