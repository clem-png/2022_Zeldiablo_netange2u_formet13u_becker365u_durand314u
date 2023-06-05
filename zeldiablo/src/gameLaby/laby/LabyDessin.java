package gameLaby.laby;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import moteurJeu.DessinJeu;
import moteurJeu.Jeu;

import java.io.File;
import java.net.MalformedURLException;

/**
 * Classe LabyDessin
 */
public class LabyDessin implements DessinJeu {

    private static final int SIZE = 20;

    private Image perso;
    private Image mur;
    private Image monstre;
    private Image monstreAttaquer;
    private Image amulette;
    private Image interrupteur;

    private Image entree;

    /**
     * Constructeur LabyDessin qui, permet d'implementer les sprite du jeu
     */
    public LabyDessin (){
        try {
            String imagePath = "src/gameLaby/Sprite/Link.png";
            File file = new File(imagePath);
            String imageUrl = file.toURI().toURL().toString();
            this.perso = new Image(imageUrl);

            imagePath = "src/gameLaby/Sprite/mur.png";
            file = new File(imagePath);
            imageUrl = file.toURI().toURL().toString();
            this.mur = new Image(imageUrl);

            imagePath = "src/gameLaby/Sprite/interrupteur.png";
            file = new File(imagePath);
            imageUrl = file.toURI().toURL().toString();
            this.interrupteur = new Image(imageUrl);

            imagePath = "src/gameLaby/Sprite/sanic.png";
            file = new File(imagePath);
            imageUrl = file.toURI().toURL().toString();
            this.monstre = new Image(imageUrl);

            imagePath = "src/gameLaby/Sprite/sanicAttaquer.png";
            file = new File(imagePath);
            imageUrl = file.toURI().toURL().toString();
            this.monstreAttaquer = new Image(imageUrl);

            imagePath = "src/gameLaby/Sprite/amulette.png";
            file = new File(imagePath);
            imageUrl = file.toURI().toURL().toString();
            this.amulette = new Image(imageUrl);

            imagePath = "src/gameLaby/Sprite/entree.png";
            file = new File(imagePath);
            imageUrl = file.toURI().toURL().toString();
            this.entree = new Image(imageUrl);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Methode dessinerJeu qui, permet de créer l"interface graphique en fonction du caractère présent
     * à la position (i, j) du labyrinthe
     * @param jeu jeu a afficher
     * @param canvas canvas dans lequel dessiner l'etat du jeu
     */
    @Override
    public void dessinerJeu(Jeu jeu, Canvas canvas) {
        LabyJeu laby = (LabyJeu) jeu;

        // recupere un pinceau pour dessiner
        final GraphicsContext gc = canvas.getGraphicsContext2D();

        // dessin fond
        gc.setFill(Color.LIGHTGRAY);
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());

        //dessin des murs
        for (int i = 0; i < laby.getLaby().getLength(); i++) {
            for (int j = 0; j < laby.getLaby().getLengthY(); j++) {
                if (laby.getLaby().getMur(i, j)) {
                    gc.drawImage(this.mur, i * SIZE, j * SIZE, SIZE, SIZE);

                //dessin des monstres en fonction des actions réalisées
                } else if (laby.getLaby().monstres != null) {
                    for (int k = 0; k < laby.getLaby().monstres.size(); k++) {
                        if (laby.getLaby().monstres.get(k).etrePresent(i, j)) {
                            if (laby.getLaby().monstres.get(k).subirattaque) {
                                gc.drawImage(this.monstreAttaquer, i * SIZE, j * SIZE, SIZE, SIZE);
                                laby.getLaby().monstres.get(k).subirattaque = false;
                            } else {
                                gc.drawImage(this.monstre, i * SIZE, j * SIZE, SIZE, SIZE);
                            }
                        }
                    }

                    //dessin des portes
                    if (laby.getLaby().portes != null) {
                        for (int k = 0; k < laby.getLaby().portes.size(); k++) {
                            if (laby.getLaby().portes.get(k).etrePresent(i, j) && !laby.getLaby().portes.get(k).getDeclencheur().getActive()) {
                                gc.drawImage(this.mur, i * SIZE, j * SIZE, SIZE, SIZE);
                            }

                        }

                        //dessin des interrupteurs
                        if (laby.getLaby().Trigger != null) {
                            for (int k = 0; k < laby.getLaby().Trigger.size(); k++) {
                                if (laby.getLaby().Trigger.get(k).etrePresent(i, j)) {
                                    gc.drawImage(this.interrupteur, i * SIZE, j * SIZE, SIZE, SIZE);
                                }
                            }
                        }
                        if (laby.getLaby().amulette != null){
                            if (laby.getLaby().amulette.etrePresent(i , j) && laby.getLaby().amulette.apparue ) {
                                    gc.drawImage(this.amulette, i * SIZE, j * SIZE, SIZE, SIZE);
                                }
                        }
                    }
                }


                gc.drawImage(this.entree, laby.getLaby().entree.getX() * SIZE, laby.getLaby().entree.getY() * SIZE, SIZE, SIZE);
                // Dessin du joueur avec une image
                gc.drawImage(this.perso, laby.getLaby().pj.x * SIZE, laby.getLaby().pj.y * SIZE, SIZE, SIZE);
            }
        }
    }
}