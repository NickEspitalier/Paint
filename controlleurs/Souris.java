package controlleurs;

import com.sun.xml.internal.bind.v2.runtime.output.StAXExStreamWriterOutput;
import commandes.*;
import modele.Figure;
import modele.ModeleApplication;
import vue.Perspective1;
import vue.Perspective2;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;


public class Souris implements MouseListener, MouseMotionListener, MouseWheelListener {
    private static int x; // Poistion en x de la souris
    private static int y; // Position en y de la souris
    private static int dx; // Déplacement en x de la souris
    private static int dy; // Déplacement en y de la souris
    private static int sensDeLaMolette; // Sens de la molette

    private static String perspectiveActuel;
    private Perspective1 p1;  // La perspective 1
    private Perspective2 p2; // La perspective 2
    private ControlleurPerspectives controlleurPerspectives; // Le controlleur qui va s'occuper de faire les actions

    // GETTERS
    public static int getX() {
        return x;
    }

    public static int getY() {
        return y;
    }

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


    public Souris(ModeleApplication modele){
        controlleurPerspectives = new ControlleurPerspectives(new CommandePressePapier(), new CommandeTranslation(),
                new CommandeAgrandir(), new CommandeReduire(), modele);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        Souris.x = e.getX();
        Souris.y = e.getY();
    }

    @Override
    public void mouseDragged(MouseEvent e){
        Souris.dx = e.getX() - Souris.x;
        Souris.dy = e.getY() - Souris.y;
        controlleurPerspectives.deplacerPerspective();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

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
    public void mouseExited(MouseEvent e) {
    }


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

