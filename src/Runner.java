
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import mayflower.Mayflower;
import mayflower.World;

public class Runner extends Application{

    private Head head;
    @Override
    public void start(Stage stage) throws Exception
    {

        //http://www.oracle.com/technetwork/java/javafxscenebuilder-1x-archive-2199384.html
        Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
        Scene scene = new Scene(root, 600, 400);
        stage.setTitle("Snake");
        stage.setScene(scene);
        stage.show();


    }

}
