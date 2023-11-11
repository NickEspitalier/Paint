package vue;

import modeles.ModeleApplication;

import javax.swing.*;
import java.awt.*;

/**
 * Panneau Swing qui représente le deuxième élément principal du programme, soit la première perspective. Une
 * perspective a pour objectif d'afficher une image qui a été chargée par l'utilisateur, et ensuite d'être modifiée
 * selon les demandes de l'utilisateur.
 */
public class Perspective1 extends JPanel implements ObservateurModele {
    /**** Initialisation des variables ****/
    ModeleApplication modele;                   // Modèle de l'application
    Image perspective1;                         // Deuxième instance de l'image contenue dans le modèle

    /**
     * Constructeur d'initialisation. Le panneau récupère les données du modèle de l'application, et ensuite crée son
     * contour.
     *
     * @param ma Modèle de l'application
     */
    public Perspective1(ModeleApplication ma) {
        this.modele = ma;
        setBorder(BorderFactory.createLineBorder(Color.blue, 4));
    }

    /**
     * Met à jour le panneau au cas où le modèle contient des instances d'une image.
     */
    public void mettreAJour() {
        if (!modele.recupererImages().isEmpty()) {
            perspective1 = modele.recupererImages().get(1);
            repaint();
        }
    }

    /**
     * Peint le panneau avec l'instance de l'image récupérée.
     *
     * @param g Notre paramètre graphique
     */
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(perspective1, 0, 0, getWidth(), getHeight(), this);
    }
}
