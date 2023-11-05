package vue;

import modeles.ModeleApplication;

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
                modele.choisirOptionsPressePapier("Position et Niveau de zoom");
            } else if (cochePosition.isSelected()) {
                modele.choisirOptionsPressePapier("Position");
            } else if (cocheZoom.isSelected()) {
                modele.choisirOptionsPressePapier("Niveau de zoom");
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
