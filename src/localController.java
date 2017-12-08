import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import mayflower.Keyboard;
import mayflower.Mayflower;

import java.io.IOException;

public class localController {

    private MyWorld world;
    @FXML private Button Exit;

    @FXML private  ToggleButton one;
    @FXML private   TextField oneup;
    @FXML private   TextField onedown;
    @FXML private   TextField oneleft;
    @FXML private  TextField oneright;

    @FXML private  ToggleButton two;
    @FXML private  TextField twoup;
    @FXML private  TextField twodown;
    @FXML private  TextField twoleft;
    @FXML private  TextField tworight;

    @FXML private  ToggleButton three;
    @FXML private  TextField threeup;
    @FXML private  TextField threedown;
    @FXML private  TextField threeleft;
    @FXML private  TextField threeright;

    @FXML private  ToggleButton four;
    @FXML private  TextField fourup;
    @FXML private  TextField fourdown;
    @FXML private  TextField fourleft;
    @FXML private  TextField fourright;

    @FXML
    private GridPane localPane;



    @FXML
    public void initialize() {

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
    //@FXML
    public void continueBtn(ActionEvent event) throws IOException
    {
        GridPane pane = FXMLLoader.load(getClass().getResource("localSelect.fxml"));
        localPane.getChildren().setAll(pane);


    }

    public  void one(ActionEvent event) throws IOException
    {
      if (one.isSelected())
      {

          oneup.setVisible(true);
          onedown.setVisible(true);
          oneleft.setVisible(true);
          oneright.setVisible(true);

      }
      else
      {
          oneup.setVisible(false);
          onedown.setVisible(false);
          oneleft.setVisible(false);
          oneright.setVisible(false);
      }

    }

    public void two(ActionEvent event) throws IOException
    {
        if (two.isSelected())
        {
            twoup.setVisible(true);
            twodown.setVisible(true);
            twoleft.setVisible(true);
            tworight.setVisible(true);

        }
        else
        {
            twoup.setVisible(false);
            twodown.setVisible(false);
            twoleft.setVisible(false);
            tworight.setVisible(false);
        }

    }
    public void three(ActionEvent event) throws IOException
    {
        if (three.isSelected())
        {
            threeup.setVisible(true);
            threedown.setVisible(true);
            threeleft.setVisible(true);
            threeright.setVisible(true);

        }
        else
        {
            threeup.setVisible(false);
            threedown.setVisible(false);
            threeleft.setVisible(false);
            threeright.setVisible(false);
        }

    }
    public void four(ActionEvent event) throws IOException
    {
        if (four.isSelected())
        {
            fourup.setVisible(true);
            fourdown.setVisible(true);
            fourleft.setVisible(true);
            fourright.setVisible(true);

        }
        else
        {
            fourup.setVisible(false);
            fourdown.setVisible(false);
            fourleft.setVisible(false);
            fourright.setVisible(false);
        }

    }
    /*public static int getPlayers()
    {
        int players=0;
        //if(one.isSelected())players++;
        if(two.isSelected())players++;
        if(three.isSelected())players++;
        if(four.isSelected())players++;

        return players;


    }
    public static String getKeys(int player)
    {
        //if(player==1)
            //return oneup.getText()+onedown.getText()+onedown.getText()+oneright.getText();
        if(player==2)
            return twoup.getText()+twodown.getText()+twodown.getText()+tworight.getText();
        if(player==3)
            return threeup.getText()+threedown.getText()+threedown.getText()+threeright.getText();
        if(player==4)
            return fourup.getText()+fourdown.getText()+fourdown.getText()+fourright.getText();
        return "";
    }
*/
}
