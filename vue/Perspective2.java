package vue;

import modele.Figure;
import modele.ModeleApplication;

import javax.swing.*;
import java.awt.*;

/**
 * Panneau Swing qui représente le troisième élément principal du programme, soit la deuxième perspective. Une
 * perspective a pour objectif d'afficher une image qui a été chargée par l'utilisateur, et ensuite d'être modifiée
 * selon les demandes de l'utilisateur.
 */
public class Perspective2 extends JPanel implements ObservateurModele {
    /**** Initialisation des variables ****/
    private ModeleApplication modele;                   // Modèle de l'application
    private Figure perspective2;                         // Troisième instance de l'image contenue dans le modèle

    /**
     * Constructeur d'initialisation. Le panneau récupère les données du modèle de l'application, et ensuite crée son
     * contour.
     *
     * @param modele Modèle de l'application
     */
    public Perspective2(ModeleApplication modele) {
        this.modele = modele;
        setBorder(BorderFactory.createLineBorder(Color.blue, 4));
    }

    /**
     * Met à jour le panneau au cas où le modèle contient des instances d'une image.
     */
    public void mettreAJour() {
        if (!modele.recupererImages().isEmpty()) {
            perspective2 = modele.recupererImages().get(2);

            if (perspective2.recupererPosition() == null) {
                int[] centreDuPanneau = { (getWidth() / 2) - (perspective2.recupererTaille()[0] / 2),
                        (getHeight() / 2) - (perspective2.recupererTaille()[1] / 2), } ;
                modele.mettreAJourPositionImage(2, centreDuPanneau);
            }

            repaint();
        }
    }

    /**
     * Peint le panneau avec l'instance de l'image récupérée.
     */
    protected void paintComponent(Graphics g) {
        if (perspective2 != null) {
            super.paintComponent(g);
            g.drawImage(perspective2.recupererApparence(), perspective2.recupererPosition()[0],
                    perspective2.recupererPosition()[1], perspective2.recupererTaille()[0],
                    perspective2.recupererTaille()[1], this);
        }
    }
}
