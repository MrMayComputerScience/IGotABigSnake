import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class themeSelectController {



    @FXML private ToggleButton oneTheme, twoTheme, threeTheme, fourTheme;



    //@FXML private localController local;

    @FXML
    private GridPane rootPane;
    @FXML private int theme;


    @FXML
    public void themeOne(ActionEvent event) throws IOException
    {
        twoTheme.setSelected(false);
        threeTheme.setSelected(false);
        fourTheme.setSelected(false);
        theme =1;
    }
    @FXML
    public void themeTwo(ActionEvent event) throws IOException
    {
        oneTheme.setSelected(false);
        threeTheme.setSelected(false);
        fourTheme.setSelected(false);
        theme =2;
    }
    @FXML
    public void themeThree(ActionEvent event) throws IOException
    {
        oneTheme.setSelected(false);
        twoTheme.setSelected(false);
        fourTheme.setSelected(false);
        theme =3;
    }
    @FXML

    public void fourThree(ActionEvent event) throws IOException
    {
        oneTheme.setSelected(false);
        twoTheme.setSelected(false);
        threeTheme.setSelected(false);
        theme =4;
    }
    @FXML
    public void next(ActionEvent event) throws IOException
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("local.fxml"));
        try{
            loader.load();
        } catch (IOException ex)
        {
            Logger.getLogger(localController.class.getName()).log(Level.SEVERE, null, ex);

        }
        localController local = loader.getController();
        local.setTheme(theme);



        Parent p = loader.getRoot();
        rootPane.getChildren().setAll(p);
    }



}
