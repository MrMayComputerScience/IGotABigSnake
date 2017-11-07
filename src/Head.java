import mayflower.Actor;
import mayflower.Mayflower;
import mayflower.Timer;

public class Head extends Actor {
    private Mayflower mayflower;

    private int nextX;
    private int nextY;
    private int spaceX;
    private int spaceY;
    private int Space;
    public Head()
    {
        //BLUE
        setImage("head.png");
        nextX = 0;
        nextY = 0;
<<<<<<< HEAD
        Space = -1;
=======
        tempSpace = 0;
>>>>>>> parent of 08e96f4... Fixed Touch
    }

    public void act()
    {
//North - South
        if(mayflower.wasKeyDown(17)||mayflower.wasKeyDown(200))
        {
            nextY = -20;
            nextX = 0;
            spaceY = -tempSpace;
            spaceX = 0;
        }
        if(mayflower.wasKeyDown(31)||mayflower.wasKeyDown(208))
        {
            nextY = 20;
            nextX = 0;
            spaceY = tempSpace;
            spaceX = 0;
        }
//East - West
        if(mayflower.wasKeyDown(32)||mayflower.wasKeyDown(205))
        {
            nextX = 20;
            nextY = 0;
            spaceX = tempSpace;
            spaceY = 0;
        }
        if(mayflower.wasKeyDown(30)||mayflower.wasKeyDown(203))
        {
            nextX = -20;
            nextY = 0;
            spaceX = -tempSpace;
            spaceY = 0;
        }
        if(isTouching(Body.class))
        {
            System.out.println("TOUCH" + Body.class.toString());
        }

    }

    public int getNextX() {
        return nextX;
    }

    public int getNextY() {
        return nextY;
    }


    public int getSpace() {
        return Space;
    }
}
