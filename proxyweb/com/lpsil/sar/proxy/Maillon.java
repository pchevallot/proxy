/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lpsil.sar.proxy;

/**
 * Définit l'interface d'un maillon de la chaine.
 * @author pchevallot
 */
public abstract class Maillon {

    private Maillon suivant;
    
    
    /**
     * Fixe le maillon suivant dans la chaine
     * @param pSuivant
     */
    public void setSuivant(Maillon pSuivant) {
        suivant = pSuivant;
    }
    
    /**
     * Appelle le traitement sur le maillon courant
     * Puis demande au maillon suivant d'en faire autant,
     * si le maillon courant n'a pas géré l'opération.
     * @param pNombre
     * @return Si l'opération a été gérée.
     */
    public String operation(Requete req) {
        operationSpec(req);
        
        if(suivant != null) {
            return suivant.operation(req);
        }
        return req.getResultat();
    }

    public abstract void operationSpec(Requete req);
}
