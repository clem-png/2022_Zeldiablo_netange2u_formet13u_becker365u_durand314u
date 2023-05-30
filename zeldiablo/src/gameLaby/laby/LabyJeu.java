package gameLaby.laby;

import moteurJeu.Clavier;
import moteurJeu.Jeu;

import java.io.IOException;

public class LabyJeu implements Jeu {

    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;

    private final Labyrinthe laby ;

    public LabyJeu () throws IOException {
        this.laby = new Labyrinthe("labySimple/laby1.txt") ;
    }

    @Override
    public void update(double secondes, Clavier clavier) {
        if (clavier.haut){
            laby.deplacerPerso("Haut");
        }

        if (clavier.bas){
            laby.deplacerPerso("Bas");
        }

        if (clavier.gauche){
            laby.deplacerPerso("Gauche");
        }

        if (clavier.droite){
            laby.deplacerPerso("Droite");
        }
    }

    @Override
    public void init() {

    }

    @Override
    public boolean etreFini() {
        return false;
    }

    public Labyrinthe getLaby() { return this.laby ;}
    
}
