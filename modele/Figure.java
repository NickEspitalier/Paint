package modele;

import java.awt.*;
import java.io.Serializable;

public class Figure implements Serializable {
    private Image apparence;
    private byte[] apparenceCodee;
    private int[] position;
    private int[] taille;

    public Figure(Image apparence, int[] position, int[] taille) {
        this.apparence = apparence;
        this.position = position;
        this.taille = taille;
    }

    public Figure(byte[] apparenceCodee, int[] position, int[] taille) {
        this.apparenceCodee = apparenceCodee;
        this.position = position;
        this.taille = taille;
    }

    public void modifierPosition(int[] pos) { this.position = pos; }
    public void modifierTaille(int[] t) { this.taille = t; }
    public Image recupererApparence() { return apparence; }
    public byte[] recupererApparenceCodee() { return apparenceCodee; }
    public int[] recupererPosition() { return position; }
    public int[] recupererTaille() { return taille; }
}
