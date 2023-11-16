package vue;

import modele.Figure;
import modele.ModeleApplication;

import javax.swing.*;
import java.awt.*;

/**
 * Panneau Swing qui représente le premier élément principal du programme, soit la vignette. La vignette a pour
 * objectif d'afficher une image qui a été chargée par l'utilisateur, et ensuite d'être utilisée en tant que forme
 * initiale de l'image durant la modification des perspectives.
 */
public class Vignette extends JPanel implements ObservateurModele {
    /**** Initialisation des variables ****/
    private ModeleApplication modele;                   // Modèle de l'application
    private Figure vignette;                             // Première instance de l'image contenue dans le modèle

    /**
     * Constructeur d'initialisation. Le panneau récupère les données du modèle de l'application, et ensuite crée son
     * contour.
     *
     * @param modele Modèle de l'application
     */
    public Vignette(ModeleApplication modele) {
        this.modele = modele;
        setBorder(BorderFactory.createLineBorder(Color.black, 4));
    }

    /**
     * Met à jour le panneau au cas où le modèle contient des instances d'une image.
     */
    public void mettreAJour() {
        if (!modele.recupererImages().isEmpty()) {
            vignette = modele.recupererImages().get(0);

            if (vignette.recupererPosition() == null) {
                int[] centreDuPanneau = { (getWidth() / 2) - (vignette.recupererTaille()[0] / 2),
                        (getHeight() / 2) - (vignette.recupererTaille()[1] / 2) } ;
                modele.mettreAJourPositionImage(0, centreDuPanneau);
            }

            repaint();
        }
    }

    /**
     * Peint le panneau avec l'instance de l'image récupérée.
     */
    protected void paintComponent(Graphics g) {
        if (vignette != null) {
            super.paintComponent(g);
            g.drawImage(vignette.recupererApparence(), vignette.recupererPosition()[0],
                    vignette.recupererPosition()[1], vignette.recupererTaille()[0],
                    vignette.recupererTaille()[1], this);
        }
    }
}
