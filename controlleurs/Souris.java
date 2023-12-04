package controlleurs;

import commandes.CommandeAgrandir;
import commandes.CommandePressePapier;
import commandes.CommandeReduire;
import commandes.CommandeTranslation;
import modele.ModeleApplication;

import java.awt.event.*;

/**
 * La classe souris gère les commandes exécuter sur les images
 * selon ce que l'utilisateur fait avec la souris.
 * Les fonctionnalités fonctionne seulement sur la perspective 1 et 2 intentionnellement
 */
public class Souris implements MouseListener, MouseMotionListener, MouseWheelListener {
    private static int x; // Poistion en x de la souris
    private static int y; // Position en y de la souris
    private static int dx; // Déplacement en x de la souris
    private static int dy; // Déplacement en y de la souris
    private static int sensDeLaMolette; // Sens de la molette

    private static String perspectiveActuel; // Perspective actuel de la souris

    private ControlleurPerspectives controlleurPerspectives; // Le controlleur qui va s'occuper de faire les actions

    // GETTERS
    public static int getDx() {
        return dx;
    }

    public static int getDy() {
        return dy;
    }

    public static int getSensDeLaMolette() { return sensDeLaMolette; }

    public static String getPerspectiveActuel() {
        return perspectiveActuel;
    }


    // CONSTRUCTEUR
    public Souris(ModeleApplication modele){
        controlleurPerspectives = new ControlleurPerspectives(new CommandePressePapier(), new CommandeTranslation(),
                new CommandeAgrandir(), new CommandeReduire(), modele);
    }


    @Override
    public void mouseClicked(MouseEvent e) {}

    /* Méthode qui initialise la position initiale de la souris
     */
    @Override
    public void mousePressed(MouseEvent e) {
        Souris.x = e.getX();
        Souris.y = e.getY();
    }


    /* Méthode qui gère la translation de l'image
    sur la perspective selon le déplacement de la souris
    */
    @Override
    public void mouseDragged(MouseEvent e){
        Souris.dx = e.getX() - Souris.x;
        Souris.dy = e.getY() - Souris.y;
        controlleurPerspectives.deplacerPerspective();
    }

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseMoved(MouseEvent e) {}

    /* Méthode qui change la perspective actuel selon
       la position de la souris entre les deux perspectives
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

    @Override
    public void mouseExited(MouseEvent e) {}


    /* Méthode qui gère le mouvement de la roulette sur les perspectives
       pour agrandir ou réduire les images
    */
    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        sensDeLaMolette = e.getWheelRotation();

        if (sensDeLaMolette < 0) {
            controlleurPerspectives.changerTaillePerspective(sensDeLaMolette);
        } else {
            controlleurPerspectives.changerTaillePerspective(sensDeLaMolette);
        }
    }
}

