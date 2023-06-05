package gameLaby.laby;

public class Entree {

    private int x, y;

    boolean etreActive;

    /**
     * Constructeur qui construit un entree en position x, y
     * @param x
     * @param y
     */
    public Entree(int x, int y) {
        this.x = x;
        this.y = y;
        this.etreActive = false;
    }

    /**
     * Methode qui verifie si l'entreee est presente sur la position x, y
     * @param dx position x de l'entree
     * @param dy position y de l'entree
     * @return true ou false
     */
    public boolean etrePresent(int dx, int dy) {
        return (this.x == dx && this.y == dy);
    }

    /**
     * @return position x du déclencheur
     */
    public int getX() {
        // getter
        return this.x;
    }

    /**
     * @return position y du déclencheur
     */
    public int getY() {
        //getter
        return this.y;
    }

    /**
     * Method qui permet d'activer l'entrer
     */
    public void activer(){
        this.etreActive = true;
    }

    /**
     * Methode qui permet de savoir si la porte est activé
     * @return true ou false
     */
    public boolean etreActive(){
        return this.etreActive;
    }
}
