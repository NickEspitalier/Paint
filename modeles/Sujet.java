package modeles;

import vue.ObservateurModele;

import java.util.ArrayList;

/**
 * Classe abstraite représentant un sujet. Dans l'architecture MVC, le but du sujet est de contenir une liste
 * d'observateurs qui surveille la vue (dans notre application, la vignette et les perspectives) afin de permettre à
 * cette dernière de se mettre à jour avec les données du modèle.
 */
public abstract class Sujet {
    /**** Initialisation des variables ****/
    private final ArrayList<ObservateurModele> observateurs = new ArrayList<>();        // Liste d'observateurs

    /**
     * Ajoute un observateur à la liste.
     *
     * @param o Un observateur
     */
    public void attacherObservateur(ObservateurModele o) { observateurs.add(o); }

    /**
     * Demande à chaque observateur de la liste de se mettre à jour.
     */
    public void notifierObservateurs() {
        for (ObservateurModele o : observateurs) { o.mettreAJour(); }
    }
}