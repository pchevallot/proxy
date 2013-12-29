/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lpsil.sar.proxy;

/**
 *
 * @author ProgX-73
 */
/**
 * Sous-classe concrète qui définit un maillon de la chaine.
 */
public class CherchePageMaillon extends Maillon {

    /**
     * Méthode affichant un message 
     * si le nombre passé en paramètre est pair
     * @return true, si la maillon a géré l'opération
     */
    public void operationSpec(Requete req) {
        
       req.setResultat(req.getResultat()+"passé par "+this.getClass().getSimpleName()+"\n");
    }
}
