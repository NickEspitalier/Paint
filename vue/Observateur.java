package vue;

import modeles.Sujet;

public interface Observateur {
    void mettreAJour(Sujet s);
}