import gameLaby.laby.LabyJeu;
import gameLaby.laby.Labyrinthe;
import gameLaby.laby.Perso;
import moteurJeu.Clavier;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class TestJeuLaby {

    private LabyJeu labyJeu;
    private Labyrinthe labyrinthe;

    @BeforeEach
    public void setUp() {
        labyJeu = new LabyJeu();
        labyrinthe = labyJeu.getLaby();
    }

    @Test
    public void testUpdate_Haut() {
        Clavier clavier = new Clavier();
        clavier.haut = true;
        labyJeu.update(1.0, clavier);

        int x = labyrinthe.pj.getX();
        int y = labyrinthe.pj.getY();

        Perso pj = labyJeu.getLaby().pj;
        assertEquals(x, pj.getX());
        assertEquals(y, pj.getY());
    }

    @Test
    public void testUpdate_Bas() {
        Clavier clavier = new Clavier();
        clavier.bas = true;
        labyJeu.update(1.0, clavier);

        int x = labyrinthe.pj.getX();
        int y = labyrinthe.pj.getY();

        Perso pj = labyJeu.getLaby().pj;
        assertEquals(x, pj.getX());
        assertEquals(y, pj.getY());
    }

    @Test
    public void testUpdate_Gauche() {
        Clavier clavier = new Clavier();
        clavier.gauche = true;
        labyJeu.update(1.0, clavier);

        int x = labyrinthe.pj.getX();
        int y = labyrinthe.pj.getY();

        Perso pj = labyJeu.getLaby().pj;
        assertEquals(x, pj.getX());
        assertEquals(y, pj.getY());
    }

    @Test
    public void testUpdate_Droite() {
        Clavier clavier = new Clavier();
        clavier.droite = true;
        labyJeu.update(1.0, clavier);

        int x = labyrinthe.pj.getX();
        int y = labyrinthe.pj.getY();

        Perso pj = labyJeu.getLaby().pj;
        assertEquals(x, pj.getX());
        assertEquals(y, pj.getY());
    }

    @Test
    public void testUpdate_AucuneToucheAppuyee() {
        Clavier clavier = new Clavier();
        labyJeu.update(1.0, clavier);

        int x = labyrinthe.pj.getX();
        int y = labyrinthe.pj.getY();

        Perso pj = labyJeu.getLaby().pj;
        assertEquals(x, pj.getX());
        assertEquals(y, pj.getY());
    }

    @Test
    public void testInit() {
        // Vérifie que la méthode init ne produit pas d'erreur
        labyJeu.init();
    }

}
