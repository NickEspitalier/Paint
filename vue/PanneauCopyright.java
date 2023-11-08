package vue;

import javax.swing.*;
import java.awt.*;

public class PanneauCopyright extends JPanel {

    PanneauCopyright() {
        JLabel labelCopyright = new JLabel();
        labelCopyright.setText("Dominic Achkarian, Nicolas Espitalier & Thomas Lavoie © 2023");
        labelCopyright.setFont(new Font("Times New Roman", Font.BOLD, 18));
        add(labelCopyright);
    }
}
