package com.example.rest.models;

import jdk.nashorn.internal.ir.annotations.Immutable;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table
@XmlRootElement
public class Livre implements Serializable{
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private UUID studentId;
	private String Categorie  ; 
	private String nom ;   ; 
    private String auteur ;


	public Livre() {
		studentId = UUID.randomUUID();
		/*****
		 *    id  generated automaticaly
		 * */
	      //id   = UUID.randomUUID();
		/****
		 * @ logging
		 */

	}

	/*public UUID getId() {
		return id;
	}*/

	public Livre(String nom, String auteur) {

		super();
		studentId = UUID.randomUUID();
		this.nom = nom;
		this.auteur = auteur;
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
	public String getAuteur() {
		return auteur;
	}
	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}
	@Override
	public String toString() {
		return ""+studentId+"Livre [ Categorie=" + Categorie + ", nom=" + nom + ", auteur=" + auteur + "]";
	} 

}
