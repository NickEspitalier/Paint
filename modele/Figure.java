package modele;

import java.awt.*;
import java.io.Serializable;

/**
 * Classe qui contient les informations reliées à une figure de l'application. Une figure est une instance d'une
 * image qui a été chargée afin d'être affichée dans la vignette et les perspectives, et ensuite être modifiée par
 * l'utilisateur.
 */
public class Figure implements Serializable {
    /**** Initialisation des variables ****/
    private Image apparence;                // Apparence de la figure
    private byte[] apparenceCodee;          // Apparence chiffrée de la figure
    private int[] position;                 // Position de la figure, en coordonnées [x,y]
    private int[] taille;                   // Taille de la figure, selon un modèle [largeur, hauteur]

    /**
     * Constructeur d'initialisation avec variables.
     */
    public Figure(Image apparence, int[] position, int[] taille) {
        this.apparence = apparence;
        this.position = position;
        this.taille = taille;
    }

    /**
     * Constructeur d'initialisation utilisé pour le chiffrement de l'image durant la sauvegarde.
     */
    public Figure(byte[] apparenceCodee, int[] position, int[] taille) {
        this.apparenceCodee = apparenceCodee;
        this.position = position;
        this.taille = taille;
    }

    // Setters et Getters des variables du modèle
    public void modifierPosition(int[] pos) { this.position = pos; }
    public void modifierTaille(int[] t) { this.taille = t; }
    public Image recupererApparence() { return apparence; }
    public byte[] recupererApparenceCodee() { return apparenceCodee; }
    public int[] recupererPosition() { return position; }
    public int[] recupererTaille() { return taille; }
}
