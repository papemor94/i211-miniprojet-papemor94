package com.example.rest.models;

import org.glassfish.jersey.internal.util.Producer;

import java.util.List;
import java.util.UUID;

public interface IBibliothequeDaoRepositoryJPA {

    public void save(Livre livre);

    public void save(Auteur auteur);
    public List<Livre> findAll() ;
    public List<Livre> findByCategorie(String ms) ;
    public void update(Livre livre) ;
    public void deleteById(int id ) ;
    public Livre findById(int idd) ;
    public void init();


}
