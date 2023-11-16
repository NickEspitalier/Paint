package vue;

import modele.ModeleApplication;

import javax.swing.*;
import java.awt.*;

/**
 * Fenêtre Swing qui affiche le panneau de stratégie du presse-papier.
 */
public class FenetreStrategieCopie extends JFrame {
    /**** Initialisation des variables ****/
    private static final String TITRE_FENETRE = "Choisissez...";
    private static final Dimension TAILLE_FENETRE = new Dimension(300, 100);

    /**
     * Constructeur d'initialisation. La fenêtre crée le panneau de stratégie, puis l'affiche.
     *
     * @param modele Le modèle de l'application
     */
    public FenetreStrategieCopie(ModeleApplication modele) {
        PanneauStrategieCopie panneauStrategieCopie = new PanneauStrategieCopie(modele);
        add(panneauStrategieCopie);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle(TITRE_FENETRE);
        setSize(TAILLE_FENETRE);
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
    }
}
