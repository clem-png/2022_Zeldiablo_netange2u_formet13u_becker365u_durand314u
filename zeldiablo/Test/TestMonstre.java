import gameLaby.laby.Monstre;
import org.junit.jupiter.api.*;
import static org.junit.Assert.*;


public class TestMonstre {

    @Test
    public void testEtrePresent() {
        Monstre monstre = new Monstre(3, 4);

        // Le monstre est présent en (3,4)
        assertTrue(monstre.etrePresent(3, 4));

        // Le monstre n'est pas présent en (2,4)
        assertFalse(monstre.etrePresent(2, 4));

        // Le monstre n'est pas présent en (3,5)
        assertFalse(monstre.etrePresent(3, 5));
    }

    @Test
    public void testGetX() {
        Monstre monstre = new Monstre(3, 4);

        // La position x du monstre est 3
        assertEquals(3, monstre.getX());
    }

    @Test
    public void testGetY() {
        Monstre monstre = new Monstre(3, 4);

        // La position y du monstre est 4
        assertEquals(4, monstre.getY());
    }
}
