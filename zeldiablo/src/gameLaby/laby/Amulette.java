package gameLaby.laby;

/**
 * Gère une amulette située en x, y
 */
public class Amulette extends Entite {

    boolean apparue;

    boolean recup;

    /**
     * Constructeur de l'amulette
     *
     * @param x coordonnée x de l'amulette
     * @param y coordonné y de l'amulette
     */
    public Amulette(int x, int y) {
        super(x, y);
        this.apparue = false;
        this.recup = false;
    }

    public boolean isApparue() {
        return apparue;
    }

    public void setApparue(boolean apparue) {
        this.apparue = apparue;
    }
}
