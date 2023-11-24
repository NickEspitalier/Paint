package controlleurs;

import modele.Figure;

import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Souris {
    private int x; // Poistion en x de la souris
    private int y; // Position en y de la souris
    private int dx; // Déplacement en x de la souris
    private int dy; // Déplacement en y de la souris


    // GETTERS
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getDx() {
        return dx;
    }

    public int getDy() {
        return dy;
    }


    // SETTERS
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setDx(int dx) {
        this.dx = dx;
    }

    public void setDy(int dy) {
        this.dy = dy;
    }
}
