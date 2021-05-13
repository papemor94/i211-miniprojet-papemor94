package com.example.rest.models;

import jdk.nashorn.internal.ir.annotations.Immutable;
import lombok.*;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.UUID;

@Data
@Getter @Setter
@Builder
@Entity
@Table
@NoArgsConstructor
@XmlRootElement
public class Livre implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	@XmlElement
	private int livreId;
	private String Categorie  ; 
	private String nom ;

	public Livre(int livreId, String categorie, String nom, Auteur auteur) {
		this.livreId = livreId;
		Categorie = categorie;
		this.nom = nom;
		this.auteur = auteur;
	}
	@ManyToOne()
	private  Auteur   auteur ;
}
