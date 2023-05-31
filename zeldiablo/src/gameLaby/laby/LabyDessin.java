package gameLaby.laby;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import moteurJeu.DessinJeu;
import moteurJeu.Jeu;

public class LabyDessin implements DessinJeu {
    @Override
    public void dessinerJeu(Jeu jeu, Canvas canvas) {
        LabyJeu laby = (LabyJeu) jeu;

        // recupere un pinceau pour dessiner
        final GraphicsContext gc = canvas.getGraphicsContext2D();

        // dessin fond
        gc.setFill(Color.LIGHTGRAY);
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());

        // dessin mur
        gc.setFill(Color.BLACK);

        for (int i = 0; i < laby.getLaby().getLength(); i++) {
            for (int j = 0; j < laby.getLaby().getLengthY(); j++) {
                if (laby.getLaby().getMur(i, j)) {
                    gc.fillRect(i * 20, j * 20, 20, 20);
                }
            }
        }

        // Dessin du joueur
        gc.setFill(Color.RED);
        gc.fillOval(laby.getLaby().pj.x * 20, laby.getLaby().pj.y * 20, 20, 20);

        // Dessin du monstre
        gc.setFill(Color.GREEN);
        gc.fillOval(laby.getLaby().monstre.x * 20, laby.getLaby().monstre.y * 20, 20, 20);
    }
}
