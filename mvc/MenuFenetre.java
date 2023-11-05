package mvc;

import commandes.*;
import controlleurs.ControlleurMenu;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class MenuFenetre extends JMenuBar {

    private static final String TITRE_MENU_FICHIER = "Fichier";
    private static final String TITRE_MENU_FICHIER_SAUV = "Sauvegarder les perspectives en tant que...";
    private static final String TITRE_MENU_FICHIER_CHARGE_PERSP = "Charger des perspectives";
    private static final String TITRE_MENU_FICHIER_CHARGER_IMAGE = "Charger image";
    private static final String TITRE_MENU_FICHIER_QUITTER = "Quitter";
    private static final String TITRE_MENU_EDITION = "Edition";
    private static final String TITRE_MENU_EDITION_DEFAIRE = "Défaire...";
    private static final String TITRE_MENU_EDITION_REFAIRE = "Refaire...";
    private static final String TITRE_MENU_PRESSEPAPIER = "Presse-Papier";
    private static final String TITRE_MENU_PRESSEPAPIER_STRAT = "Choisir la stratégie du presse-papier";

    ControlleurMenu controlleurMenu = new ControlleurMenu(new CommandeChargerImage(), new CommandeChargerPerspective(),
            new CommandeDefaire(), new CommandePressePapier(), new CommandeQuitter(), new CommandeSauvegarder());


    public MenuFenetre() {
        ajouterMenuFichier();
        ajouterMenuEdition();
        ajouterMenuPressePapier();
    }

    private void ajouterMenuFichier() {
        JMenu menuFichier = new JMenu(TITRE_MENU_FICHIER);
        JMenuItem menuFichierSauvegarde = new JMenuItem(TITRE_MENU_FICHIER_SAUV);
        JMenuItem menuChargerPerspective = new JMenuItem(TITRE_MENU_FICHIER_CHARGE_PERSP);
        JMenuItem menuChargerImage = new JMenuItem(TITRE_MENU_FICHIER_CHARGER_IMAGE);
        JMenuItem menuQuitter = new JMenuItem(TITRE_MENU_FICHIER_QUITTER);

        menuQuitter.addActionListener((ActionEvent e) -> { controlleurMenu.quitterApplication(); });

        menuFichier.add(menuFichierSauvegarde);
        menuFichier.add(menuChargerPerspective);
        menuFichier.addSeparator();
        menuFichier.add(menuChargerImage);
        menuFichier.addSeparator();
        menuFichier.add(menuQuitter);

        add(menuFichier);
    }

    private void ajouterMenuEdition() {
        JMenu menuEdition = new JMenu(TITRE_MENU_EDITION);
        JMenuItem menuDefaire = new JMenuItem(TITRE_MENU_EDITION_DEFAIRE);
        JMenuItem menuRefaire = new JMenuItem(TITRE_MENU_EDITION_REFAIRE);

        menuEdition.add(menuDefaire);
        menuEdition.addSeparator();
        menuEdition.add(menuRefaire);

        add(menuEdition);
    }

    private void ajouterMenuPressePapier() {
        JMenu menuPressePapier = new JMenu(TITRE_MENU_PRESSEPAPIER);
        JMenuItem menuStrategieCopie = new JMenuItem(TITRE_MENU_PRESSEPAPIER_STRAT);

        menuStrategieCopie.addActionListener((ActionEvent e) -> {
            new FenetreStrategieCopie();
        });


        menuPressePapier.add(menuStrategieCopie);

        add(menuPressePapier);
    }
}
