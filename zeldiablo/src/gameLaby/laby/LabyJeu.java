package gameLaby.laby;

import moteurJeu.Clavier;
import moteurJeu.Jeu;

import java.io.IOException;

/**
 * Classe LabyJeu
 */
public class LabyJeu implements Jeu {

    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;

    private Labyrinthe laby;

    /**
     * Constructeur LabyJeu qui créer un labyrinthe avec le nom de fichier
     */
    public LabyJeu() {
        try {
            this.laby = new Labyrinthe("labySimple/laby4.txt");
        } catch (IOException e) {
            System.out.println("Erreur lors de la lecture du fichier : " + e.getMessage());
        }
    }

    /**
     * Constructeur labyJeu qui créer un labyrinthe avec le nom du fichier passé en paramètre
     *
     * @param s Nom du fichier
     */
    public LabyJeu(String s) {
        try {
            this.laby = new Labyrinthe("labySimple/" + s);
        } catch (IOException e) {
            System.out.println("Erreur lors de la lecture du fichier : " + e.getMessage());
        }
    }

    /**
     * Methode update qui détecte les actions réalisées pour deplacer le perso
     * @param secondes temps ecoule depuis la derniere mise a jour
     * @param clavier objet contenant l'état du clavier'
     */
    @Override
    public void update(double secondes, Clavier clavier) {
        if (clavier.haut) {
            laby.deplacerPerso(Labyrinthe.HAUT);
        }

        if (clavier.bas) {
            laby.deplacerPerso("Bas");
        }

        if (clavier.gauche) {
            laby.deplacerPerso("Gauche");
        }

        if (clavier.droite) {
            laby.deplacerPerso("Droite");
        }

        laby.deplacerMonstreAll();

        if (clavier.espace) {
            laby.pj.setEnAttente(true);
            laby.attaque();
        } else {
            laby.pj.setEnAttente(false);
        }
    }

    @Override
    public void init() {

    }

    @Override
    public boolean etreFini() {
        return laby.etreFini();
    }

    public Labyrinthe getLaby() {
        return this.laby;
    }

}