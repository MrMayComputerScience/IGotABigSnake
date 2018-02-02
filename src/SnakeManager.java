import mayflower.World;

import java.util.ArrayList;
import java.util.List;

public class SnakeManager {
    private static Collectable collect;
    private static ArrayList<Body> order1;
    private static ArrayList<Body> order2;
    private static ArrayList<Body> order3;
    private static ArrayList<Body> order4;
    private World world;
    static String gameMode;

    //list of snakes,
    public SnakeManager(Snake snake, String action, World world, String gameMode) {
        if(gameMode.contains("Regular")) {
            if (action.equals("goUp")) snake.goUp();
            System.out.println("ran");
            if (action.equals("goDown")) snake.goDown();
            if (action.equals("goLeft")) snake.goLeft();
            if (action.equals("goRight")) snake.goRight();
            System.out.print("worked");
            if (snake.isTouchingCollectable()) {

                snake.grow();
                snake.grow();
                snake.grow();


                snake.placement(LocalMultiplayerWorld.getCollectable());
                //collect.scoreNum +=3;

            }
            if (!(snake.isDead())) {

              world.removeObject(snake);
            }
        }
        this.world = world;
        this.gameMode = gameMode;



    }

    public SnakeManager(List<Snake> snakeList) {
        //System.out.print("running");
    }

   /* public void addTail(ArrayList<Body> order, Head head) {
        System.out.print(order.size());

        if (order.size() > 0) {
            order.add(new Body(theme));
            addObject(order.get(order.size() - 1), order.get(order.size() - 2).getX(), order.get(order.size() - 2).getY());
            //System.out.println(order.get(order.size()-1).getX()+" , "+order.get(order.size()-1).getY());
        }
        if (order.isEmpty()) {
            order.add(new Body(theme));
            addObject(order.get(0), head.getX() - head.getNextX() - head.getSpaceX(), head.getY() - head.getNextY() - head.getSpaceY());
            //System.out.println(head.getNextX());

        }


    }

    public void placement()
    {
        int X = mayflower.getRandomNumber(37)+1;
        int Y = mayflower.getRandomNumber(27)+1;
        //System.out.println("TOUCH: COLLECT");
        if(getObjectsAt(X*20+1,Y*20+1).isEmpty())
            collect.setLocation(X*20+1,Y*20+1);
        else placement();

    } */
}

