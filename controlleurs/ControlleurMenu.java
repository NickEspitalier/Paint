package controlleurs;

import commandes.Commande;
import modeles.ModeleApplication;

public class ControlleurMenu {
    private final Commande chargerImage, chargerPerspectives, defaire, optionsPressePapier, quitter, sauvegarder;
    private final ModeleApplication modele;

    public ControlleurMenu(Commande chargerImage, Commande chargerPerspectives, Commande defaire,
                           Commande optionsPressePapier, Commande quitter, Commande sauvegarder, ModeleApplication ma) {
        this.chargerImage = chargerImage;
        this.chargerPerspectives = chargerPerspectives;
        this.optionsPressePapier = optionsPressePapier;
        this.quitter = quitter;
        this.sauvegarder = sauvegarder;
        this.defaire = defaire;
    }

    public void chargerUneImage() { chargerImage.executer(); }
    public void chargerDesPerspectives() { chargerPerspectives.executer(); }
    public void choisirOptionsPressePapier() { optionsPressePapier.executer(); }
    public void quitterApplication() { quitter.executer(); }
    public void sauvegarderPerspectives() { sauvegarder.executer(); }
    public void defaireCommande() { defaire.executer(); }
}
