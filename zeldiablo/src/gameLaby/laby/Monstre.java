package gameLaby.laby;

public class Monstre {

    /**
     * position du personnage
     */
    int x, y;
    int pv = 2;

    boolean subirattaque ;
    boolean mort;


    /**
     * constructeur
     *
     * @param dx position selon x
     * @param dy position selon y
     */
    public Monstre(int dx, int dy) {
        this.x = dx;
        this.y = dy;
        this.subirattaque = false ;
        this.mort = false ;
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

    public void subirAttaque(){
        if (pv > 0 ) {
            this.pv--;
            this.subirattaque = true;
        }else{
            this.mort = true ;
        }

    }

    public boolean etreMort(){
        return this.mort ;
    }
}
