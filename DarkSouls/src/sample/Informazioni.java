package sample;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Informazioni {

    public static void display() throws FileNotFoundException {
        Stage window = new Stage();
        VBox layout = new VBox();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Informazioni");
        window.setWidth(750);
        window.setHeight(422);
        List<String> info = new ArrayList<>();
        try{
            Scanner scan = new Scanner(new File("C:/Users/lanco/IdeaProjects/DarkSouls/src/files/Informazioni.txt"));
            while(scan.hasNextLine()){
                layout.getChildren().add(new Text(scan.nextLine()));
            }
        }catch(FileNotFoundException e){}

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
    }

}


