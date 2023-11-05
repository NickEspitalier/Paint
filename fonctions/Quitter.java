package fonctions;

import mvc.ModeleApplication;

public class Quitter implements Commande {
    private ModeleApplication modele;

    public Quitter (ModeleApplication md) { this.modele = md; }
    public void executer() { this.modele.quitter(); }
}
