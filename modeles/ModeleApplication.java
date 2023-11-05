package modeles;

import java.awt.*;
import java.util.ArrayList;

public class ModeleApplication {
    ArrayList<Image> images = new ArrayList<>(3);

    public void stockerNouvelleImage(Image im) {
        for (int i = 0; i < images.size(); i++) { images.add(im); }
    }

    public ArrayList<Image> recupererImage() { return images; }
}
