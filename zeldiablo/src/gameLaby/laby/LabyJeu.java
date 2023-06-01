package gameLaby.laby;

import moteurJeu.Clavier;
import moteurJeu.Jeu;

import java.io.IOException;

public class LabyJeu implements Jeu {

    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;

    private Labyrinthe laby;

    public LabyJeu() {
        try {
            this.laby = new Labyrinthe("labySimple/laby3.txt");
        } catch (IOException e) {
            System.out.println("Erreur lors de la lecture du fichier : " + e.getMessage());
        }
    }

    public LabyJeu(String s) {
        try {
            this.laby = new Labyrinthe("labySimple/"+s);
        } catch (IOException e) {
            System.out.println("Erreur lors de la lecture du fichier : " + e.getMessage());
        }
    }

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

        if (clavier.espace){
            laby.attaque();
        }
    }

    @Override
    public void init() {

    }

    @Override
    public boolean etreFini() {
        boolean b = true ;
        for (int i = 0 ; i<laby.monstres.size() ; i++){
            if (!laby.monstres.get(i).etreMort()){
                b = true ;
            }
        }
        return b ;
    }

    public Labyrinthe getLaby() {
        return this.laby;
    }

}
