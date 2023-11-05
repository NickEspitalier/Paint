package modeles;

import vue.Observateur;

import java.util.ArrayList;

public abstract class Sujet {
    private final ArrayList<Observateur> observateurs = new ArrayList<>();

    public void attacher(Observateur o) { observateurs.add(o); }

    public void notifier() {
        for (Observateur o : observateurs) { o.mettreAJour(); }
    }
}