package vue;

import modele.ModeleApplication;
import javax.swing.*;
import java.awt.*;

/**
 * Panneau Swing qui agit en tant que conteneur des instances de l'image chargée ainsi que des opérations pouvant
 * être accomplies avec la souris de l'utilisateur.
 */
public class PanneauImages extends JPanel {
    /**** Initialisation des variables ****/
    private Vignette vignette;
    private Perspective1 p1;
    private Perspective2 p2;

    /**
     * Constructeur d'initialisation. Le panneau crée la vignette et les perspectives, puis les attache au modèle
     * de l'application avant de les attacher à lui-même selon un GridLayout.
     *
     * @param modele  Le modèle de l'application
     */
    public PanneauImages(ModeleApplication modele) {
        vignette = new Vignette(modele);
        p1 = new Perspective1(modele);
        p2 = new Perspective2(modele);
        modele.attacherObservateur(vignette);
        modele.attacherObservateur(p1);
        modele.attacherObservateur(p2);
        setLayout(new GridLayout(0,3));
        setBorder(BorderFactory.createLineBorder(Color.black, 4));
        add(vignette);
        add(p1);
        add(p2);
    }
}
