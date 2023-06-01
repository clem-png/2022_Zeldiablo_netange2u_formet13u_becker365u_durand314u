package gameLaby.laby;

public interface Entite {
    /**
     * constructeur
     *
     * @param dx position selon x
     * @param dy position selon y
     */
    public boolean etrePresent(int dx, int dy);

    public int getX();
    public int getY();
}
