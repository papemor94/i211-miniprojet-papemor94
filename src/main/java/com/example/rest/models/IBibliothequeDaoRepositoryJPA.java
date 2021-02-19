package com.example.rest.models;

import org.glassfish.jersey.internal.util.Producer;

import java.util.List;
import java.util.UUID;

public interface IBibliothequeDaoRepositoryJPA {

    public void save(Livre livre);
    public void save(Book book);
    public void save(Auteur auteur);
    public List<Livre> findAll() ;
    public List<Book> getAllBook();
    public List<Livre> findByCategorie(String ms) ;
    public void update(Livre livre) ;
    public void deleteById(UUID id ) ;
    public Livre findById(UUID idd) ;


}
