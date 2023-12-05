package vue;

import controlleurs.Souris;
import modele.Figure;
import modele.ModeleApplication;

import javax.swing.*;
import java.awt.*;

/**
 * Panneau Swing qui représente le deuxième élément principal du programme, soit la première perspective. Une
 * perspective a pour objectif d'afficher une image qui a été chargée par l'utilisateur, et ensuite d'être modifiée
 * selon les demandes de l'utilisateur.
 */
public class Perspective1 extends JPanel implements ObservateurModele {
    /**** Initialisation des variables ****/
    private ModeleApplication modele;                   // Modèle de l'application
    private Figure perspective1;                         // Deuxième instance de l'image contenue dans le modèle
    private String nomPerspective = "Perspective1";

    /**
     * Constructeur d'initialisation. Le panneau récupère les données du modèle de l'application, et ensuite crée son
     * contour.
     *
     * @param modele Modèle de l'application
     */
    public Perspective1(ModeleApplication modele) {
        this.modele = modele;
        setBorder(BorderFactory.createLineBorder(Color.blue, 4));

        Souris souris = new Souris(modele);
        addMouseListener(souris);
        addMouseMotionListener(souris);
        addMouseWheelListener(souris);
    }

    /**
     * Met à jour le panneau au cas où le modèle contient des instances d'une image.
     */
    public void mettreAJour() {
        if (!modele.recupererImages().isEmpty()) {
            perspective1 = modele.recupererImages().get(1);

            if (perspective1.recupererPosition() == null) {
                int[] centreDuPanneau = { (getWidth() / 2) - (perspective1.recupererTaille()[0] / 2),
                        (getHeight() / 2) - (perspective1.recupererTaille()[1] / 2) } ;
                modele.mettreAJourPositionImage(1, centreDuPanneau);
            }

            repaint();
        }
    }

    /**
     * Peint le panneau avec l'instance de l'image récupérée.
     *
     * @param g Notre paramètre graphique
     */
    protected void paintComponent(Graphics g) {
        if (perspective1 != null) {
            super.paintComponent(g);
            g.drawImage(perspective1.recupererApparence(), perspective1.recupererPosition()[0],
                    perspective1.recupererPosition()[1], perspective1.recupererTaille()[0],
                    perspective1.recupererTaille()[1], this);
        }
    }

    /**
     * Récupère des informations sur le panneau.
     */
    @Override
    public String toString() {
        return "Perspective1{" +
                "modele=" + modele +
                ", perspective1=" + perspective1 +
                ", nomPerspective='" + nomPerspective + '\'' +
                '}';
    }
}