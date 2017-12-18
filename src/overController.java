import javafx.collections.ObservableSet;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import mayflower.Mayflower;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class overController {

    //private MyWorld world;
   // @FXML private Button Exit;


private Mayflower main;

    @FXML
    public Button Exit;

    @FXML
    public Button save;
    @FXML private GridPane Over;

    @FXML public Button again;




    @FXML
    public void again() throws IOException
    {



    }
    @FXML
    public void close(ActionEvent event) throws IOException
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
    public void setMain(Mayflower main) throws IOException
    {
        this.main = main;
    }



}
