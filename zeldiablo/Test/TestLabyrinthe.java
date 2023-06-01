import gameLaby.laby.Labyrinthe;
import gameLaby.laby.Perso;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class TestLabyrinthe {

    private Labyrinthe labyrinthe;

    @BeforeEach
    public void setUp() throws IOException {
        labyrinthe = new Labyrinthe("labySimple/laby1.txt");
    }

    @Test
    public void testGetSuivant_Haut() {
        int[] suivant = Labyrinthe.getSuivant(1, 1, Labyrinthe.HAUT);
        assertArrayEquals(new int[]{1, 0}, suivant);
    }

    @Test
    public void testGetSuivant_Bas() {
        int[] suivant = Labyrinthe.getSuivant(1, 1, Labyrinthe.BAS);
        assertArrayEquals(new int[]{1, 2}, suivant);
    }

    @Test
    public void testGetSuivant_Droite() {
        int[] suivant = Labyrinthe.getSuivant(1, 1, Labyrinthe.DROITE);
        assertArrayEquals(new int[]{2, 1}, suivant);
    }

    @Test
    public void testGetSuivant_Gauche() {
        int[] suivant = Labyrinthe.getSuivant(1, 1, Labyrinthe.GAUCHE);
        assertArrayEquals(new int[]{0, 1}, suivant);
    }

    @Test
    public void testDeplacerPerso_Haut() {
        int x = labyrinthe.pj.getX();
        int y = labyrinthe.pj.getY();
        labyrinthe.deplacerPerso(Labyrinthe.HAUT);

        assertEquals(x, labyrinthe.pj.getX());
        assertEquals(y-1, labyrinthe.pj.getY());
    }

    @Test
    public void testDeplacerPerso_Bas() {
        int x = labyrinthe.pj.getX();
        int y = labyrinthe.pj.getY();
        labyrinthe.deplacerPerso(Labyrinthe.HAUT);
        labyrinthe.deplacerPerso(Labyrinthe.BAS);

        assertEquals(x, labyrinthe.pj.getX());
        assertEquals(y, labyrinthe.pj.getY());
    }

    @Test
    public void testDeplacerPerso_Droite() {
        int x = labyrinthe.pj.getX();
        int y = labyrinthe.pj.getY();

        labyrinthe.deplacerPerso(Labyrinthe.DROITE);

        assertEquals(x+1, labyrinthe.pj.getX());
        assertEquals(y, labyrinthe.pj.getY());
    }

    @Test
    public void testDeplacerPerso_Gauche() {
        int x = labyrinthe.pj.getX();
        int y = labyrinthe.pj.getY();
        labyrinthe.deplacerPerso(Labyrinthe.DROITE);
        labyrinthe.deplacerPerso(Labyrinthe.GAUCHE);

        assertEquals(x, labyrinthe.pj.getX());
        assertEquals(y, labyrinthe.pj.getY());
    }

    @Test
    public void testDeplacerPerso_Mur() {
        labyrinthe.deplacerPerso(Labyrinthe.GAUCHE);

        // Le personnage ne devrait pas avoir bougé car il y a un mur à gauche
        assertEquals(1, labyrinthe.pj.getX());
        assertEquals(1, labyrinthe.pj.getY());
    }

    @Test
    public void testEtreFini() {
        assertFalse(labyrinthe.etreFini());
    }

    @Test
    public void testGetLengthY() {
        assertEquals(3, labyrinthe.getLengthY());
    }

    @Test
    public void testGetLength() {
        assertEquals(3, labyrinthe.getLength());
    }

    @Test
    public void testGetMur() {
        assertTrue(labyrinthe.getMur(0, 0));
        assertFalse(labyrinthe.getMur(1, 1));
        assertFalse(labyrinthe.getMur(2, 2));
    }

    @Test
    public void testGetPj() {
        Perso pj = labyrinthe.pj;
        assertNotNull(pj);
        assertEquals(1, pj.getX());
        assertEquals(1, pj.getY());
    }
}
