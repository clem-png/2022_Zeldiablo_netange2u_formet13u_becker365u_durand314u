package gameLaby.laby;

public class Entite {
    int x, y;

    /**
     * constructeur
     *
     * @param dx position selon x
     * @param dy position selon y
     */

    public Entite(int dx, int dy) {
        this.x = dx;
        this.y = dy;
    }

    public boolean etrePresent(int dx, int dy) {
        return (this.x == dx && this.y == dy);
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }



}
