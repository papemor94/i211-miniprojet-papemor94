package com.example.rest.services;

import java.util.List;
import java.util.UUID;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.example.rest.models.BibliothequeDaoRepositoryJPA;
import com.example.rest.models.Livre;

@Path("/bibliotheque")
public class BibliothequeService {

    BibliothequeDaoRepositoryJPA  bibliothequeDaoRepositoryJPA= new BibliothequeDaoRepositoryJPA() ;

    public BibliothequeService(){

	}
	/**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
	@Path("/livres")
    @GET
    @Produces({MediaType.APPLICATION_JSON ,MediaType.APPLICATION_XML})
    public List<Livre> getLivres(){
        System.out.println(bibliothequeDaoRepositoryJPA.findAll());
        return bibliothequeDaoRepositoryJPA.findAll();
    }
	@Path("/livres/{idP}")
	@GET
	@Produces({MediaType.APPLICATION_JSON , MediaType.APPLICATION_XML})
    public Livre getLivre(@PathParam(value  = "idP")int idP){
		System.out.println("search by identity");
		System.out.println(bibliothequeDaoRepositoryJPA.findById(idP)+ "par id ");
    	return bibliothequeDaoRepositoryJPA.findById(idP);
	}
    @PUT
	@Consumes({MediaType.APPLICATION_JSON , MediaType.APPLICATION_XML})
	public void create(Livre livre ){
       // Livre  livre  = new Livre(nom  , auteur , categorie) ;
        //livre.setCategorie(categorie);
    	bibliothequeDaoRepositoryJPA.save(livre);
	}
}

