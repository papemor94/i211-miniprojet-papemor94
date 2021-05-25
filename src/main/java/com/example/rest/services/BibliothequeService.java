package com.example.rest.services;

import java.util.List;
import java.util.UUID;

import javax.persistence.EntityNotFoundException;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.example.rest.models.Auteur;
import com.example.rest.models.BibliothequeDaoRepositoryJPA;
import com.example.rest.models.Livre;
import lombok.experimental.Delegate;

@Path("/bibliotheque")
public class BibliothequeService {
    BibliothequeDaoRepositoryJPA  bibliothequeDaoRepositoryJPA=  BibliothequeDaoRepositoryJPA.getInstance() ;

    public BibliothequeService(){
	}
	/**
	 *
	 * initilize the database
	 * @return
	 */
	@Path("/init")
	@GET
	@Produces({MediaType.APPLICATION_JSON ,MediaType.APPLICATION_XML})
	public String init(){
		bibliothequeDaoRepositoryJPA.init();
		return  " database initialized" ;
	}
	/**
	 *
	 * @return  :  all books of the database
	 */
	@Path("/livres")
    @GET
    @Produces({MediaType.APPLICATION_JSON ,MediaType.APPLICATION_XML})
    public List<Livre> getLivres(){
        System.out.println(bibliothequeDaoRepositoryJPA.findAllBook());
        return bibliothequeDaoRepositoryJPA.findAllBook();
    }
	/**
	 *
	 *  add a new Book
	 * @param livre
	 * @return
	 */
	@Path("/livres")
	@POST
	@Consumes({MediaType.APPLICATION_JSON})
	public String create(Livre livre ){
		bibliothequeDaoRepositoryJPA.save(livre);
		return " Book "+livre.getLivreId()+" saved " ;
	}
	/**
	 *
	 * find a Book by id
	 * @param id
	 * @return
	 */
	@Path("/livres/{id}")
	@GET
	@Produces({MediaType.APPLICATION_JSON , MediaType.APPLICATION_XML})
    public Livre getBook(@PathParam(value  = "id")int id){
		try {


			System.out.println(bibliothequeDaoRepositoryJPA.findBookById(id) + "par id ");

		}catch(EntityNotFoundException e) {
			System.out.println(e.getMessage());
		}
		return bibliothequeDaoRepositoryJPA.findBookById(id);
	}
	/**
	 *
	 * remove book by id
	 * @param id
	 * @return
	 */
	@Path("/livres/{id}")
	@DELETE
	@Produces({MediaType.APPLICATION_JSON , MediaType.APPLICATION_XML})
	public String removeBook(@PathParam(value  = "id")int id){
		System.out.println("search by identity");
		try {
			bibliothequeDaoRepositoryJPA.removeBook(id);
		}catch(EntityNotFoundException e){
		System.out.println(e.getMessage());
	    }
		return " Book "+id+" is deleted " ;
	}
	/**
	 *
	 * @return  :  all authors of the database
	 */
	@Path("/auteurs")
	@GET
	@Produces({MediaType.APPLICATION_JSON ,MediaType.APPLICATION_XML})
	public List<Auteur> getAuthors(){
		System.out.println(bibliothequeDaoRepositoryJPA.findAllAuthor());
		return bibliothequeDaoRepositoryJPA.findAllAuthor();
	}

	/**
	 *
	 *  add a new Author
	 * @param auteur
	 * @return
	 */
	@Path("/auteurs")
	@POST
	@Consumes({MediaType.APPLICATION_JSON})
	public String create(Auteur auteur ){
		bibliothequeDaoRepositoryJPA.save(auteur);
		return " Book "+auteur.getId()+" saved " ;
	}
	/**
	 *
	 * find an Author by id
	 * @param id
	 * @return
	 */
	@Path("/auteurs/{id}")
	@GET
	@Produces({MediaType.APPLICATION_JSON , MediaType.APPLICATION_XML})
	public Auteur getAuthor(@PathParam(value  = "id")int id){
		try {
		System.out.println(bibliothequeDaoRepositoryJPA.findAuthor(id)+ "par id ");
		}catch(EntityNotFoundException e) {
			System.out.println(e.getMessage());
		}
		return bibliothequeDaoRepositoryJPA.findAuthor(id);
	}
	/**
	 *
	 * remove Author by id
	 * @param id
	 * @return
	 */
	@Path("/auteurs/{id}")
	@DELETE
	@Produces({MediaType.APPLICATION_JSON , MediaType.APPLICATION_XML})
	public String removeAuthor(@PathParam(value  = "id")int id){
		System.out.println("search by identity");
		try {
		bibliothequeDaoRepositoryJPA.removeAuteur(id);
		}catch(EntityNotFoundException e) {
			System.out.println(e.getMessage());
		}
		return " Book "+id+" deleted " ;
	}
}

