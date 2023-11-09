package vue;

import modeles.ModeleApplication;

/**
 * Programme qui simule une application de modification d'une image à l'intérieur de perspectives.
 *
 * @author Dominic Achkarian (ACHD28079808)
 * @author Nicholas Espitalier ()
 * @author Thomas Lavoie ()
 * @version Copyright A2023
 */
public class ApplicationAffichageImages {

    public static void main(String[] args) {
        // On initialise le modèle de l'application, puis on exécute la fenêtre principale avec celui-ci.
        ModeleApplication modele = new ModeleApplication();
        new FenetrePrincipale(modele);
    }
}
