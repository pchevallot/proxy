package com.lpsil.sar.proxy;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Serveur
{
    public static void main(String[] args) throws Exception
    {
        ServerSocket ecoute = new ServerSocket(3128); //On ecoute sur le port 3128 pour le proxy
        System.out.println("\n Le Serveur recoit sur le port : " + ecoute.getLocalPort());

        System.out.println(">>> Serveur pret !! ");
        while(true)
        {
            try
            {
                //Acceptation d'une connexion client
                Socket client = ecoute.accept();
                //Creation d'un fils par un thread
                Thread fils = new Thread(new ApplicationProxy(client));
                fils.start();
            }
            catch(IOException e)
            {
                System.out.println("Erreur d'entree sortie "+e);
            }
        }
    }
}
