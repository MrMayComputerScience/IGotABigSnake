import mayflower.*;

import java.util.List;

public class Collectable extends Actor {
    private MyWorld Myworld;
    private LocalMultiplayerWorld localWorld;
    private twitchWorld TwitchWorld;

    private Mayflower mayflower;
    private int X;
    private int Y;
    private MayflowerImage img;

    private int scoreNum;

    public Collectable(MyWorld world)
    {

        this.Myworld = world;
        img = new MayflowerImage("collectable.png");
        setImage(img);
        scale(.9);
        scoreNum =0;


        world.addObject(this,19*20+1,14*20+1);


    }
    public Collectable(LocalMultiplayerWorld world)
    {

        this.localWorld = world;
        img = new MayflowerImage("collectable.png");
        setImage(img);
        scale(.9);
        scoreNum =0;


        world.addObject(this,19*20+1,14*20+1);


    }
    public Collectable(twitchWorld world)
    {

        this.TwitchWorld = world;
        img = new MayflowerImage("collectable.png");
        setImage(img);
        scale(.9);
        scoreNum =0;


        world.addObject(this,19*20+1,14*20+1);


    }
    public void act()
    {


    }
    public void placement()
    {
        X = mayflower.getRandomNumber(37)+1;
        Y = mayflower.getRandomNumber(27)+1;
        //System.out.println("TOUCH: COLLECT");
        if(Myworld.getObjectsAt(X*20+1,Y*20+1).isEmpty()||localWorld.getObjectsAt(X*20+1,Y*20+1).isEmpty())
            setLocation(X*20+1,Y*20+1);
        else placement();

    }

    public int getScore() {
        return scoreNum;
    }

    public List<Head> getIntersectingHead(Class Class)
    {
        return getIntersectingObjects(Class);
    }
}
