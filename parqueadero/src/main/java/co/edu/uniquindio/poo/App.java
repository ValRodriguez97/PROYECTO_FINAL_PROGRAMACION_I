package co.edu.uniquindio.poo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Hello world!
 *
 */
public class App extends Application {
    public void start (Stage mystage){
        StackPane root = new StackPane();

        Text text = new Text ("Hello");
        text.setFont(Font.font("Arial", 12));
        text.setTranslateX(text.getTranslateX() +50);

        root.getChildren().add(text);

        Scene scene = new Scene(root, 320, 240);
        mystage.setScene(scene);
        mystage.setTitle("HI");
        mystage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}