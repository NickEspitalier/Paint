package commandes;

import com.sun.glass.ui.Screen;
import controlleurs.Souris;
import modele.Figure;
import modele.ModeleApplication;

import java.util.ArrayList;

/**
 * Commande qui a pour but d'appliquer une technique de translation à une perspective. En d'autres termes, elle permet
 * à l'utilisateur de déplacer une instance de l'image connectée à sa perspective dans son panneau respectif.
 */
public class CommandeTranslation extends Commande {

    public void executer(ModeleApplication modele) {

        // Les deux perspective qui peuvent se déplacer
        Figure perspective1 = modele.recupererImages().get(1);
        Figure perspective2 = modele.recupererImages().get(2);


        // Création du nouveau centre de l'image selon le déplacement en x et y de la souris
        int dx = Souris.getDx();
        int dy = Souris.getDy();
        int[] nouveauCentreImage = { dx, dy };


        // Selon la perspective ou la souris se trouve, faire déplacer l'image dans la perspective en question
        if(Souris.getPerspectiveActuel() == "Perspective1"){
            perspective1.modifierPosition(nouveauCentreImage);
        }
        if(Souris.getPerspectiveActuel() == "Perspective2"){
            perspective2.modifierPosition(nouveauCentreImage);
        }
    }
}
