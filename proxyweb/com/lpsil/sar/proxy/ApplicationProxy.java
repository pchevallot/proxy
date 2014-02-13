package com.lpsil.sar.proxy;
import java.io.*;
import java.net.*;

public class ApplicationProxy extends Thread
{
    Integer autorizedPort [] = {80,8080};
    Socket sock_com;

    Blacklist b = new Blacklist();
    public ApplicationProxy(Socket sock_com) throws SocketException
    {
        this.sock_com=sock_com;
    }

    public void run()
    {
        try
        {
            System.out.println(" "+ sock_com.getInetAddress());

            //Le client qui s'est connecte est connu par getInetAdress et getHostName

            InetAddress origin = sock_com.getInetAddress();
            System.out.println("Connection venant de : "+ origin.getHostName());

            //un BufferedReader permet de lire par ligne
            BufferedReader in = new BufferedReader(new InputStreamReader(sock_com.getInputStream()));

            //Un PrintWriter possede toutes les operations print classique
            //En mode auto-flush, le tampon est vide (flush) a l'appel de println.

            PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(sock_com.getOutputStream())),true);
            String requete = in.readLine(); //lecture de la requete

            System.out.println(requete);

            RequeteProxy request = new RequeteProxy(requete);

            System.out.println(request);

            boolean found =false;

            for(int i=0; i < autorizedPort.length;i++)
            {
                if(autorizedPort[i] == request.port)
                    found = true;
            }

            if(found) //si le port est autorisé, on continue l'execution
            {
                System.out.println("L'adresse IP: "+origin.getHostName()+" est autorisée!");
            }

            in.close();
            out.close();
            sock_com.close();
        }
        catch(IOException e)
        {
            System.out.println("Erreur d'entree sortie "+e);
        }
    }
}
