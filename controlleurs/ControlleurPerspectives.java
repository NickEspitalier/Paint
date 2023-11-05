package controlleurs;

import commandes.Commande;
import modeles.ModeleApplication;

public class ControlleurPerspectives {
    private final Commande pressePapier, translation, zoom;
    private final ModeleApplication modele;

    public ControlleurPerspectives(Commande pressePapier, Commande translation, Commande zoom, ModeleApplication ma) {
        this.pressePapier = pressePapier;
        this.translation = translation;
        this.zoom = zoom;
        this.modele = ma;
    }

    public void copierColler() { pressePapier.executer(modele); }
    public void deplacerPerspective() { translation.executer(modele); }
    public void agrandirPerspective() { zoom.executer(modele); }
}
