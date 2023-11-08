package vue;

import modeles.ModeleApplication;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Perspective2 extends JPanel implements ObservateurModele {

    ModeleApplication modele;
    Image perspective2;

    Perspective2(ModeleApplication m) {
        this.modele = m;
        Border countourP2 = BorderFactory.createLineBorder(Color.blue, 4);
        setBorder(countourP2);
    }

    @Override
    public void mettreAJour() {
        if (!modele.recupererImages().isEmpty()) {
            perspective2 = modele.recupererImages().get(2);
            repaint();
        }
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(perspective2, 0, 0, getWidth(), getHeight(), this);
    }
}
