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
    ArrayList<Figure> images = new ArrayList<>();           // Liste des instances de l'image chargée
    String choixPressePapier;                               // Choix de la stratégie du presse-papier
    boolean premierChargement = true;

    /**
     * Reçoit une image chargée par l'utilisateur, puis duplique celle-ci en deux instances avant de tous les inclure
     * dans la liste.
     *
     * @param im Une image chargée par l'utilisateur
     */
    public void stockerNouvelleImage(Image im) {
        for (int i = 0; i < 3; i++) {
            Figure nouvelleImage = new Figure(im, null, new int[] { im.getWidth(null),
                    im.getHeight(null)});
            if (premierChargement) { images.add(nouvelleImage); } else { images.set(i, nouvelleImage); }
        }
        premierChargement = false;
    }

    public void mettreAJourPositionImage(int numPerspective, int[] pos) {
        images.get(numPerspective).modifierPosition(pos);
    }

    public void mettreAJourTailleImage(int numPerspective, int[] taille) {
        images.get(numPerspective).modifierTaille(taille);
    }

    // Setters et Getters des variables du modèle
    public void choisirOptionsPressePapier(String choix) { this.choixPressePapier = choix; }
    public ArrayList<Figure> recupererImages() { return images; }
    public String recupererChoixPressePapier() { return choixPressePapier; }
}
