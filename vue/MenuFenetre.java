package vue;

import commandes.*;
import controlleurs.ControlleurMenu;
import modeles.ModeleApplication;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Menu Swing qui affiche toutes les commandes que l'utilisateur peut effectuer du côté administratif de l'application,
 * c'est-à-dire les opérations qui n'impliquent pas la modification directe des perspectives.
 */
public class MenuFenetre extends JMenuBar {
    /**** Initialisation des variables ****/
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
    private final ControlleurMenu controlleurMenu;          // Controlleur du menu

    /**
     * Constructeur d'initialisation. Le menu ajoute des sous-menus à lui-même avant d'être affiché par la fenêtre
     * qui le contient.
     *
     * @param ma Le modèle de l'application
     */
    public MenuFenetre(ModeleApplication ma) {
         controlleurMenu = new ControlleurMenu(new CommandeChargerImage(), new CommandeChargerPerspectives(),
                 new CommandeDefaire(), new CommandeRefaire(), new CommandeOptionsPressePapier(),
                 new CommandeQuitter(), new CommandeSauvegarder(), ma);
        ajouterMenuFichier();
        ajouterMenuEdition();
        ajouterMenuPressePapier();
    }

    /**
     * Ajoute le sous-menu "Fichier" au menu.
     */
    private void ajouterMenuFichier() {
        // On initialise les éléments du sous-menu...
        JMenu menuFichier = new JMenu(TITRE_MENU_FICHIER);
        JMenuItem menuSauvegarderPerspective = new JMenuItem(TITRE_MENU_FICHIER_SAUV);
        JMenuItem menuChargerPerspective = new JMenuItem(TITRE_MENU_FICHIER_CHARGE_PERSP);
        JMenuItem menuChargerImage = new JMenuItem(TITRE_MENU_FICHIER_CHARGER_IMAGE);
        JMenuItem menuQuitter = new JMenuItem(TITRE_MENU_FICHIER_QUITTER);

        // ... puis, on ajoute les commandes de chaque élément.
        menuSauvegarderPerspective.addActionListener((ActionEvent e) -> controlleurMenu.sauvegarderPerspectives());
        menuChargerPerspective.addActionListener((ActionEvent e) -> controlleurMenu.chargerDesPerspectives());
        menuChargerImage.addActionListener((ActionEvent e) -> controlleurMenu.chargerUneImage());
        menuQuitter.addActionListener((ActionEvent e) -> controlleurMenu.quitterApplication());

        // Enfin, on affiche les éléments dans le sous-menu et le sous-menu dans le menu.
        menuFichier.add(menuSauvegarderPerspective);
        menuFichier.add(menuChargerPerspective);
        menuFichier.addSeparator();
        menuFichier.add(menuChargerImage);
        menuFichier.addSeparator();
        menuFichier.add(menuQuitter);

        add(menuFichier);
    }

    /**
     * Ajoute le sous-menu "Édition" au menu.
     */
    private void ajouterMenuEdition() {
        // On initialise les éléments du sous-menu...
        JMenu menuEdition = new JMenu(TITRE_MENU_EDITION);
        JMenuItem menuDefaire = new JMenuItem(TITRE_MENU_EDITION_DEFAIRE);
        JMenuItem menuRefaire = new JMenuItem(TITRE_MENU_EDITION_REFAIRE);

        menuDefaire.addActionListener((ActionEvent e) -> controlleurMenu.defaireCommande());
        menuRefaire.addActionListener((ActionEvent e) -> controlleurMenu.refaireCommande());

        menuEdition.add(menuDefaire);
        menuEdition.addSeparator();
        menuEdition.add(menuRefaire);

        add(menuEdition);
    }

    /**
     * Ajoute le sous-menu "Presse-Papier" au menu.
     */
    private void ajouterMenuPressePapier() {
        JMenu menuPressePapier = new JMenu(TITRE_MENU_PRESSEPAPIER);
        JMenuItem menuStrategieCopie = new JMenuItem(TITRE_MENU_PRESSEPAPIER_STRAT);

        menuStrategieCopie.addActionListener((ActionEvent e) -> controlleurMenu.choisirOptionsPressePapier());

        menuPressePapier.add(menuStrategieCopie);

        add(menuPressePapier);
    }
}
