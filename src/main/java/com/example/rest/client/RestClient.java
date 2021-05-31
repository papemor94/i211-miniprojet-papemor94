package com.example.rest.client;


import lombok.extern.java.Log;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.net.*;
import java.util.Enumeration;

/**
 * Client created 13/05/2021
 */
@Log
public class RestClient {

    public static String getIpAdress() {
        String ip;
        try {
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
            while (interfaces.hasMoreElements()) {
                NetworkInterface iface = interfaces.nextElement();
                // filters out 127.0.0.1 and inactive interfaces
                if (iface.isLoopback() || !iface.isUp())
                    continue;

                Enumeration<InetAddress> addresses = iface.getInetAddresses();
                while (addresses.hasMoreElements()) {
                    InetAddress addr = addresses.nextElement();

                    // *EDIT*
                    if (addr instanceof Inet6Address) continue;

                    ip = addr.getHostAddress();
                    if (iface.getDisplayName().contains("Wireless"))
                        return ip;
                    System.out.println("" + " " + ip);
                }
            }
        } catch (SocketException e) {
            throw new RuntimeException(e);
        }
        return  null ;
    }

    public static void main(String[] args) throws UnknownHostException {


        System.out.println(getIpAdress());


        Client client = ClientBuilder.newClient();
        WebTarget webResource = client.target("http://localhost:8091");

        // init the database
        String response  = webResource.path("/bibliotheque/init").request().get(String.class) ;
        System.out.println(response);

        // get all books
        String res = webResource.path("/bibliotheque/livres").request().get(String.class) ;
        System.out.println(res);


        // get a book by id
       // String res2 = webResource.path("/bibliotheque/livres/3").request().get(String.class) ;
        //System.out.println(res2);


        // effectuer un post en mod non secure
        String input  = "{\"firstname\" :\"Jacques\" , \"lastname\": \"Fal\" , \"login\": \"log\", \"password\":\"pass\", \"isAdmin\":1}";
        System.out.println(input);
        // on veut recuperer dui Json don
       String  result2 = webResource.path("/bibliotheque/livres")
                .request()
                .accept(MediaType.APPLICATION_JSON)
                .post(Entity.entity(input, MediaType.APPLICATION_JSON), String.class);
        System.out.println("response post method  :  " + result2);


    }
}