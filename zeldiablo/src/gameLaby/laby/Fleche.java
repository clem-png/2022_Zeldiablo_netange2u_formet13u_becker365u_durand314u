package gameLaby.laby;

public class Fleche extends Entite {

    /**
     * position du personnage
     */
    boolean detruit;


    /**
     * constructeur
     *
     * @param dx position selon x
     * @param dy position selon y
     */
    public Fleche(int dx, int dy) {
        super(dx, dy);
        this.detruit = false;
    }

    public boolean etreDetruit(){
        this.detruit = true;
        return this.detruit;
    }
}
