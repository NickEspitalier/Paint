package mvc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class PanneauStrategieCopie extends JPanel {

    public PanneauStrategieCopie() {
        JCheckBox cochePosition = new JCheckBox("Position");
        JCheckBox cocheZoom = new JCheckBox("Niveau de zoom");
        JButton boutonConfirmation = new JButton("Confirmer");
        JButton boutonAnnulation = new JButton("Annuler");

        boutonConfirmation.addActionListener((ActionEvent e) -> {
            if (cochePosition.isSelected()) {
                System.out.println("Position");
            }

            if (cocheZoom.isSelected()) {
                System.out.println("Niveau de zoom");
            }
        });

        boutonAnnulation.addActionListener((ActionEvent e) -> {
            SwingUtilities.getWindowAncestor((Component) e.getSource()).dispose();
        });

        add(cochePosition);
        add(cocheZoom);
        add(boutonConfirmation);
        add(boutonAnnulation);
    }
}
