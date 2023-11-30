package commandes;

import controlleurs.Souris;
import modele.Figure;
import modele.ModeleApplication;

/**
 * Commande qui a pour but de faire un "zoom" sur l'image. En d'autres termes, elle permet à l'utilisateur d'agrandir
 * une instance de l'image connectée à sa perspective dans son panneau respectif.
 */
public class CommandeAgrandir extends Commande {
    public void executer(ModeleApplication modele) {

        Figure image1 = modele.recupererImages().get(1);
        Figure image2 = modele.recupererImages().get(2);

        int[] tailleInitialImage1 = image1.recupererTaille();
        int[] tailleInitialImage2 = image2.recupererTaille();

        // Selon la perspective de la souris actuel, agrandir l'image approprier
        if(Souris.getPerspectiveActuel() == "Perspective1"){

            int[] tailleFinalImage1 = new int[]{tailleInitialImage1[0] - Souris.getSensDeLaMolette(),
                    tailleInitialImage1[1] - Souris.getSensDeLaMolette() };

            if(tailleInitialImage1[0] >= 0 && tailleInitialImage1[1] >= 0){
                modele.mettreAJourTailleImage(1, tailleFinalImage1);
            }
        }
        if(Souris.getPerspectiveActuel() == "Perspective2"){

            int[] tailleFinalImage2 = new int[]{tailleInitialImage2[0] - Souris.getSensDeLaMolette(),
                    tailleInitialImage2[1] - Souris.getSensDeLaMolette() };

            if(tailleFinalImage2[0] >= 0 && tailleFinalImage2[1] >= 0){
                modele.mettreAJourTailleImage(2, tailleFinalImage2);
            }
        }

    }
}
