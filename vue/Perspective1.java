package vue;

import modeles.ModeleApplication;

import javax.swing.*;
import java.awt.*;

public class Perspective1 extends JPanel implements ObservateurModele {

    ModeleApplication modele;
    Image perspective1;

    Perspective1(ModeleApplication m) {
        this.modele = m;
        setBorder(BorderFactory.createLineBorder(Color.blue, 4));
    }

    @Override
    public void mettreAJour() {
        if (!modele.recupererImages().isEmpty()) {
            perspective1 = modele.recupererImages().get(1);
            repaint();
        }
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(perspective1, 0, 0, getWidth(), getHeight(), this);
    }
}
