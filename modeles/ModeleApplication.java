package modeles;

import java.awt.*;
import java.util.ArrayList;

public class ModeleApplication extends Modele {
    ArrayList<Image> images = new ArrayList<>();
    String choixPressePapier;

    public void stockerNouvelleImage(Image im) {
        if (images.isEmpty()) {
            for (int i = 0; i < 3; i++) { images.add(im); }
        } else {
            for (int j = 0; j < 3; j++) { images.set(j, im); }
        }
    }

    public void choisirOptionsPressePapier(String choix) { choixPressePapier = choix; }
    public ArrayList<Image> recupererImages() { return images; }
    public String recupererChoixPressePaper() { return choixPressePapier; }
}
