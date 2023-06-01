package gameLaby.laby;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;

public class Menu extends Application {

    String chemin = "labySimple";

    public static File[] listeFichiers(String chemin) {
        File repertoire = new File(chemin);

        // Vérification de l'existence du répertoire
        if (!repertoire.exists() || !repertoire.isDirectory()) {
            System.out.println("Le répertoire n'existe pas.");
            return null;
        }

        return repertoire.listFiles();
    }


    @Override
    public void start(Stage stage) {

        BorderPane pane = new BorderPane();
        VBox vbox = new VBox(10);
        vbox.setAlignment(Pos.CENTER);

        Text titre = new Text();
        titre.setText("Choisisez un niveau");
        titre.setFont(Font.font("comic Sans MS", FontWeight.BOLD, FontPosture.REGULAR, 50));

        File[] tab = listeFichiers(chemin);

        if (tab != null) {
            for (int i = 0; i < tab.length; i++) {
                Button b = new Button();
                b.setMinSize(80, 50);
                b.setText(tab[i].getName());
                vbox.getChildren().addAll(b);
            }
        }
        pane.setTop(titre);
        pane.setCenter(vbox);
    }
}
