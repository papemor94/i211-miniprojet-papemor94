package com.example.rest.services;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.example.rest.models.BibilothequeRepository;
import com.example.rest.models.Livre;

@Path("livres")
public class BibliothequeService {
	public BibilothequeRepository  bibilothequeRepository   ;

	public BibliothequeService(){
		bibilothequeRepository   = new BibilothequeRepository();
	}
	/**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
	
    @GET
    @Produces({MediaType.APPLICATION_JSON , MediaType.APPLICATION_XML})
    public List<Livre> getLivres() {

    	//System.out.println(bibilothequeRepository.getLivres());
    	
        return bibilothequeRepository.getLivres() ;
    }

	@Path("livres/{id}")
	@GET
	@Produces({MediaType.APPLICATION_JSON , MediaType.APPLICATION_XML})
    public Livre getLivre(@PathParam("id") UUID uuid){
    	return bibilothequeRepository.getLivre(uuid);
	}
    /*@PUT
	@Produces({MediaType.APPLICATION_JSON , MediaType.APPLICATION_XML})

	public int create(String categorie  , String nom , String auteur  ){
    	bibilothequeRepository.addLivre(categorie , nom ,auteur );
		System.out.println("un livre a été ajouté");
		return  1 ;
	}*/
}

