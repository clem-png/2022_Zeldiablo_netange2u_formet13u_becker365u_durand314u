package gameLaby.laby;

public class Entree {

    private int x, y;

    boolean etreActive;

    public Entree(int x, int y) {
        this.x = x;
        this.y = y;
        this.etreActive = false;
    }

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

    public void activer(){
        this.etreActive = true;
    }

    public boolean etreActive(){
        return this.etreActive;
    }

}
