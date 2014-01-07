/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lpsil.sar.proxy;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author pchevallot
 */
public class ChainProxy {

    public static void main(String[] args) {
    	
    	try {
			ServerSocket server = new ServerSocket(8889); // Création du serveur et son port d'écoute
			while(true) // utilisation d'une boucle infinie pour mettre le serveur en écoute permanente
			{
			System.out.println("Client en attente");
			Socket client = server.accept(); // Création de la socket client
			System.out.println("Client connecté");
			Thread fils = new Thread(new Application(client)); // Création d'un thread paralèlle
			fils.start();
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}
        
    	/*
        Requete query = new Requete();
        
        CherchePageMaillon cp = new CherchePageMaillon();
        CacheMaillon cp2 = new CacheMaillon();
        
         cp2.setSuivant(cp);
         
          System.out.println(cp2.operation(query));
          */
        
    }
}
