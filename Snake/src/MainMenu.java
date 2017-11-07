import javafx.application.Application;
import javafx.fxml.FXMLLoader;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainMenu extends Application{
   @Override
    public void start(Stage stage) throws Exception
    {
        //http://www.oracle.com/technetwork/java/javafxscenebuilder-1x-archive-2199384.html
        Parent root = FXMLLoader.load(getClass().getResource("test.fxml"));

        Scene scene = new Scene(root, 300, 275);

        stage.setTitle("Snake");
        stage.setScene(scene);
        stage.show();
    }
}
