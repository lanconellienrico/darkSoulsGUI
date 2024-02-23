package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class YouDiedController implements Initializable {
    @FXML private Label label;
    private static Stage window;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }


    public void stampaClassifica(ActionEvent event) throws IOException{
        Classifica.scriviRisultato(NewGameController.getCharacter());
        System.out.println("Registrato con successo");
    }

    public static void display() throws IOException{
        window = new Stage();
        try {
            Parent root = FXMLLoader.load(NomeUtenteController.class.getResource("YouDied.fxml"));
            window.initModality(Modality.APPLICATION_MODAL);
            window.setTitle("Sei morto!");

            Scene scene = new Scene(root);
            window.setScene(scene);
            window.showAndWait();

        }catch(IOException e){}
    }

    public void backToMenu(ActionEvent event) throws IOException {
        window.close();
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
            Main.setWindowScene(new Scene(root));
        } catch (IOException inpOutEx){}
    }
}
