import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import mayflower.Actor;

import mayflower.Mayflower;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import mayflower.World;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class InputManagerClass extends Actor {
    private Mayflower mayflower;
    private Map<Integer,String> keys;



    static String Player1Movement;
    static String Player2Movement;
    static String Player3Movement;
    static String Player4Movement;



    public void act()
    {
        keys.put(12, new Action(2,"up"));

     //   Set<Integer> setOfKeys = keys.keySet();
        for (Integer key : keys.keySet()){
            //iterate over key
            if(mayflower.wasKeyDown(key))
            {
                String action = keys.get(key);
                String Player Number action.substring(0,1);
            }
        }
        //mayflower.wasKeyDown();
    }


}


