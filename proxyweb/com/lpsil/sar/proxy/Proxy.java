/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lpsil.sar.proxy;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe Proxy pour tester la recherche et l'affichage d'une page web
 * @author pchevallot
 */
public class Proxy {

    public static void main(String[] args) {
        try {
            System.out.println("*");
            Socket so = new Socket("www.google.com",80);
           
            System.out.println("**");
            InputStreamReader isr = new InputStreamReader(so.getInputStream());
           
           BufferedReader br = new BufferedReader(isr);
           
           BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(so.getOutputStream()));
           
           System.out.println(so.isConnected());
            System.out.println(so.getInetAddress());
           String line = "";
           System.out.println(  so.getLocalAddress());
         
           bw.write("GET / HTTP/1.1\r\n\r\n"+ "HOST: www.google.com\n");
           bw.flush();
          
           while((line = br.readLine())!=null && line.length()!=0)
           {
             
               System.out.println("rec : "+br.readLine());
               
           }
           bw.close();
           br.close();
           so.close();
        } catch (UnknownHostException ex) {
            Logger.getLogger(Proxy.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Proxy.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
