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
            laby.deplacerPerso("HAUT");
        }

        if (clavier.bas){
            laby.deplacerPerso("BAS");
        }

        if (clavier.gauche){
            laby.deplacerPerso("GAUCHE");
        }

        if (clavier.droite){
            laby.deplacerPerso("DROITE");
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
