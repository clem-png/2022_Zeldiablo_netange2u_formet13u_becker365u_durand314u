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


        for (int i = 0; i < laby.getLaby().getLength(); i++) {
            for (int j = 0; j < laby.getLaby().getLengthY(); j++) {
                if (laby.getLaby().getMur(i, j)) {
                    gc.setFill(Color.BLACK);
                    gc.fillRect(i * 50, j * 50, 50, 50);

                } else if (laby.getLaby().monstres != null) {
                    for (int k = 0; k < laby.getLaby().monstres.size(); k++) {
                        if (laby.getLaby().monstres.get(k).etrePresent(i, j)) {
                            gc.setFill(Color.GREEN);
                            gc.fillOval(i * 50, j * 50, 50, 50);
                        }
                    }
                } else if (laby.getLaby().portes != null) {
                    for (int k = 0; k < laby.getLaby().portes.size(); k++) {
                        if (laby.getLaby().portes.get(k).etrePresent(i, j)) {
                            gc.setFill(Color.BLUE);
                            gc.fillRect(i * 50, j * 50, 50, 50);
                        }
                    }
                }
            }
        }

        // Dessin du joueur
        gc.setFill(Color.RED);
        gc.fillOval(laby.getLaby().pj.x * 50, laby.getLaby().pj.y * 50, 50, 50);
    }
}
