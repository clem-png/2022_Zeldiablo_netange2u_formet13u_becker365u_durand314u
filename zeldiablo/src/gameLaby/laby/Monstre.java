package gameLaby.laby;

public class Monstre extends Entite {

    /**
     * position du personnage
     */
    int pv;

    boolean subirattaque ;
    boolean mort;


    /**
     * constructeur
     *
     * @param dx position selon x
     * @param dy position selon y
     */
    public Monstre(int dx, int dy) {
        super(dx, dy);
        this.subirattaque = false ;
        this.mort = false ;
        this.pv = 2 ;
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
