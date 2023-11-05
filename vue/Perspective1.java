package vue;

import modeles.ModeleApplication;

import javax.swing.*;
import java.awt.*;

public class Perspective1 extends JPanel {

    ImageIcon perspective1;

    Perspective1(ModeleApplication modele) {
        if (!modele.recupererImages().isEmpty()) {
            perspective1 = modele.recupererImages().get(1);
            JLabel etiquetteVignette = new JLabel(perspective1);
            add(etiquetteVignette);
        }

        add(new JSeparator(JSeparator.VERTICAL), BorderLayout.LINE_START);
    }
}
