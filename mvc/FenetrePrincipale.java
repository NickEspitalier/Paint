package mvc;

import javax.swing.*;
import java.awt.*;

public class FenetrePrincipale extends JFrame implements Observateur {

    private static final String TITRE_FENETRE = "Image avec Perspectives";
    private static final Dimension TAILLE_FENETRE = new Dimension(1000, 700);

    public FenetrePrincipale() {
        Vignette vignette = new Vignette();
        Perspective1 p1 = new Perspective1();
        Perspective2 p2 = new Perspective2();
        MenuFenetre menu = new MenuFenetre();
        add(menu, BorderLayout.NORTH);
        add(vignette, BorderLayout.WEST);
        add(p1, BorderLayout.CENTER);
        add(p2, BorderLayout.EAST);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle(TITRE_FENETRE);
        setSize(TAILLE_FENETRE);
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    public void mettreAJour(Sujet s) {}
}