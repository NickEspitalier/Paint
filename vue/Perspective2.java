package vue;

import modeles.ModeleApplication;

import javax.swing.*;
import java.awt.*;

public class Perspective2 extends JPanel {

    ImageIcon perspective2;

    Perspective2(ModeleApplication modele) {
        if (!modele.recupererImages().isEmpty()) {
            perspective2 = modele.recupererImages().get(2);
            JLabel etiquetteVignette = new JLabel(perspective2);
            add(etiquetteVignette);
        }
    }
}
