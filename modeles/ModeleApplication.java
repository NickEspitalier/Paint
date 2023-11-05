package modeles;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ModeleApplication extends Sujet {
    ArrayList<ImageIcon> images = new ArrayList<>();
    String choixPressePapier;

    public void stockerNouvelleImage(ImageIcon im) {
        if (images.isEmpty()) {
            for (int i = 0; i < 3; i++) { images.add(im); }
        } else {
            for (int i = 0; i < 3; i++) { images.set(i, im); }
        }
    }

    public void choisirOptionsPressePapier(String choix) { choixPressePapier = choix; }
    public ArrayList<ImageIcon> recupererImages() { return images; }
    public String recupererChoixPressePaper() { return choixPressePapier; }
}
