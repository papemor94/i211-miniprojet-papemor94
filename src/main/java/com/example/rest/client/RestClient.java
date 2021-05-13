package com.example.rest.client;



import lombok.extern.java.Log;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

/**
 * Client created 13/05/2021
 */
@Log
public class RestClient {
    public static void main(String[] args) {


        Client client = ClientBuilder.newClient();
        WebTarget webResource = client.target("http://localhost:8091");

        String res = webResource.path("/bibliotheque/livres").request().get(String.class) ;
        System.out.println(res);

      /*  //Log in to get the token with basic authentication
        String login = "admin" ;
        String password  = "admin" ;
        String token = webResource.path("android/auth")
                .request()
                .accept(MediaType.APPLICATION_JSON)
                .header("Authorization", "Basic " + java.util.Base64.getEncoder().encodeToString((login + ":" + password).getBytes()))
                .get(String.class);
        System.out.println(token);
        token = token.substring(9,token.length()-1);
        System.out.println(token);



        //log.info(result);
        System.out.println("response from server auth secure :  " + result.substring(14,result.length()-1));

        // effectuer un post en mod non secure
        String input  = "{\"firstname\" :\"Ablaye\" , \"lastname\": \"FOFANA\" , \"login\": \"log\", \"password\":\"pass\", \"isAdmin\":1}";

        // on veut recuperer dui Json don
       String  result2 = webResource.path("android/utilisateurs")
                .request()
                .header("Authorization", "Bearer " + token)
                .accept(MediaType.APPLICATION_JSON)
                .post(Entity.entity(input, MediaType.APPLICATION_JSON), String.class);
        System.out.println("response post method  :  " + result2);



*/

    }
}