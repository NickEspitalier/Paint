package vue;

import modeles.ModeleApplication;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Vignette extends JPanel implements Observateur {

    ModeleApplication modele;
    Image vignette;

    Vignette(ModeleApplication m) {
        this.modele = m;
        Border countourVignette = BorderFactory.createLineBorder(Color.black, 4);
        setBorder(countourVignette);
    }

    @Override
    public void mettreAJour() {
        if (!modele.recupererImages().isEmpty()) {
            vignette = modele.recupererImages().get(0);
            repaint();
        }
    }

    protected void paintComponent(Graphics g) {
        if (!modele.recupererImages().isEmpty()) {
            super.paintComponent(g);
            g.drawImage(vignette, 0, 0, getWidth(), getHeight(), this);
        }
    }
}
