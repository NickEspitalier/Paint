package vue;

import modeles.ModeleApplication;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class PanneauImages extends JPanel {

    PanneauImages(ModeleApplication modele) {
        setLayout(new GridLayout(0,3));

        Vignette vignette = new Vignette(modele);
        Perspective1 p1 = new Perspective1(modele);
        Perspective2 p2 = new Perspective2(modele);
        modele.attacherObservateur(vignette);
        modele.attacherObservateur(p1);
        modele.attacherObservateur(p2);

        Border countourPanneau = BorderFactory.createLineBorder(Color.black, 4);
        setBorder(countourPanneau);
        add(vignette);
        add(p1);
        add(p2);
    }
}
