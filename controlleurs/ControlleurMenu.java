package controlleurs;

import commandes.Commande;
import modeles.ModeleApplication;

/**
 * Classe représentant le controlleur du menu de l'application. Dans l'architecture MVC, le controlleur a pour but
 * d'exécuter les commandes demandées par l'utilisateur. Ce controlleur est responsable de l'exécution des
 * opérations des commandes de l'utilisateur qui sont connectées au menu, tel que le chargement d'une image ou
 * la fin du programme.
 */
public class ControlleurMenu {
    /**** Initialisation des variables ****/
    private final Commande chargerImage, chargerPerspectives, defaire, refaire, optionsPressePapier, quitter,
            sauvegarder;                             // Commandes connectées au menu
    private final ModeleApplication modele;         // Modèle de l'application

    /**
     * Constructeur d'initialisation avec variables.
     */
    public ControlleurMenu(Commande chargerImage, Commande chargerPerspectives, Commande defaire, Commande refaire,
                           Commande optionsPressePapier, Commande quitter, Commande sauvegarder,
                           ModeleApplication ma) {
        this.chargerImage = chargerImage;
        this.chargerPerspectives = chargerPerspectives;
        this.defaire = defaire;
        this.refaire = refaire;
        this.optionsPressePapier = optionsPressePapier;
        this.quitter = quitter;
        this.sauvegarder = sauvegarder;
        this.modele = ma;
    }

    /**** Méthodes d'exécution des commandes du menu ****/
    public void chargerUneImage() { chargerImage.executer(modele); }
    public void chargerDesPerspectives() { chargerPerspectives.executer(modele); }
    public void defaireCommande() { defaire.executer(modele); }
    public void refaireCommande() { refaire.executer(modele); }
    public void choisirOptionsPressePapier() { optionsPressePapier.executer(modele); }
    public void quitterApplication() { quitter.executer(modele); }
    public void sauvegarderPerspectives() { sauvegarder.executer(modele); }
}
