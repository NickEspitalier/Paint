package commandes;

import vue.FenetreStrategieCopie;

public class CommandeOptionsPressePapier implements Commande {
    public void executer() { new FenetreStrategieCopie(); }
}
