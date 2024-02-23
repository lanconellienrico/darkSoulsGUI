package sample;

import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.*;
import java.util.*;


public class Classifica {

    public static void display() throws FileNotFoundException {
        Stage window = new Stage();
        VBox layout = new VBox();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Classifica");
        window.setWidth(750);
        window.setHeight(422);
        try{
            Scanner scan = new Scanner(new File("C:/Users/lanco/IdeaProjects/DarkSouls/src/files/Classifica.txt"));
            while(scan.hasNextLine()){
                layout.getChildren().add(new Text(scan.nextLine()));
            }
        }catch(FileNotFoundException e){}

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
    }

    public static void scriviRisultato(Character c) throws IOException {
        try {
            FileWriter flwrt = new FileWriter("C:/Users/lanco/IdeaProjects/DarkSouls/src/files/Classifica.txt", true);
            PrintWriter writer = new PrintWriter(flwrt);
            writer.print("\n" + c);
            flwrt.close();
        }catch (IOException excep){}
    }

}
