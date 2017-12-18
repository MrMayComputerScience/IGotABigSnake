import mayflower.Actor;
import mayflower.Mayflower;
import mayflower.MayflowerImage;
import mayflower.Timer;

import java.util.List;

public class movableCollectable extends Actor {
    //private MyWorld Myworld;
    private LocalMultiplayerWorld localWorld;
    private twitchWorld TwitchWorld;
    private miceWorld world;

    private Mayflower mayflower;
    private int X;
    private int Y;
    private MayflowerImage img;

    private int scoreNum;

    private Timer time;

    private int nextX, nextY, spaceY, spaceX, tempSpace;
    int up, down, left, right;

    private String dir;


    public movableCollectable(miceWorld world, int up, int down, int left, int right)
    {

        this.world = world;
        img = new MayflowerImage("Theme1/collectable.png");
        setImage(img);
        scale(.9);
        scoreNum =0;


        //world.addObject(this,19*20+1,14*20+1);

        time = new Timer(75);

        this.up = up;
        this.down = down;
        this.left = left;
        this.right = right;
        //this.world = world;

        dir = "";
        //BLUE
        //setImage("head.png");

        nextX = 0;
        nextY = 0;
        tempSpace = -1;


    }

    public void act()
    {

        if(mayflower.wasKeyDown(up))
        {
            //System.out.print(":::::::::::");
            nextY = -20;
            nextX = 0;
            spaceY = tempSpace;
            spaceX = tempSpace;
            dir = "North";
        }

        //31
        if(mayflower.wasKeyDown(down))
        {
            nextY = 20;
            nextX = 0;

            spaceY = tempSpace;
            spaceX = tempSpace;
            dir = "South";
        }
//East - West
        //32
        if(mayflower.wasKeyDown(right))
        {
            nextX = 20;
            nextY = 0;

            spaceX = tempSpace;
            spaceY = tempSpace;
            dir = "East";
        }
        //30
        if(mayflower.wasKeyDown(left))
        {
            nextX = -20;
            nextY = 0;

            spaceX = tempSpace;
            spaceY = tempSpace;
            dir = "West";
        }
        //if(isTouching(Collectable.class))score+=3;
        /*if(isTouching(Body.class)||isTouching(Wall.class))
        {
            nextX = 0;
            nextY = 0;
            dir = "";
        }
        */


    }
    /*public void placement()
    {
        X = mayflower.getRandomNumber(37)+1;
        Y = mayflower.getRandomNumber(27)+1;
        //System.out.println("TOUCH: COLLECT");
        if(Myworld.getObjectsAt(X*20+1,Y*20+1).isEmpty()||localWorld.getObjectsAt(X*20+1,Y*20+1).isEmpty()||TwitchWorld.getObjectsAt(X*20+1,Y*20+1).isEmpty())
            setLocation(X*20+1,Y*20+1);
        else placement();

    }
    */

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

    public int getScore() {
        return scoreNum;
    }

    public List<Head> getIntersectingHead(Class Class)
    {
        return getIntersectingObjects(Class);
    }
    public List<twitchHead> getIntersectingTwitchHead(Class Class)
    {
        return getIntersectingObjects(Class);
    }

}
