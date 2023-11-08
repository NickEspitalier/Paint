package vue;

import modeles.ModeleApplication;
import javax.swing.*;
import java.awt.*;

public class PanneauImages extends JPanel {

    PanneauImages(ModeleApplication modele) {
        Vignette vignette = new Vignette(modele);
        Perspective1 p1 = new Perspective1(modele);
        Perspective2 p2 = new Perspective2(modele);
        add(vignette);
        add(new JSeparator(JSeparator.VERTICAL), BorderLayout.LINE_START);
        add(p1);
        add(new JSeparator(JSeparator.VERTICAL), BorderLayout.LINE_START);
        add(p2);
    }
}
