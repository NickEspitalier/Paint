package vue;

import modeles.ModeleApplication;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Perspective1 extends JPanel implements Observateur {

    ModeleApplication modele;
    Image perspective1;

    Perspective1(ModeleApplication m) {
        this.modele = m;
        Border countourP1 = BorderFactory.createLineBorder(Color.blue, 4);
        setBorder(countourP1);
    }

    @Override
    public void mettreAJour() {
        if (!modele.recupererImages().isEmpty()) {
            perspective1 = modele.recupererImages().get(0);
            repaint();
        }
    }

    protected void paintComponent(Graphics g) {
        if (!modele.recupererImages().isEmpty()) {
            super.paintComponent(g);
            g.drawImage(perspective1, 0, 0, getWidth(), getHeight(), this);
        }
    }
}
