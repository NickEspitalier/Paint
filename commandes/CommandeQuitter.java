package commandes;

import modeles.ModeleApplication;

/**
 * Commande qui a pour but de quitter l'application.
 */
public class CommandeQuitter extends Commande {
    public void executer(ModeleApplication modele) { System.exit(0); }
}
