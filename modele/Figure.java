package modele;

import java.awt.*;

public class Figure {
    private Image apparence;
    private int[] position;
    private int[] taille;

    public Figure(Image apparence, int[] position, int[] taille) {
        this.apparence = apparence;
        this.position = position;
        this.taille = taille;
    }

    public void modifierPosition(int[] pos) { this.position = pos; }
    public void modifierTaille(int[] t) { this.taille = t; }

    public Image recupererApparence() { return apparence; }
    public int[] recupererPosition() { return position; }
    public int[] recupererTaille() { return taille; }
}
