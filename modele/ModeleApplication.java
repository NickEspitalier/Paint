package modele;

import java.awt.*;
import java.util.ArrayList;

/**
 * Classe représentant le modèle de l'application. Dans l'architecture MVC, le modèle a pour but de contenir toutes
 * les données devant être sauvegardées durant l'exécution de l'application pour que celles-ci soient ensuite être
 * utilisées par la vue ou les controlleurs.
 */
public class ModeleApplication extends Sujet {
    /**** Initialisation des variables ****/
    ArrayList<Image> images = new ArrayList<>();            // Liste des instances de l'image chargée
    String choixPressePapier;                               // Choix de la stratégie du presse-papier

    /**
     * Reçoit une image chargée par l'utilisateur, puis duplique celle-ci en deux instances avant de tous les inclure
     * dans la liste.
     *
     * @param im Une image chargée par l'utilisateur
     */
    public void stockerNouvelleImage(Image im) {
        if (images.isEmpty()) {
            for (int i = 0; i < 3; i++) { images.add(im); }
        } else {
            for (int j = 0; j < 3; j++) { images.set(j, im); }
        }
    }

    // Setters et Getters des variables du modèle
    public void choisirOptionsPressePapier(String choix) { this.choixPressePapier = choix; }
    public ArrayList<Image> recupererImages() { return images; }
    public String recupererChoixPressePapier() { return choixPressePapier; }
}
