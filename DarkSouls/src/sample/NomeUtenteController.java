package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class NomeUtenteController implements Initializable {

    private static Stage window;
    public static String nomeDelPersonaggio;

    @FXML     private Label label;

    @FXML    private TextField nomeUtente;
    @FXML    private Button nomeUtenteButton;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {    }

    public void utenteLogin(ActionEvent event) {
        String insertName = nomeUtente.getText();
        if(insertName.isEmpty())
            insertName = "viaggiatore";
        nomeDelPersonaggio = insertName;
        window.close();
    }

    public static String getNomeDelPersonaggio(){
        return nomeDelPersonaggio;
    }

    public static void display() throws IOException{
        window = new Stage();
        try {
            Parent root3 = FXMLLoader.load(NomeUtenteController.class.getResource("NomeUtente.fxml"));
            window.initModality(Modality.APPLICATION_MODAL);
            window.setTitle("Inserisci il tuo nome Viaggiatore");

            Scene scene = new Scene(root3);
            window.setScene(scene);
            window.showAndWait();

        }catch(IOException e){}
    }

    public void written(KeyEvent event) {
        nomeUtenteButton.setDisable(false);
    }
}
