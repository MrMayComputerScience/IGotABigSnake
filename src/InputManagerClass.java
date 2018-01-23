import mayflower.Actor;

import mayflower.Mayflower;

import java.util.List;
import java.util.Map;

public class InputManagerClass extends Actor {
    private Mayflower mayflower;
    private Map<Integer, Action> keys;



    static String Player1Movement;
    static String Player2Movement;
    static String Player3Movement;
    static String Player4Movement;

    private Snake snake1;
    private Snake snake2;
    private Snake snake3;
    private Snake snake4;
    private List<Snake> snakeList;

    public InputManagerClass(List<Snake> snakeList){
        this.snakeList = snakeList;
        if(snakeList.get(0)!=null)
        snake4 = snakeList.get(0);
        if(snakeList.get(1)!=null)
        snake3 = snakeList.get(1);
        if(snakeList.get(2)!=null)
        snake2 = snakeList.get(2);
        if(snakeList.get(3)!=null)
        snake1 = snakeList.get(3);

    }


    public void act()
    {
        keys.put(12, new Action(2,"up"));

     //   Set<Integer> setOfKeys = keys.keySet();
        for (Integer key : keys.keySet()){
            //iterate over key
            if(mayflower.wasKeyDown(key))
            {
                Action action = keys.get(key);
                if(action.getPlayer()==1)
                {
                    new SnakeManager(snake1, action.getAction());
                }

                if(action.getPlayer()==2)
                {
                    new SnakeManager(snake2, action.getAction());
                }

                if(action.getPlayer()==3)
                {
                    new SnakeManager(snake3, action.getAction());
                }

                if(action.getPlayer()==4)
                {
                    new SnakeManager(snake4, action.getAction());
                }




            }
        }
        //mayflower.wasKeyDown();
    }


}


