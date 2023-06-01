package gameLaby.laby;

public class Monstre {

    /**
     * position du personnage
     */
    int x, y;
    int pv = 2;

    /**
     * constructeur
     *
     * @param dx position selon x
     * @param dy position selon y
     */
    public Monstre(int dx, int dy) {
        this.x = dx;
        this.y = dy;
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

    public boolean subirAttaque(Monstre m, Perso p){
        if(p.attaquer(m)) {
            this.pv--;
            return true;
        }
        return false;
    }

    public boolean etreMort(){
        if(this.pv == 0){
            return true;
        }
        return false;
    }
}
