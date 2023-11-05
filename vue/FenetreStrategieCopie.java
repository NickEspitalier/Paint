package vue;

import modeles.ModeleApplication;

import javax.swing.*;
import java.awt.*;

public class FenetreStrategieCopie extends JFrame {

    private static final String TITRE_FENETRE = "Choisissez...";
    private static final Dimension TAILLE_FENETRE = new Dimension(300, 100);

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
