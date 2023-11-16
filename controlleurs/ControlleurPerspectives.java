package controlleurs;

import commandes.Commande;
import modele.ModeleApplication;

/**
 * Classe représentant le controlleur des perspectives de l'application. Dans l'architecture MVC, le controlleur a
 * pour but d'exécuter les commandes demandées par l'utilisateur. Ce controlleur est responsable de l'exécution des
 * opérations des commandes de l'utilisateur qui sont connectées aux perspectives, tel que l'application de la
 * technique de translation, ou de la technique du "zoom".
 */
public class ControlleurPerspectives {
    /**** Initialisation des variables ****/
    private Commande pressePapier, translation, zoomIn, zoomOut;         // Commandes connectées aux perspectives
    private ModeleApplication modele;                         // Modèle de l'application

    /**
     * Constructeur d'initialisation avec variables.
     */
    public ControlleurPerspectives(Commande pressePapier, Commande translation, Commande zoomIn, Commande zoomOut,
                                   ModeleApplication ma) {
        this.pressePapier = pressePapier;
        this.translation = translation;
        this.zoomIn = zoomIn;
        this.zoomOut = zoomOut;
        this.modele = ma;
    }

    // Méthodes d'exécution des commandes des perspectives
    public void copierColler() { pressePapier.executer(modele); }
    public void deplacerPerspective() { translation.executer(modele); }
    public void changerTaillePerspective(int rotation) {
        if (rotation < 0) { zoomIn.executer(modele); }
        else { zoomOut.executer(modele); }
    }
}
