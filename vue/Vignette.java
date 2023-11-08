package vue;

import modeles.ModeleApplication;

import javax.swing.*;
import java.awt.*;

public class Vignette extends JPanel implements ObservateurModele {

    ModeleApplication modele;
    Image vignette;

    Vignette(ModeleApplication m) {
        this.modele = m;
        setBorder(BorderFactory.createLineBorder(Color.black, 4));
    }

    @Override
    public void mettreAJour() {
        if (!modele.recupererImages().isEmpty()) {
            vignette = modele.recupererImages().get(0);
            repaint();
        }
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(vignette, 0, 0, getWidth(), getHeight(), this);
    }
}
