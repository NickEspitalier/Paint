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

    private final Souris souris = new Souris();

    public void executer(ModeleApplication modele) {

        // Les deux perspective qui peuvent se déplacer
        Figure perspective1 = modele.recupererImages().get(1);
        Figure perspective2 = modele.recupererImages().get(2);

        // Création du nouveau centre de l'image selon le déplacement en x et y de la souris
        int dx = souris.getDx();
        int dy = souris.getDy();
        int[] nouveauCentreImage = { dx, dy } ;

        // Compare la position des perspectives avec le nouveau centre de l'image
        if(perspective1.recupererPosition() != nouveauCentreImage){
            perspective1.modifierPosition(nouveauCentreImage);
        }
        else if(perspective2.recupererPosition() != nouveauCentreImage){
            perspective2.modifierPosition(nouveauCentreImage);
        }
    }
}
