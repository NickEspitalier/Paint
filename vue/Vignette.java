package vue;

import modeles.ModeleApplication;

import javax.swing.*;
import java.awt.*;

/**
 * Panneau Swing qui représente le premier élément principal du programme, soit la vignette. La vignette a pour
 * objectif d'afficher une image qui a été chargée par l'utilisateur, et ensuite d'être utilisée en tant que forme
 * initiale de l'image durant la modification des perspectives.
 */
public class Vignette extends JPanel implements ObservateurModele {
    /**** Initialisation des variables ****/
    ModeleApplication modele;                   // Modèle de l'application
    Image vignette;                             // Première instance de l'image contenue dans le modèle

    /**
     * Constructeur d'initialisation. Le panneau récupère les données du modèle de l'application, et ensuite crée son
     * contour.
     *
     * @param ma Modèle de l'application
     */
    public Vignette(ModeleApplication ma) {
        this.modele = ma;
        setBorder(BorderFactory.createLineBorder(Color.black, 4));
    }

    /**
     * Met à jour le panneau au cas où le modèle contient des instances d'une image.
     */
    public void mettreAJour() {
        if (!modele.recupererImages().isEmpty()) {
            vignette = modele.recupererImages().get(0);
            repaint();
        }
    }

    /**
     * Peint le panneau avec l'instance de l'image récupérée.
     */
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(vignette, 0, 0, getWidth(), getHeight(), this);
    }
}
