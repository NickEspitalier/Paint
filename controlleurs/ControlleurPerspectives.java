package controlleurs;

import commandes.Commande;
import modeles.ModeleApplication;

/**
 * Classe représentant le controlleur des perspectives de l'application. Dans l'architecture MVC, le controlleur a
 * pour but d'exécuter les commandes demandées par l'utilisateur. Ce controlleur est responsable de l'exécution des
 * opérations des commandes de l'utilisateur qui sont connectées aux perspectives, tel que l'application de la
 * technique de translation, ou de la technique du "zoom".
 */
public class ControlleurPerspectives {
    /**** Initialisation des variables ****/
    private final Commande pressePapier, translation, zoom;         // Commandes connectées aux perspectives
    private final ModeleApplication modele;                         // Modèle de l'application

    /**
     * Constructeur d'initialisation avec variables.
     */
    public ControlleurPerspectives(Commande pressePapier, Commande translation, Commande zoom, ModeleApplication ma) {
        this.pressePapier = pressePapier;
        this.translation = translation;
        this.zoom = zoom;
        this.modele = ma;
    }

    /**** Méthodes d'exécution des commandes des perspectives ****/

    public void copierColler() { pressePapier.executer(modele); }
    public void deplacerPerspective() { translation.executer(modele); }
    public void agrandirPerspective() { zoom.executer(modele); }
}
