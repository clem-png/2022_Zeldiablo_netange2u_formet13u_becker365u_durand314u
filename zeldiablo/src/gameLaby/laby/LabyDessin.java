package gameLaby.laby;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import moteurJeu.DessinJeu;
import moteurJeu.Jeu;

import java.util.ArrayList;

public class LabyDessin implements DessinJeu {

    private static final int SIZE = 20;

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
                    gc.fillRect(i * SIZE, j * SIZE, SIZE, SIZE);

                } else if (laby.getLaby().monstres != null) {
                    for (int k = 0; k < laby.getLaby().monstres.size(); k++) {
                     /*   while (!laby.getLaby().monstres.get(k).etreMort()) {*/
                            if (laby.getLaby().monstres.get(k).etrePresent(i, j)) {
                            /*    if (!laby.getLaby().monstres.get(k).subirAttaque()) {*/
                                    gc.setFill(Color.GREEN);
                            /*    } else {
                                    gc.setFill(Color.BLUE);*/
                                }
                                gc.fillOval(i * SIZE, j * SIZE, SIZE, SIZE);
                           /* }
                        }*/
                    }
                }

                if (laby.getLaby().portes != null) {
                    for (int k = 0; k < laby.getLaby().portes.size(); k++) {
                        if (laby.getLaby().portes.get(k).etrePresent(i, j) && !laby.getLaby().portes.get(k).getDeclencheur().getActive()) {
                            gc.setFill(Color.BLACK);
                            gc.fillRect(i * SIZE, j * SIZE, SIZE, SIZE);
                        }

                    }
                    if (laby.getLaby().Trigger != null) {
                        for (int k = 0; k < laby.getLaby().Trigger.size(); k++) {
                            if (laby.getLaby().Trigger.get(k).etrePresent(i, j)) {
                                gc.setFill(Color.YELLOW);
                                gc.fillRect(i * SIZE, j * SIZE, SIZE, SIZE);
                            }
                        }
                    }
                }
            }

            // Dessin du joueur
            gc.setFill(Color.RED);
            gc.fillOval(laby.getLaby().pj.x * SIZE, laby.getLaby().pj.y * SIZE, SIZE, SIZE);
        }
    }
}
