package vue;

import modeles.ModeleApplication;
import javax.swing.*;
import java.awt.*;

public class PanneauImages extends JPanel {

    PanneauImages(ModeleApplication modele) {
        Vignette vignette = new Vignette(modele);
        Perspective1 p1 = new Perspective1(modele);
        Perspective2 p2 = new Perspective2(modele);
        modele.attacherObservateur(vignette);
        modele.attacherObservateur(p1);
        modele.attacherObservateur(p2);
        setLayout(new GridLayout(0,3));
        setBorder(BorderFactory.createLineBorder(Color.black, 4));
        add(vignette);
        add(p1);
        add(p2);
    }
}
