package modeles;

import vue.ObservateurModele;

import java.util.ArrayList;

public abstract class Modele {
    private final ArrayList<ObservateurModele> observateurs = new ArrayList<>();

    public void attacherObservateur(ObservateurModele o) { observateurs.add(o); }

    public void notifierObservateurs() {
        for (ObservateurModele o : observateurs) { o.mettreAJour(); }
    }
}