import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import mayflower.Mayflower;

import java.io.IOException;

public class localController {
    private MyWorld world;
    @FXML
    public Button Exit;

    @FXML
    public void initialize() {

    }
    @FXML
    public void singlePlayer()
    {

        new Mayflower("Snake", 800, 600) {
            @Override
            public void init() {
                setWorld(new MyWorld());
                //showBounds(true);

            }
        };
    }
    @FXML
    public void localMulti()
    {

        new Mayflower("Snake", 800, 600) {
            @Override
            public void init() {
                setWorld(new LocalMultiplayer(1));
                //showBounds(true);

            }
        };
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

}
