package commandes;

import controlleurs.Souris;
import modele.Figure;
import modele.ModeleApplication;

/**
 * Commande qui a pour but d'appliquer une technique de translation à une perspective. En d'autres termes, elle permet
 * à l'utilisateur de déplacer une instance de l'image connectée à sa perspective dans son panneau respectif.
 */
public class CommandeTranslation extends Commande {

    private GestionnaireDeCommande gestionnaireDeCommande = GestionnaireDeCommande.getInstance();

    public void executer(ModeleApplication modele) {

        // Les deux images dans les deux perspective qui peuvent se déplacer
        Figure image1 = modele.recupererImages().get(1);
        Figure image2 = modele.recupererImages().get(2);

        // La position actuel des deux images sur leur perspectives
        int[] positioninitial1 = image1.recupererPosition();

        // Création du nouveau centre de l'image selon le déplacement en x et y de la souris
        int dx = Souris.getDx();
        int dy = Souris.getDy();
        int[] déplacementImage = { dx, dy };


        // Selon la perspective ou la souris se trouve, faire déplacer l'image dans la perspective
        if(Souris.getPerspectiveActuel() == "Perspective1"){
            // On le mets à jour dans le modele
            modele.mettreAJourPositionImage(1, déplacementImage);
        }

        if(Souris.getPerspectiveActuel() == "Perspective2"){
            modele.mettreAJourPositionImage(2, déplacementImage);
        }

        gestionnaireDeCommande.AjoutCommande(this);
    }
}
