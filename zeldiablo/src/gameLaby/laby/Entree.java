package gameLaby.laby;

public class Entree extends Entite{

    boolean etreActive;

    /**
     * Constructeur qui construit un entree en position x, y
     * @param x
     * @param y
     */
    public Entree(int x, int y) {
        super(x, y);
        this.etreActive = false;
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
