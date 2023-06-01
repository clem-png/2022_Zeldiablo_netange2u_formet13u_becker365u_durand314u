import gameLaby.laby.LabyJeu;
import gameLaby.laby.Perso;
import moteurJeu.Clavier;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class TestJeuLaby {

    private LabyJeu labyJeu;

    @BeforeEach
    public void setUp() {
        labyJeu = new LabyJeu();
    }

    @Test
    public void testUpdate_Haut() {
        Clavier clavier = new Clavier();
        clavier.haut = true;
        labyJeu.update(1.0, clavier);

        Perso pj = labyJeu.getLaby().pj;
        assertEquals(1, pj.getX());
        assertEquals(0, pj.getY());
    }

    @Test
    public void testUpdate_Bas() {
        Clavier clavier = new Clavier();
        clavier.bas = true;
        labyJeu.update(1.0, clavier);

        Perso pj = labyJeu.getLaby().pj;
        assertEquals(1, pj.getX());
        assertEquals(2, pj.getY());
    }

    @Test
    public void testUpdate_Gauche() {
        Clavier clavier = new Clavier();
        clavier.gauche = true;
        labyJeu.update(1.0, clavier);

        Perso pj = labyJeu.getLaby().pj;
        assertEquals(0, pj.getX());
        assertEquals(1, pj.getY());
    }

    @Test
    public void testUpdate_Droite() {
        Clavier clavier = new Clavier();
        clavier.droite = true;
        labyJeu.update(1.0, clavier);

        Perso pj = labyJeu.getLaby().pj;
        assertEquals(2, pj.getX());
        assertEquals(1, pj.getY());
    }

    @Test
    public void testUpdate_AucuneToucheAppuyee() {
        Clavier clavier = new Clavier();
        labyJeu.update(1.0, clavier);

        Perso pj = labyJeu.getLaby().pj;
        assertEquals(1, pj.getX());
        assertEquals(1, pj.getY());
    }

    @Test
    public void testInit() {
        // Vérifie que la méthode init ne produit pas d'erreur
        labyJeu.init();
    }

    @Test
    public void testEtreFini() {
        assertFalse(labyJeu.etreFini());
    }
}
