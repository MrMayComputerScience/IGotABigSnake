import mayflower.Actor;

import mayflower.Mayflower;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mayflower.Timer;
import mayflower.World;

public class InputManagerClass extends Actor {
    private Mayflower mayflower;
    private Map<Integer, Action> keys;
    private World world;


    static String Player1Movement;
    static String Player2Movement;
    static String Player3Movement;
    static String Player4Movement;



    static String gameMode;

    private Snake snake1;
    private Snake snake2;
    private Snake snake3;
    private Snake snake4;
    private String dirsnake1;
    private String dirsnake2;
    private String dirsnake3;
    private String dirsnake4;
    private List<Snake> snakeList;
    private Timer time;

    public InputManagerClass(List<Snake> snakeList, World world, String gameMode){
        keys = new HashMap<>();
        time = new Timer(75);
        this.snakeList = snakeList;
        if(snakeList.get(0)!=null)
        snake4 = snakeList.get(0);
        if(snakeList.get(1)!=null)
        snake3 = snakeList.get(1);
        if(snakeList.get(2)!=null)
        snake2 = snakeList.get(2);
        if(snakeList.get(3)!=null)
        snake1 = snakeList.get(3);
        System.out.println("working");

        dirsnake1 = "";
        dirsnake2 = "";
        dirsnake3 = "";
        dirsnake4 = "";

        this.world = world;
        this.gameMode = gameMode;



    }


    public void act()
    {
        keys.put(200, new Action(2,"goUp"));
        keys.put(205, new Action(2,"goLeft"));
        keys.put(203, new Action(2,"goRight"));
        keys.put(208, new Action(2,"goDown"));
       // System.out.println("RUnning");


     //   Set<Integer> setOfKeys = keys.keySet();
        if (time.isDone()) {
            time.reset();

        for (Integer key : keys.keySet()) {
            //iterate over key

                if (mayflower.isKeyDown(key)) {
                    Action action = keys.get(key);
                    if (action.getPlayer() == 1) {
                        dirsnake1 = action.getAction();
                       // new SnakeManager(snake1, dirsnake1);
                       // dirsnake1 = dirsnake1 + "repeat";
                    }

                    if (action.getPlayer() == 2) {
                        dirsnake2 = action.getAction();
                       // new SnakeManager(snake2, dirsnake2);
                       // dirsnake2 = dirsnake2 + "repeat";
                    }

                    if (action.getPlayer() == 3) {
                        dirsnake3 = action.getAction();
                      //  new SnakeManager(snake3,dirsnake3);
                       // dirsnake3 = dirsnake3 + "repeat";
                    }

                    if (action.getPlayer() == 4) {
                        dirsnake4 = action.getAction();
                        //new SnakeManager(snake4, dirsnake4);
                        //dirsnake4 = dirsnake4 + "repeat";
                    }


                }

            }
            updateMovement();
        }

        //mayflower.wasKeyDown();
    }

    void updateMovement(){
        if((dirsnake1 != null && !dirsnake1.isEmpty())){
            new SnakeManager(snake1, dirsnake1,world,gameMode);

        }
        if(dirsnake2 != null && !dirsnake2.isEmpty()){
            new SnakeManager(snake2, dirsnake2,world,gameMode);
           // System.out.println(dirsnake2.substring(0,dirsnake2.length()-6));
        }
        if(dirsnake3 != null && !dirsnake3.isEmpty()){
            new SnakeManager(snake3, dirsnake3,world,gameMode);
        }
        if(dirsnake4 != null && !dirsnake4.isEmpty()){
            new SnakeManager(snake4, dirsnake4,world,gameMode);
        }



    }


}


