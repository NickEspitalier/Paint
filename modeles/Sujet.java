package modeles;

import vue.Observateur;

import java.util.ArrayList;

public abstract class Sujet {
    private final ArrayList<Observateur> observateurs = new ArrayList<>();

    public void attacherObservateur(Observateur o) { observateurs.add(o); }

    public void notifierObservateurs() {
        for (Observateur o : observateurs) { o.mettreAJour(); }
    }
}