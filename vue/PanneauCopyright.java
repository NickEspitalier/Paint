package vue;

import javax.swing.*;
import java.awt.*;

/**
 * Panneau Swing qui affiche les droits des auteurs de l'application.
 */
public class PanneauCopyright extends JPanel {

    /**
     * Constructeur d'initialisation. Le panneau crée une étiquette contenant les droits d'auteurs ainsi que
     * sa police de caractère avant de l'attacher à lui-même.
     */
    public PanneauCopyright() {
        JLabel labelCopyright = new JLabel();
        labelCopyright.setText("Dominic Achkarian, Nicolas Espitalier & Thomas Lavoie © 2023");
        labelCopyright.setFont(new Font("Times New Roman", Font.BOLD, 18));
        add(labelCopyright);
    }
}
