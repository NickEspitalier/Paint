package vue;

import modeles.ModeleApplication;
import javax.swing.*;
import java.awt.*;

/**
 * Fenêtre Swing qui agit en tant que la vue de l'application. Dans l'architecture MVC, la vue a pour but d'afficher
 * les données stockées dans le modèle de l'application.
 */
public class FenetrePrincipale extends JFrame {
    /**** Initialisation des variables ****/
    private boolean actif = true;		                                // État de l'environnement
    private static final String TITRE_FENETRE = "Image avec Perspectives";
    private static final Dimension TAILLE_FENETRE = new Dimension(1000, 700);

    /**
     * Constructeur d'initialisation. La fenêtre crée le menu, le panneau d'images et le panneau des droits
     * d'auteurs, puis les affiche selon un BorderLayout.
     */
    public FenetrePrincipale(ModeleApplication ma) {
        MenuFenetre menu = new MenuFenetre(ma);
        PanneauImages panneauImages = new PanneauImages(ma);
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

        // Tant que la fenêtre demeure active, les instances de l'image chargée sont mises à jour.
        while (actif) { ma.notifierObservateurs(); }
    }
}