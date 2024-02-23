package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class YouDefeatedController implements Initializable {

    @FXML    private Label label;
    private static Stage window;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public static void display() throws IOException {
        window = new Stage();
        try {
            Parent root3 = FXMLLoader.load(NomeUtenteController.class.getResource("YouDefeated.fxml"));
            window.initModality(Modality.APPLICATION_MODAL);
            window.setTitle("Ce l'hai fatta!");

            Scene scene = new Scene(root3);
            window.setScene(scene);
            window.showAndWait();

        }catch(IOException e){}
    }

    public void salvaThanBackToMenu(ActionEvent event) throws IOException{
        window.close();
        try {
            Classifica.scriviRisultato(NewGameController.getCharacter());
            Parent root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
            Main.setWindowScene(new Scene(root));
        } catch (IOException inpOutEx){}

    }

    public void avanti(ActionEvent event) throws IOException{
        window.close();
        try{
            Parent root89 = FXMLLoader.load(getClass().getResource("Falò.fxml"));
            Main.setWindowScene(new Scene(root89));
        } catch (IOException emnm){}
    }
}
