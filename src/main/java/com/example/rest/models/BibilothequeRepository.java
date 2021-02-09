package com.example.rest.models;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class BibilothequeRepository {
	
	private List<Livre> livres ;
	public BibilothequeRepository() {
		livres  = new ArrayList<Livre>() ;
		this.addLivre("cryptographie", "stinson", "malib");
		this.addLivre("java", "heo", "lsls");
		this.addLivre("b", "nocibe", "po");
		this.addLivre("c", "fort", "hesink");
	}

	public List<Livre> getLivres() {
		return livres;
	}


	public void setLivres(ArrayList<Livre> livres) {
		this.livres = livres;
	} 
	
	public void  addLivre(String nom  , String auteur , String categorie ) {

		Livre livre  = new Livre() ;
		livre.setAuteur(auteur);
		livre.setCategorie(categorie);
		livre.setNom(nom);
		livres.add(livre) ;
	}
public Livre getLivre(UUID uuid){
		return (Livre) livres.stream().filter(p->p.getId()==uuid);

}
	@Override
	public String toString() {
		return "BibilothequeRepository [livres=" + livres + "]";
	}
}
