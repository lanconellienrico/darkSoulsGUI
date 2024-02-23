package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.IOException;

public class Main extends Application {

    public static Stage window;

    public static void setWindowScene(Scene s){
        window.setScene(s);
    }

    public static void main(String[] args) { launch(args); }

    @Override
    public void start(Stage stage) throws Exception {
        window = stage;
        Parent root0 = FXMLLoader.load(getClass().getResource("FirstScreen.fxml"));
        Scene scene0 = new Scene(root0);
        window.setScene(scene0);
        window.setTitle("GUI Dark Souls");
        window.show();

        scene0.addEventFilter(KeyEvent.KEY_PRESSED, new EventHandler<>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                try {
                    Parent root1 = FXMLLoader.load(getClass().getResource("Menu.fxml"));
                    Scene scene1 = new Scene(root1);
                    window.setScene(scene1);
                } catch (IOException ioExc){
                    System.out.println(ioExc.getMessage());
                }

            }
        });
    }

    public static void youDied(){
        window = new Stage();
        try {
            Parent root = FXMLLoader.load(NomeUtenteController.class.getResource("YouDied.fxml"));
            window.initModality(Modality.APPLICATION_MODAL);
            window.setTitle("YOU DIED");
            Scene scene = new Scene(root);
            window.setScene(scene);
            window.showAndWait();
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

    public static void youWin(){
        window = new Stage();
        try {
            Parent root = FXMLLoader.load(NomeUtenteController.class.getResource("YouWin.fxml"));
            window.initModality(Modality.APPLICATION_MODAL);
            window.setTitle("SUCCESS");
            Scene scene = new Scene(root);
            window.setScene(scene);
            window.showAndWait();
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

    public static void youDefeated() {
        window = new Stage();
        try {
            Parent root = FXMLLoader.load(NomeUtenteController.class.getResource("YouDefeated.fxml"));
            window.initModality(Modality.APPLICATION_MODAL);
            window.setTitle("YOU DEFEATED!");
            Scene scene = new Scene(root);
            window.setScene(scene);
            window.showAndWait();
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
    
}

