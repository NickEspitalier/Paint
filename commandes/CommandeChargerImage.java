package commandes;

import modele.ModeleApplication;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import java.io.File;

/**
 * Commande qui a pour but de charger une image.
 */
public class CommandeChargerImage extends Commande {

    private GestionnaireDeCommande gestionnaireDeCommande = GestionnaireDeCommande.getInstance();

    public void executer(ModeleApplication modele) {
        // Une fenêtre de choix de fichier est premièrement appelée afin d'être utilisé par l'utilisateur.
        JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        fileChooser.setDialogTitle("Sélectionnez une image");
        fileChooser.setAcceptAllFileFilterUsed(false);

        // Un filtre est ensuite établi pour celle-ci afin de ne récupérer que des images en format JPG ou PNG.
        FileNameExtensionFilter filtre = new FileNameExtensionFilter(".jpg, .png", "jpg", "png");
        fileChooser.addChoosableFileFilter(filtre);

        int returnValue = fileChooser.showOpenDialog(null);

        /* Si le fichier choisi est une image, nous stockons cette image dans le modèle de l'application. Sinon, on
           génère un message d'erreur. */
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            try {
                modele.stockerNouvelleImage(ImageIO.read(new File(fileChooser.getSelectedFile().getAbsolutePath())));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Lecture impossible.", "Erreur",
                        JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Sélection annulée.", "Erreur",
                    JOptionPane.WARNING_MESSAGE);
        }

        gestionnaireDeCommande.AjoutCommande(this);
    }
}
