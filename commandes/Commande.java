package commandes;

import modeles.ModeleApplication;

/**
 * Classe abstraite qui représente une commande appelée par l'utilisateur. Chaque commande suit le patron du même
 * nom et exécute leur propre code qui est appelé par leur controlleur respectif.
 */
public abstract class Commande {
    public abstract void executer(ModeleApplication ma);
}
