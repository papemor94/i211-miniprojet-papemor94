package com.example.rest.models;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class BibilothequeRepository implements IBibliotheque {
	private  static BibilothequeRepository sInstance  = null  ;
	private List<Livre> livres ;

	private BibilothequeRepository(){ livres = new ArrayList<>();
	}
	@Override
	public List<Livre> getLivres() {
		return livres;
	}

	@Override
	public void ajouterLivre(Livre livre) {
		livres.add(livre) ;
	}
	@Override
	public void  ajouterLivre(String nom  , String auteur , String categorie ) {
		Livre livre  = new Livre() ;
		livre.setAuteur(auteur);
		livre.setCategorie(categorie);
		livre.setNom(nom);
		livres.add(livre) ;
	}
	@Override
	public void supprimerLivre(UUID id) {
		livres.remove(livres.stream().filter(p->p.getId()==id));
	}

	public Livre getLivre(UUID uuid){
		return (Livre) livres.stream().filter(p->p.getId()==uuid);

}
	@Override
	public String toString() {
		return "BibilothequeRepository [livres=" + livres + "]";
	}

	public static BibilothequeRepository getsInstance(){
		if(sInstance==null){
			sInstance = new BibilothequeRepository() ;
		}
		return  sInstance;
	}
}











/*
	public BibilothequeRepository() {
		livres  = new ArrayList<Livre>() ;
		this.addLivre("cryptographie", "stinson", "malib");
		this.addLivre("java", "heo", "lsls");
		this.addLivre("b", "nocibe", "po");
		this.addLivre("c", "fort", "hesink");
 */