package controlleurs;

import commandes.Commande;

public class ControlleurPerspectives {
    private final Commande pressePapier;
    private final Commande translation;
    private final Commande zoom;

    public ControlleurPerspectives(Commande pressePapier, Commande translation, Commande zoom) {
        this.pressePapier = pressePapier;
        this.translation = translation;
        this.zoom = zoom;
    }

    public void copierColler() { pressePapier.executer(); }
    public void deplacerPerspective() { translation.executer(); }
    public void agrandirPerspective() { zoom.executer(); }
}
