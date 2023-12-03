package commandes;

import modele.ModeleApplication;

/**
 * Commande qui a pour but de défaire une commande précédente.
 */
public class CommandeDefaire extends Commande {

    private GestionnaireDeCommande gestionnaireDeCommande = GestionnaireDeCommande.getInstance();

    public void executer(ModeleApplication modele) {
        Commande commande = gestionnaireDeCommande.getLastCommande();
        commande.executer(modele);
    }

}
