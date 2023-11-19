package commandes;

import modele.Figure;
import modele.ModeleApplication;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import java.awt.image.RenderedImage;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * Commande qui a pour but de sauvegarder les perspectives présentement en utilisation.
 */
public class CommandeSauvegarder extends Commande {
    public void executer(ModeleApplication modele) {
        /* Une fenêtre de choix d'emplacement du fichier est premièrement appelée afin d'être utilisée
           par l'utilisateur. */
        JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        fileChooser.setDialogTitle("Sauvegardez en tant que...");
        fileChooser.setAcceptAllFileFilterUsed(false);

        // Un filtre est ensuite établi pour celle-ci afin de ne percevoir que des documents et des fichiers IMA.
        FileNameExtensionFilter filtre = new FileNameExtensionFilter(".ima", "ima");
        fileChooser.addChoosableFileFilter(filtre);

        int returnValue = fileChooser.showSaveDialog(null);

        /* Après que la sélection de l'emplacement du fichier est confirmée, nous sauvegardons les perspectives dans
           un fichier selon un format ".IMA". */
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            ArrayList<Figure> imagesAffichees = modele.recupererImages();
            ArrayList<Figure> imagesASauvegarder = new ArrayList<>();
            try {
                if (imagesAffichees.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Une image ainsi que ses " +
                                    "perspectives n'ont pas encore été chargées.", "Erreur",
                            JOptionPane.WARNING_MESSAGE);
                } else {
                    FileOutputStream fichier = new FileOutputStream(fileChooser.getSelectedFile() + ".ima");
                    ObjectOutputStream lecteurObjets = new ObjectOutputStream(fichier);

                    /* Puisqu'une image n'est pas sérialisable, nous transformons premièrement les images des
                       instances en des tableaux d'octets avant de les sauvegarder avec le reste des paramètres
                       des perspectives. Note : ce processus change le format des images en format PNG. */
                    for (Figure f : imagesAffichees) {
                        ByteArrayOutputStream lecteurImageEncodee = new ByteArrayOutputStream();
                        ImageIO.write((RenderedImage) f.recupererApparence(), "png", lecteurImageEncodee);
                        byte[] imageEncodee = lecteurImageEncodee.toByteArray();

                        imagesASauvegarder.add(new Figure(imageEncodee, f.recupererPosition(),
                                f.recupererTaille()));
                    }

                    lecteurObjets.writeObject(imagesASauvegarder);

                    lecteurObjets.close();
                    fichier.close();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Sauvegarde impossible.", "Erreur",
                        JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Sélection annulée.", "Erreur",
                    JOptionPane.WARNING_MESSAGE);
        }
    }
}
