package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SchermataStoriaInizioController implements Initializable {

    @FXML
    private Label label;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void startGame(ActionEvent event) throws Exception {
        try {
            Parent root5 = FXMLLoader.load(getClass().getResource("AsylumDemon.fxml"));
            Main.setWindowScene(new Scene(root5));
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
