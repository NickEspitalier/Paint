package vue;

import modele.ModeleApplication;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class PanneauStrategieCopie extends JPanel {

    public PanneauStrategieCopie(ModeleApplication modele) {
        JCheckBox cochePosition = new JCheckBox("Position");
        JCheckBox cocheZoom = new JCheckBox("Niveau de zoom");
        JButton boutonConfirmation = new JButton("Confirmer");
        JButton boutonAnnulation = new JButton("Annuler");

        boutonConfirmation.addActionListener((ActionEvent e) -> {
            if (cochePosition.isSelected() && cocheZoom.isSelected()) {
                modele.modifierOptionsPressePapier("Position et Niveau de zoom");
            } else if (cochePosition.isSelected()) { modele.modifierOptionsPressePapier("Position");
            } else if (cocheZoom.isSelected()) { modele.modifierOptionsPressePapier("Niveau de zoom"); }

            System.out.println(modele.recupererChoixPressePapier());
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
