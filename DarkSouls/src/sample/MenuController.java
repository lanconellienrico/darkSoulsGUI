package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MenuController implements Initializable {
    @FXML
    private Label label;

    public void newGame(ActionEvent event) throws IOException{
        try{
            NomeUtenteController.display();
        }catch(IOException e){}
        try {
            Parent root2 = FXMLLoader.load(getClass().getResource("NewGame.fxml"));
            Main.setWindowScene(new Scene(root2));
        } catch(IOException e){}
    }

    public void showRanking(ActionEvent event) throws FileNotFoundException{
        try{
            Classifica.display();
        }catch (FileNotFoundException e){}
    }

    public void showInfo(ActionEvent event) throws FileNotFoundException {
        try {
            Informazioni.display();
        } catch (FileNotFoundException e){}
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }


    public void exitFrom(ActionEvent event) {
        Main.window.close();
    }
}
