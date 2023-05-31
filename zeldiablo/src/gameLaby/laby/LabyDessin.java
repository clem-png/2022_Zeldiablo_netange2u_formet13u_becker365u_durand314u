package gameLaby.laby;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import moteurJeu.DessinJeu;
import moteurJeu.Jeu;

import java.io.IOException;

public class LabyDessin implements DessinJeu {
    @Override
    public void dessinerJeu(Jeu jeu, Canvas canvas) {
        LabyJeu laby = new LabyJeu();

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
                    gc.fillRect(i * 50, j * 50, 50, 50);
                }
            }
        }

        // Dessin du joueur
        gc.setFill(Color.RED);
        gc.fillOval(laby.getLaby().pj.x * 50, laby.getLaby().pj.y * 50, 50, 50);
    }
}