package com.example.rest;

import com.example.rest.models.BibliothequeDaoRepositoryJPA;
import com.example.rest.models.Livre;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.io.IOException;
import java.net.URI;

/**
 * Main class.
 *
 */
public class Main {

    // Base URI the Grizzly HTTP server will listen on
    public static final String BASE_URI = "http://0.0.0.0:8091/";
    /**
     * Starts Grizzly HTTP server exposing JAX-RS resources defined in this application.
     * @return Grizzly HTTP server.
     */
    public static HttpServer startServer() {
        // create a resource config that scans for JAX-RS resources and providers
        // in com.example.rest package
        final ResourceConfig rc = new ResourceConfig().packages("com.example.rest" , "com.example.rest.services");
        // create and start a new instance of grizzly http server
        // exposing the Jersey application at BASE_URI
        return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);
    }

    /**
     * Main method.
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
BibliothequeDaoRepositoryJPA bibliothequeDaoRepositoryJPA= new BibliothequeDaoRepositoryJPA();

Livre livre  = new Livre("crypto" , "Stinson") ;
livre.setCategorie("ousm");
        System.out.println(livre.toString());
        bibliothequeDaoRepositoryJPA.save(livre);

      /*  System.out.println(bibliothequeDaoRepositoryJPA.findAll());
        System.out.println( bibliothequeDaoRepositoryJPA.findByCategorie("cat111"));
*/
        //System.out.println("Generated Employee ID = " + employee.getEmployeeId());
       System.out.println();
        final HttpServer server = startServer();
        System.out.println(String.format("Jersey app started with WADL available at "
                + "%sapplication.wadl\nHit enter to stop it...", BASE_URI));
        System.in.read();
        server.stop();

    }
}

