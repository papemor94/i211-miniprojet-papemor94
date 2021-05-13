package com.example.rest.models;

import org.glassfish.jersey.internal.util.Producer;

import java.util.List;
import java.util.UUID;

public interface IBibliothequeDaoRepositoryJPA {


    /**
     *
     * initialize the database
     */
    public void init();

    /**
     *
     * add a new Book
     * @param livre
     */
    public void save(Livre livre);
    /**
     *
     * find a book
     * @param id
     * @return
     */
    public Livre findBookById(int id) ;
    /**
     *  get all Books from the db
     * @return
     */
    public List<Livre> findAllBook() ;

    /**
     *
     * get a Book why categorie contain the query param
     * @param ms
     * @return
     */
    public List<Livre> findBookByCategorie(String ms) ;


    /**
     *
     * Delete a book by it's id
     * @param id
     * @return
     */
    public void removeBook(int id) ;
    /**
     *
     * add  a new Author
     * @param id
     */
    public Auteur findAuthor(int id);

    /**
     *
     * add  a new Author
     * @param auteur
     */
    public void save(Auteur auteur);

    /**
     *
     * detete a Book by id
     * @param id
     */
    public void removeAuteur(int id ) ;

    /**
     *
     * find all Author
     * @return
     */
    public List<Auteur> findAllAuthor() ;



}
