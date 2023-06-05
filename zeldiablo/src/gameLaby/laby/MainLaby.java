package gameLaby.laby;

import com.sun.javafx.application.PlatformImpl;
import moteurJeu.MoteurJeu;


public class MainLaby {
    public static void main(String[] args) {
        int width = 800;
        int height = 600;
        int pFPS = 10;

        PlatformImpl.startup(() -> {});
        LabyJeu labyjeu = new LabyJeu(args[0]);
        LabyDessin labydessin = new LabyDessin();

        MoteurJeu.setTaille(width,height);
        MoteurJeu.setFPS(pFPS);

        MoteurJeu.launch(labyjeu , labydessin);
    }
}
