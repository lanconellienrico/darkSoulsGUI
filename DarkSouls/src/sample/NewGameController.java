package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;

public class NewGameController implements Initializable {

    @FXML private RadioButton viand;
    @FXML private RadioButton guerr;
    @FXML private RadioButton chier;
    @FXML private RadioButton discr;

    public static Character c;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public static Character getCharacter(){
        return c;
    }

    public static void setCharacter(Character ch){
        c = ch;
    }

    public void creaPersonaggio(ActionEvent event) throws Exception {
        if(viand.isSelected())
            c = new Viandante(NomeUtenteController.getNomeDelPersonaggio());
        if(guerr.isSelected())
            c = new Guerriero(NomeUtenteController.getNomeDelPersonaggio());
        if(chier.isSelected())
            c = new Chierico(NomeUtenteController.getNomeDelPersonaggio());
        if(discr.isSelected())
            c = new Discriminato(NomeUtenteController.getNomeDelPersonaggio());
        try{
            Parent root4 = FXMLLoader.load(getClass().getResource("SchermataStoriaInizio.fxml"));
            Main.setWindowScene(new Scene(root4));
        } catch(Exception e){}
    }
}
