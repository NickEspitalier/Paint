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
        ModeleApplication modele = new ModeleApplication();          // Modèle de l'application
        new FenetrePrincipale(modele);
    }
}
