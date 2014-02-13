package com.lpsil.sar.proxy;
import java.net.*;

public class RequeteProxy
{
    String method;
    URL url;
    String protocol;
    Integer port;
    String path;

    public RequeteProxy(String s)
    {
        String [] recupUrl = s.split(" ");

        method = recupUrl[0];

        try
        {
            this.url = new URL(recupUrl[1]);
        }
        catch(MalformedURLException e)
        {
            System.out.println("Erreur: "+e);
        }

        protocol = url.getProtocol();

        if((port = url.getPort()) == -1)
        {
            port = url.getDefaultPort();
        }
    }


    public String toString()
    {
        return "Method: "+this.method+" URL: "+this.url+" Protocol: "+this.protocol+" Port: "+this.port+" Path: "+this.path;
    }
}
