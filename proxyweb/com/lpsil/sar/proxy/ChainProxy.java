/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lpsil.sar.proxy;

/**
 *
 * @author ProgX-73
 */
public class ChainProxy {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Requete query = new Requete();
        
        CherchePageMaillon cp = new CherchePageMaillon();
        CacheMaillon cp2 = new CacheMaillon();
        
         cp2.setSuivant(cp);
         
          System.out.println(cp2.operation(query));
        
    }
}
