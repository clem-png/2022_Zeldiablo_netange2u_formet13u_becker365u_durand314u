package gameLaby.laby;

public class Fleche {

    /**
     * position du personnage
     */
    int x, y;

    boolean detruit;


    /**
     * constructeur
     *
     * @param dx position selon x
     * @param dy position selon y
     */
    public Fleche(int dx, int dy) {
        this.x = dx;
        this.y = dy;
        this.detruit = false;
    }


    /**
     * @return position x de la fleche
     */
    public int getX() {
        // getter
        return this.x;
    }

    /**
     * @return position y de la fleche
     */
    public int getY() {
        //getter
        return this.y;
    }

    public boolean etreDetruit(){
        this.detruit = true;
        return this.detruit;
    }
}
