package vue;

import modeles.ModeleApplication;

import javax.swing.*;
import java.awt.*;

/**
 * Panneau Swing qui représente le troisième élément principal du programme, soit la deuxième perspective. Une
 * perspective a pour objectif d'afficher une image qui a été chargée par l'utilisateur, et ensuite d'être modifiée
 * selon les demandes de l'utilisateur.
 */
public class Perspective2 extends JPanel implements ObservateurModele {
    /**** Initialisation des variables ****/
    ModeleApplication modele;                   // Modèle de l'application
    Image perspective2;                         // Troisième instance de l'image contenue dans le modèle

    /**
     * Constructeur d'initialisation. Le panneau récupère les données du modèle de l'application, et ensuite crée son
     * contour.
     *
     * @param ma Modèle de l'application
     */
    Perspective2(ModeleApplication ma) {
        this.modele = ma;
        setBorder(BorderFactory.createLineBorder(Color.blue, 4));
    }

    /**
     * Met à jour le panneau au cas où le modèle contient des instances d'une image.
     */
    public void mettreAJour() {
        if (!modele.recupererImages().isEmpty()) {
            perspective2 = modele.recupererImages().get(2);
            repaint();
        }
    }

    /**
     * Peint le panneau avec l'instance de l'image récupérée.
     */
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(perspective2, 0, 0, getWidth(), getHeight(), this);
    }
}
