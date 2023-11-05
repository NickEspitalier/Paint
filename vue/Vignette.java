package vue;

import modeles.ModeleApplication;

import javax.swing.*;
import java.awt.*;

public class Vignette extends JPanel {

    ImageIcon vignette;

    Vignette(ModeleApplication modele) {
        if (!modele.recupererImages().isEmpty()) {
            vignette = modele.recupererImages().get(0);
            JLabel etiquetteVignette = new JLabel(vignette);
            add(etiquetteVignette);
        }
    }
}
