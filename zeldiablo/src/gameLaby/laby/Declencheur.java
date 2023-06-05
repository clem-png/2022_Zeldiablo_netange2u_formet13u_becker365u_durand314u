package gameLaby.laby;

public class Declencheur extends Entite {
    private int x, y;
    private boolean active;

    public Declencheur (int x, int y){
        super(x,y);
        this.active = false;
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
