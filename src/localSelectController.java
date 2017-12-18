import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.stage.Stage;
import mayflower.Mayflower;
import mayflower.World;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class localSelectController{

    //private MyWorld world;
    @FXML private Button Exit;

    @FXML private static ToggleButton one;
    @FXML private static TextField oneup;
    @FXML private static TextField onedown;
    @FXML private static TextField oneleft;
    @FXML private static TextField oneright;

    @FXML private static ToggleButton two;
    @FXML private static TextField twoup;
    @FXML private static TextField twodown;
    @FXML private static TextField twoleft;
    @FXML private static TextField tworight;

    @FXML private static ToggleButton three;
    @FXML private static TextField threeup;
    @FXML private static TextField threedown;
    @FXML private static TextField threeleft;
    @FXML private static TextField threeright;

    @FXML private static ToggleButton four;
    @FXML private static TextField fourup;
    @FXML private static TextField fourdown;
    @FXML private static TextField fourleft;
    @FXML private static TextField fourright;

    @FXML private localController local;

    @FXML private boolean playerone, playertwo, playerthree, playerfour;

    @FXML private int players;
    @FXML private ToggleButton threeMice, twitch, portal;
    @FXML private String theme;

    private Mayflower main;



    @FXML
    public void portal(ActionEvent event) throws IOException
    {


    }

    @FXML
    public void localMulti(ActionEvent event) throws IOException
    {


        main = new Mayflower("Snake", 800, 600) {
            @Override
            public void init() {
               // System.out.println("running");
                setWorld(new LocalMultiplayerWorld(theme, portal.isSelected(), playerone,playertwo,playerthree,playerfour));
                //System.out.println("running2");
                //showBounds(true);

            }
        };
    }
    @FXML
    public void playTwitch(ActionEvent event) throws IOException
    {


        main =  new Mayflower("Snake", 800, 600) {
            @Override
            public void init() {
                //System.out.println("running");
                setWorld(new twitchWorld(theme, portal.isSelected(), playerone,playertwo,playerthree,playerfour));
                //System.out.println("running2");
                //showBounds(true);

            }
        };
    }
    @FXML
    public void playMice(ActionEvent event) throws IOException
    {





        main =  new Mayflower("Snake", 800, 600) {
            @Override
            public void init() {
                //System.out.println("running");
                setWorld(new miceWorld(theme, portal.isSelected(), playerone,playertwo,playerthree,playerfour));
                //System.out.println("running2");
                //showBounds(true);

            }
        };
    }
    @FXML
    public void playGrow(ActionEvent event) throws IOException
    {


        main = new Mayflower("Snake", 800, 600) {
            @Override
            public void init() {

                setWorld(new growWorld(theme, portal.isSelected(), playerone,playertwo,playerthree,playerfour));


            }
        };


        //main.setWorld(new growWorld(theme, portal.isSelected(), playerone,playertwo,playerthree,playerfour));
        //main.init();
    }

    @FXML
    public void backBtn(ActionEvent event) throws IOException
    {
        try {
            Stage stage = (Stage) Exit.getScene().getWindow();
            stage.close();
            Mayflower.exit();
        }
        catch(Exception E)
        {

        }

    }
    @FXML
    public void setPlayers(boolean one, boolean two, boolean three, boolean four) throws IOException
    {
        //players=0;

        this.playerone=one;
        this.playertwo=two;
        this.playerthree=three;
        this.playerfour=four;

        if(playerone)this.players++;
        if(playertwo)this.players++;
        if(playerthree)this.players++;
        if(playerfour)this.players++;

        if(this.players>1) {
            threeMice.setVisible(true);
            twitch.setVisible(true);
        }
        else
        {
            threeMice.setVisible(false);
            twitch.setVisible(false);
        }



    }
    @FXML
    public void setTheme(int theme) throws IOException
    {

        if(theme==1)this.theme =  "Theme1/";
        if(theme==2)this.theme =  "Theme2/";
        if(theme==3)this.theme =  "Theme3/";

        //this.theme = theme;


    }

}
