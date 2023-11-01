package mvc;

import javax.swing.*;
import java.awt.*;

public class FenetreStrategieCopie extends JFrame {

    private static final String TITRE_FENETRE = "Choisissez la stratégie du presse-papier";
    private static final Dimension TAILLE_FENETRE = new Dimension(1000, 700);

    public FenetreStrategieCopie() {
        PanneauStrategieCopie panneauStrategieCopie = new PanneauStrategieCopie();
        add(panneauStrategieCopie);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle(TITRE_FENETRE);
        setSize(TAILLE_FENETRE);
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
    }
}
