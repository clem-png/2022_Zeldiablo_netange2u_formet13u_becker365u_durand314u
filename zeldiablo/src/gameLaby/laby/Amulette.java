package gameLaby.laby;

/**
 * Gère une amulette située en x, y
 */
public class Amulette implements Entite {

    boolean apparue;

    boolean recup;

    int x, y;

    /**
     * Constructeur de l'amulette
     *
     * @param x coordonnée x de l'amulette
     * @param y coordonné y de l'amulette
     */
    public Amulette(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * permet de savoir si l'amulette est en x,y
     *
     * @param dx position selon x
     * @param dy position selon y
     * @return
     */
    @Override
    public boolean etrePresent(int dx, int dy) {
        return (this.x == dx && this.y == dy);
    }

    @Override
    public int getX() {
        return this.x;
    }

    @Override
    public int getY() {
        return this.y;
    }
}
