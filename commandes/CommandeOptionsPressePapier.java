package commandes;

import modele.ModeleApplication;
import vue.FenetreStrategieCopie;

/**
 * Commande qui a pour but d'afficher la fenêtre Swing qui dicte la stratégie du presse-papier.
 */
public class CommandeOptionsPressePapier extends Commande {
    public void executer(ModeleApplication modele) { new FenetreStrategieCopie(modele); }
}

