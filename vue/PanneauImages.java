package vue;

import modeles.ModeleApplication;
import javax.swing.*;
import java.awt.*;

/**
 * Panneau Swing qui agit en tant que conteneur des instances de l'image chargée.
 */
public class PanneauImages extends JPanel {

    /**
     * Constructeur d'initialisation. Le panneau crée la vignette et les perspectives, puis les attache au modèle
     * de l'application avant de les attacher à lui-même selon un GridLayout.
     *
     * @param ma Le modèle de l'application
     */
    PanneauImages(ModeleApplication ma) {
        Vignette vignette = new Vignette(ma);
        Perspective1 p1 = new Perspective1(ma);
        Perspective2 p2 = new Perspective2(ma);
        ma.attacherObservateur(vignette);
        ma.attacherObservateur(p1);
        ma.attacherObservateur(p2);
        setLayout(new GridLayout(0,3));
        setBorder(BorderFactory.createLineBorder(Color.black, 4));
        add(vignette);
        add(p1);
        add(p2);
    }
}
