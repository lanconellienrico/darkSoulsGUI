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

public class FalòController implements Initializable {

    @FXML public Label lavori;
    @FXML private Label label;




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void tornaMenu(ActionEvent event) throws IOException {
        try{
            Parent root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
            Main.setWindowScene(new Scene(root));
        } catch (IOException ioex){}

    }

    public void nonDisp(ActionEvent event) {
        lavori.setVisible(true);
    }
}
