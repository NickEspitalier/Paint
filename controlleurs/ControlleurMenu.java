package controlleurs;

import commandes.Commande;
import modeles.ModeleApplication;

public class ControlleurMenu {
    private final Commande chargerImage, chargerPerspectives, defaire, optionsPressePapier, quitter, sauvegarder;
    private final ModeleApplication modele;

    public ControlleurMenu(Commande chargerImage, Commande chargerPerspectives, Commande defaire,
                           Commande optionsPressePapier, Commande quitter, Commande sauvegarder,
                           ModeleApplication ma) {
        this.chargerImage = chargerImage;
        this.chargerPerspectives = chargerPerspectives;
        this.defaire = defaire;
        this.optionsPressePapier = optionsPressePapier;
        this.quitter = quitter;
        this.sauvegarder = sauvegarder;
        this.modele = ma;
    }

    public void chargerUneImage() { chargerImage.executer(modele); }
    public void chargerDesPerspectives() { chargerPerspectives.executer(modele); }
    public void choisirOptionsPressePapier() { optionsPressePapier.executer(modele); }
    public void quitterApplication() { quitter.executer(modele); }
    public void sauvegarderPerspectives() { sauvegarder.executer(modele); }
    public void defaireCommande() { defaire.executer(modele); }
}
