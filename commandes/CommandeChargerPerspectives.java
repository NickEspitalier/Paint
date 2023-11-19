package commandes;

import modele.Figure;
import modele.ModeleApplication;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;

/**
 * Commande qui a pour but de charger des perspectives récupérées de la machine de l'utilisateur.
 */
public class CommandeChargerPerspectives extends Commande {
    public void executer(ModeleApplication modele) {
        // Une fenêtre de choix de fichier est premièrement appelée afin d'être utilisée par l'utilisateur.
        JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        fileChooser.setDialogTitle("Sélectionnez un groupe de perspectives");
        fileChooser.setAcceptAllFileFilterUsed(false);

        // Un filtre est ensuite établi pour celle-ci afin de ne récupérer que des fichiers en format IMA.
        FileNameExtensionFilter filtre = new FileNameExtensionFilter(".ima", "ima");
        fileChooser.addChoosableFileFilter(filtre);

        int returnValue = fileChooser.showOpenDialog(null);

        /* Si le fichier choisi est un groupe de perspectives, nous récupérons leurs données pour ensuite les inclure
           dans la liste des instances d'images du modèle de l'application. */
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            ArrayList<Figure> perspectivesAAfficher = new ArrayList<>();
            try {
                FileInputStream fichier = new FileInputStream(fileChooser.getSelectedFile());
                ObjectInputStream lecteurObjects = new ObjectInputStream(fichier);
                ArrayList<Figure> perspectivesRecuperees = (ArrayList<Figure>) lecteurObjects.readObject();

                /* Puisque les images sont initialement des tableaux d'octets, nous devons rétablir leurs
                   formes originales avant de les intégrer dans le modèle de l'application. */
                for (int i = 0; i < 3; i++) {
                    byte[] imageADecodee = perspectivesRecuperees.get(i).recupererApparenceCodee();
                    Image imageDecodee = ImageIO.read(new ByteArrayInputStream(imageADecodee));
                    perspectivesAAfficher.add(new Figure(imageDecodee,
                            perspectivesRecuperees.get(i).recupererPosition(),
                            perspectivesRecuperees.get(i).recupererTaille()));
                }

                fichier.close();
                lecteurObjects.close();
                modele.modifierPerspectives(perspectivesAAfficher);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Lecture impossible.", "Erreur",
                        JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Sélection annulée.", "Erreur",
                    JOptionPane.WARNING_MESSAGE);
        }
    }
}
