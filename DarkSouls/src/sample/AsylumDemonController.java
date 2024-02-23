package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class AsylumDemonController implements Initializable {

    @FXML    public ImageView youDefeated;
    @FXML    private Label label;
    @FXML    public ProgressBar vitaPersonaggio;
    @FXML    public ProgressBar vitaBoss;
    @FXML    public Button fightButton;
    @FXML    public Button schiva;
    @FXML    public Button fendente;
    @FXML    public VBox virtualBox;
    @FXML    public Rectangle rectangle;
    @FXML    public Label yourName;


    private int counter = 0;
    final int MAX_RIGHE = 15;
    private int dannoInflitto;
    private int dannoSubito;
    private boolean fortunello;

    public Boss b = new Boss("Asylum Demon", 70, 400);
    protected Character c = NewGameController.getCharacter();

    public void beginFight(ActionEvent event) {
        if(counter>=MAX_RIGHE) {
            virtualBox.getChildren().clear();
            counter = 0;
        }
        fightButton.setVisible(false);
        yourName.setText(c.getName());
        yourName.setVisible(true);
        rectangle.setVisible(true);
        fendente.setDisable(false);
        schiva.setDisable(false);
        schiva.setVisible(true);
        fendente.setVisible(true);
        vitaPersonaggio.setVisible(true);
        dannoInflitto = c.attaccoInflitto();
        dannoSubito = c.dannoRicevuto(b.bossAttack(b.getDamage()));
        Text t = new Text(b.getName() + " ti attacca!    Come rispondi?");
        t.setFont(Font.font("Baskerville Old Face", FontWeight.BOLD, FontPosture.REGULAR, 14));
        virtualBox.getChildren().add(t); counter++;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {    }

    public void setMossaFendente(ActionEvent event) { mossaGiocatore(1); }

    public void setMossaSchiva(ActionEvent event) { mossaGiocatore(2); }

    public void seiMortoPollo() throws IOException {
        try{
            YouDiedController.display();
        }catch(IOException e){}
        try {
            Parent root2 = FXMLLoader.load(getClass().getResource("Menu.fxml"));
            Main.setWindowScene(new Scene(root2));
        } catch(IOException e){}
    }

    public void ciSeiRiuscito() throws IOException{
    try{
        YouDefeatedController.display();
    }catch (IOException exccc){}
}

    public void mossaGiocatore(int mossa) {
        if(counter>=MAX_RIGHE) {
            virtualBox.getChildren().clear();
            counter = 0;
        }
        fendente.setDisable(true);
        schiva.setDisable(true);
        dannoInflitto = c.attaccoInflitto();
        dannoSubito = c.dannoRicevuto(b.bossAttack(b.getDamage()));
        fortunello = c.buonFine();
        Text t;
        if (mossa == 1) {
            t = new Text(b.getName() + "ti infligge: " + dannoSubito + "\n tu gli infliggi: " + dannoInflitto);
            t.setFont(Font.font("Baskerville Old Face", FontWeight.BOLD, FontPosture.REGULAR, 14));
            virtualBox.getChildren().add(t); counter++;
            c.infliggiDannoRicevuto((dannoSubito));
            b.infliggiDannoRicevuto(dannoInflitto);
            vitaBoss.setProgress(b.healthBar());
            vitaPersonaggio.setProgress(c.healthBar());
        } else {
            if (mossa == 2) {
                if (fortunello) {
                    t = new Text("hai schivato con successo l'attacco!");
                    t.setFont(Font.font("Baskerville Old Face", FontWeight.BOLD, FontPosture.REGULAR, 14));
                    virtualBox.getChildren().add(t); counter++;
                    if (dannoSubito > b.getDamage() / 2) {
                        t = new Text("riesci a colpire il mostro!");
                        t.setFont(Font.font("Baskerville Old Face", FontWeight.BOLD, FontPosture.REGULAR, 14));
                        virtualBox.getChildren().add(t); counter++;
                        t = new Text("gli infliggi: " + dannoInflitto);
                        t.setFont(Font.font("Baskerville Old Face", FontWeight.BOLD, FontPosture.REGULAR, 14));
                        virtualBox.getChildren().add(t); counter++;
                        b.infliggiDannoRicevuto(dannoInflitto);
                        vitaBoss.setProgress(b.healthBar());
                    } else{
                        t = new Text("Peccato! Il Demone riesce a schivare il tuo attacco");
                        t.setFont(Font.font("Baskerville Old Face", FontWeight.BOLD, FontPosture.REGULAR, 14));
                        virtualBox.getChildren().add(t); counter++;
                    }
                } else {
                    t = new Text("oh no! sei inciampato e non sei riuscito a schivare!");
                    t.setFont(Font.font("Baskerville Old Face", FontWeight.BOLD, FontPosture.REGULAR, 14));
                    virtualBox.getChildren().add(t); counter++;
                    t = new Text(b.getName() + "ti infligge: " + dannoSubito);
                    t.setFont(Font.font("Baskerville Old Face", FontWeight.BOLD, FontPosture.REGULAR, 14));
                    virtualBox.getChildren().add(t); counter++;
                    c.infliggiDannoRicevuto(dannoSubito);
                    vitaPersonaggio.setProgress(c.healthBar());
                }
            }
        }
        if(b.isDead()){
            c.setPunteggio(2000);
            try{ ciSeiRiuscito();} catch (IOException exnn){}
        } else
            if(c.isDead())
                try {seiMortoPollo();}catch(IOException exc){}
            else
                fightButton.setVisible(true);
    }
}
