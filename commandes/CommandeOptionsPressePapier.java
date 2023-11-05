package commandes;

import modeles.ModeleApplication;
import vue.FenetreStrategieCopie;

public class CommandeOptionsPressePapier extends Commande {
    public void executer(ModeleApplication modele) { new FenetreStrategieCopie(modele); }
}
