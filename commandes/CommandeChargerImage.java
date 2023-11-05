package commandes;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;

public class CommandeChargerImage implements Commande {
    public void executer() {
        JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        fileChooser.setDialogTitle("Sélectionnez une image");
        fileChooser.setAcceptAllFileFilterUsed(false);

        // Un filtre est établi afin de ne récupérer que des images.
        FileNameExtensionFilter filtre = new FileNameExtensionFilter(".jpg, .png", "jpg",
                "png");
        fileChooser.addChoosableFileFilter(filtre);

        int returnValue = fileChooser.showOpenDialog(null);

        // Si le fichier choisi est une image, nous commençons à le lire. Sinon, on génère un message d'erreur.
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            try {
                ImageIcon image = new ImageIcon(fileChooser.getSelectedFile().getAbsolutePath());
                Image im = image.getImage();

            }
            catch (Exception e) {
                JOptionPane.showMessageDialog(null,
                        "Lecture impossible.",
                        "Erreur", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null,
                    "Sélection annulée.", "Erreur",
                    JOptionPane.WARNING_MESSAGE);
        }
    };
}
