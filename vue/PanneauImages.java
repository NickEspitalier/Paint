package vue;

import commandes.CommandePressePapier;
import commandes.CommandeTranslation;
import commandes.CommandeAgrandir;
import commandes.CommandeReduire;
import controlleurs.ControlleurPerspectives;
import modele.ModeleApplication;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Panneau Swing qui agit en tant que conteneur des instances de l'image chargée ainsi que des opérations pouvant
 * être accomplies avec la souris de l'utilisateur.
 */
public class PanneauImages extends JPanel {
    /**** Initialisation des variables ****/
    private ControlleurPerspectives controlleurPerspectives;          // Controlleur des perspectives
    private Vignette vignette;
    private Perspective1 p1;
    private Perspective2 p2;

    /**
     * Constructeur d'initialisation. Le panneau crée la vignette et les perspectives, puis les attache au modèle
     * de l'application avant de les attacher à lui-même selon un GridLayout.
     *
     * @param ma  Le modèle de l'application
     */
    public PanneauImages(ModeleApplication ma) {
        controlleurPerspectives = new ControlleurPerspectives(new CommandePressePapier(), new CommandeTranslation(),
                new CommandeAgrandir(), new CommandeReduire(), ma);
        vignette = new Vignette(ma);
        p1 = new Perspective1(ma);
        p2 = new Perspective2(ma);
        ajouterFonctionsPerspectives();
        ma.attacherObservateur(vignette);
        ma.attacherObservateur(p1);
        ma.attacherObservateur(p2);
        setLayout(new GridLayout(0,3));
        setBorder(BorderFactory.createLineBorder(Color.black, 4));
        add(vignette);
        add(p1);
        add(p2);
    }

    /**
     * Ajoute aux perspectives les interactions pouvant être accomplies par l'utilisateur avec la souris.
     */
    private void ajouterFonctionsPerspectives() {
        ArrayList<JPanel> perspectives = new ArrayList<>(Arrays.asList(p1, p2));

        for (JPanel p : perspectives) {
            p.addMouseListener(new MouseAdapter() {
                public void mousePressed(MouseEvent e) {
                    controlleurPerspectives.deplacerPerspective();
                }
            });

            p.addMouseWheelListener((MouseWheelEvent e) ->
                    controlleurPerspectives.changerTaillePerspective(e.getWheelRotation()));
        }
    }
}
