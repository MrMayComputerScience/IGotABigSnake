import mayflower.Actor;
import mayflower.Mayflower;
import mayflower.Timer;

public class Head extends Actor {
    private Mayflower mayflower;

    private int nextX;
    private int nextY;
    private int spaceX;
    private int spaceY;
    private int tempSpace;
    public Head()
    {
        //BLUE
        setImage("head.png");
        nextX = 0;
        nextY = 0;
        tempSpace = -1;
    }

    public void act()
    {
//North - South
        if(mayflower.wasKeyDown(17)||mayflower.wasKeyDown(200))
        {
            nextY = -20;
            nextX = 0;
            spaceY = tempSpace;
            spaceX = tempSpace;
        }
        if(mayflower.wasKeyDown(31)||mayflower.wasKeyDown(208))
        {
            nextY = 20;
            nextX = 0;
            spaceY = tempSpace;
            spaceX = tempSpace;
        }
//East - West
        if(mayflower.wasKeyDown(32)||mayflower.wasKeyDown(205))
        {
            nextX = 20;
            nextY = 0;
            spaceX = tempSpace;
            spaceY = tempSpace;
        }
        if(mayflower.wasKeyDown(30)||mayflower.wasKeyDown(203))
        {
            nextX = -20;
            nextY = 0;
            spaceX = tempSpace;
            spaceY = tempSpace;
        }
        if(isTouching(Body.class))
        {
            System.out.println("TOUCH");
        }

    }

    public int getNextX() {
        return nextX;
    }

    public int getNextY() {
        return nextY;
    }

    public int getSpaceX() {
        return spaceX;
    }

    public int getSpaceY() {
        return spaceY;
    }
}
