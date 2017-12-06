import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.stage.Stage;
import mayflower.Mayflower;

import java.io.IOException;

public class localSelectController {

    private MyWorld world;
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



    @FXML
    public void initialize() {

    }

    @FXML
    public void localMulti(ActionEvent event) throws IOException
    {

        new Mayflower("Snake", 800, 600) {
            @Override
            public void init() {
                setWorld(new LocalMultiplayer(4));
                //showBounds(true);

            }
        };
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

}
