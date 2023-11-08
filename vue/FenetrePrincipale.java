package vue;

import modeles.ModeleApplication;
import javax.swing.*;
import java.awt.*;

public class FenetrePrincipale extends JFrame {

    private boolean actif = true;			// État de l'environnement (actif ou non)
    private static final String TITRE_FENETRE = "Image avec Perspectives";
    private static final Dimension TAILLE_FENETRE = new Dimension(1000, 700);

    public ModeleApplication modele = new ModeleApplication();

    public FenetrePrincipale() {
        MenuFenetre menu = new MenuFenetre(modele);
        PanneauImages panneauImages = new PanneauImages(modele);
        PanneauCopyright panneauCopyright = new PanneauCopyright();
        add(menu, BorderLayout.PAGE_START);
        add(panneauImages);
        add(panneauCopyright, BorderLayout.PAGE_END);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle(TITRE_FENETRE);
        setSize(TAILLE_FENETRE);
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);

        while (actif) { modele.notifierObservateurs(); }
    }
}