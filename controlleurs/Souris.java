package controlleurs;

import commandes.CommandeAgrandir;
import commandes.CommandePressePapier;
import commandes.CommandeReduire;
import commandes.CommandeTranslation;
import modele.ModeleApplication;

import java.awt.event.*;

/**
 * Classe représentant une souris. Une souris a pour but de gérer les commandes de l'utilisateur qui modifie
 * directement les instances des images modifiables, soit la première et la deuxième perspective.
 */
public class Souris implements MouseListener, MouseMotionListener, MouseWheelListener {
    /**** Initialisation des variables ****/
    private static int x;                                         // Position en x de la souris
    private static int y;                                         // Position en y de la souris
    private static int dx;                                        // Déplacement en x de la souris
    private static int dy;                                        // Déplacement en y de la souris
    private static int sensDeLaMolette;                           // Sens de la molette
    private static String perspectiveActuel;                      // Perspective actuel de la souris
    private ControlleurPerspectives controlleurPerspectives;      // Controlleur des perspectives


    /**
     * Constructeur d'initialisation. La souris récupère les données du modèle de l'application, et ensuite
     * crée le contrôleur des perspectives.
     *
     * @param modele Modèle de l'application
     */
    public Souris(ModeleApplication modele){
        controlleurPerspectives = new ControlleurPerspectives(new CommandePressePapier(), new CommandeTranslation(),
                new CommandeAgrandir(), new CommandeReduire(), modele);
    }

    /**
     * Méthode qui s'active au moment où un clic de la souris se produit.
     *
     * @param e Un évènement relié à la souris
     */
    @Override
    public void mouseClicked(MouseEvent e) {}

    /**
     * Méthode qui s'active au moment où un clic de la souris se produit et est ensuite maintenu. Celle-ci est
     * notamment utilisée pour récupérer la position de la souris dans une perspective.
     *
     * @param e Un évènement relié à la souris
     */
    @Override
    public void mousePressed(MouseEvent e) {
        Souris.x = e.getX();
        Souris.y = e.getY();
    }


    /**
     * Méthode qui s'active au moment où un clic de la souris se produit et est maintenu pendant que la souris
     * est ensuite déplacée. Celle-ci est notamment utilisée pour gérer la technique de translation de l'instance
     * d'une image dans une des perspectives selon le déplacement de la souris.
     *
     * @param e Un évènement relié à la souris
    */
    @Override
    public void mouseDragged(MouseEvent e){
        Souris.dx = e.getX() - Souris.x;
        Souris.dy = e.getY() - Souris.y;
        controlleurPerspectives.deplacerPerspective();
    }

    /**
     * Méthode qui s'active au moment où un clic de la souris se termine.
     *
     * @param e Un évènement relié à la souris
     */
    @Override
    public void mouseReleased(MouseEvent e) {}

    /**
     * Méthode qui s'active au moment où la souris est déplacée.
     *
     * @param e Un évènement relié à la souris
     */
    @Override
    public void mouseMoved(MouseEvent e) {}

    /**
     * Méthode qui s'active au moment où un la souris est détectée dans un élément graphique de l'application.
     * Celle-ci est notamment utilisée pour changer la perspective actuelle de la souris selon sa position entre
     * la première et la deuxième perspective.
     *
     * @param e Un évènement relié à la souris
     */
    @Override
    public void mouseEntered(MouseEvent e) {
        String figureActuel = e.getSource().toString();

        if(figureActuel.startsWith("Perspective1")){
            perspectiveActuel = "Perspective1";
        }
        else if(figureActuel.startsWith("Perspective2")){
            perspectiveActuel = "Perspective2";
        }
    }

    /**
     * Méthode qui s'active au moment où la souris n'est plus détectée dans un élément graphique de l'application.
     *
     * @param e Un évènement relié à la souris
     */
    @Override
    public void mouseExited(MouseEvent e) {}

    /**
     * Méthode qui s'active au moment où la roue de la souris est déplacée. Celle-ci est notamment utilisée pour
     * agrandir ou réduire une instance d'une image dans une perspective selon le déplacement de la roue.
     *
     * @param e Un évènement relié à la souris
     */
    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        sensDeLaMolette = e.getWheelRotation();
        if (sensDeLaMolette < 0) { controlleurPerspectives.changerTaillePerspective(sensDeLaMolette); }
        else { controlleurPerspectives.changerTaillePerspective(sensDeLaMolette); }
    }

    // Getters des variables
    public static int getDx() { return dx; }
    public static int getDy() { return dy; }
    public static int getSensDeLaMolette() { return sensDeLaMolette; }
    public static String getPerspectiveActuel() { return perspectiveActuel; }
}

