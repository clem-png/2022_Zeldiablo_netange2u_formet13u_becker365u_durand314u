package gameLaby.laby;

import moteurJeu.MoteurJeu;


public class MainLaby {
    public static void main(String[] args) {
        int width = 800;
        int height = 600;
        int pFPS = 60;


        LabyJeu labyjeu = new LabyJeu(args[0]);
        LabyDessin labydessin = new LabyDessin();

        MoteurJeu.setTaille(width,height);
        MoteurJeu.setFPS(pFPS);

        MoteurJeu.launch(labyjeu , labydessin);
    }
}
