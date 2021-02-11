package com.example.rest.models;

import java.util.List;
import java.util.UUID;

public interface IBibliotheque {

    public void ajouterLivre(Livre livre);
    public void  ajouterLivre(String nom  , String auteur , String categorie ) ;
    public void supprimerLivre(UUID id) ;
    public List<Livre> getLivres() ;
    public Livre getLivre(UUID id ) ;

}
