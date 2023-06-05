package gameLaby.laby;


/**
 * gere un personnage situe en x,y
 */
public class Perso extends Entite {

    /**
     * position du personnage
     */


    boolean avoirAmulette = false;

    boolean enAttente = false;

    /**
     * constructeur
     *
     * @param dx position selon x
     * @param dy position selon y
     */
    public Perso(int dx, int dy) {
        super(dx, dy);
    }

    /**
     * permet de savoir si le personnage est en x,y
     *
     * @param dx position testee
     * @param dy position testee
     * @return true si le personnage est bien en (dx,dy)
     */
    public boolean etrePresent(int dx, int dy) {

        return (this.x == dx && this.y == dy);
    }

    // ############################################
    // GETTER
    // ############################################

    /**
     * @return position x du personnage
     */
    public int getX() {
        // getter
        return this.x;
    }

    /**
     * @return position y du personnage
     */
    public int getY() {
        //getter
        return this.y;
    }

    public void setEnAttente(boolean b) {
    	this.enAttente = b;
    }

    public boolean getEnAttente() {
    	return this.enAttente;
    }

    public void setAvoirAmulette(boolean b) {
    	this.avoirAmulette = b;
    }

    public boolean getAvoirAmulette() {
    	return this.avoirAmulette;
    }


}
