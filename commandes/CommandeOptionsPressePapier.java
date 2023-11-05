package commandes;

import mvc.FenetreStrategieCopie;

public class CommandeOptionsPressePapier implements Commande {
    public void executer() { new FenetreStrategieCopie(); }
}
