package commandes;

import modeles.ModeleApplication;

public class CommandeQuitter extends Commande {
    public void executer(ModeleApplication modele) { System.exit(0); }
}
