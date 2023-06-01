package gameLaby.laby;

public class Declencheur {
    private int x, y;
    private boolean active;

    public Declencheur (int x, int y){
        this.x = x ;
        this.y = y ;
        this.active = false;
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

    /**
     * @return état du déclencheur
     */
    public boolean getActive(){
        //getter
        return active;
    }

    public void setActive(){
        this.active = true;
    }

}
