package modeles;

import vue.ObservateurImages;

import java.util.ArrayList;

public abstract class Modele {
    private final ArrayList<ObservateurImages> observateurs = new ArrayList<>();

    public void attacherObservateur(ObservateurImages o) { observateurs.add(o); }

    public void notifierObservateurs() {
        for (ObservateurImages o : observateurs) { o.mettreAJour(); }
    }
}