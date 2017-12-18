import mayflower.Actor;
import mayflower.Mayflower;
import mayflower.MayflowerImage;

import java.util.List;

public class Portal extends Actor {
    //private MyWorld Myworld;
    private LocalMultiplayerWorld localWorld;
    private twitchWorld TwitchWorld;
    private miceWorld MiceWorld;
    private growWorld grow;

    private Mayflower mayflower;
    private int X;
    private int Y;
    private MayflowerImage img;

    private int scoreNum;


    public Portal(String theme,LocalMultiplayerWorld world)
    {

        this.localWorld = world;
        img = new MayflowerImage(theme+"portal.png");
        setImage(img);
        scale(.9);
        scoreNum =0;
        toPortal to = new toPortal(theme);





    }

    public Portal(String theme,twitchWorld world)
    {

        this.TwitchWorld = world;
        img = new MayflowerImage(theme+"portal.png");
        setImage(img);
        scale(.9);
        scoreNum =0;
        toPortal to = new toPortal(theme);





    }
    public Portal(String theme,growWorld world)
    {

        this.grow = world;
        img = new MayflowerImage(theme+"portal.png");
        setImage(img);
        scale(.9);
        scoreNum =0;
        toPortal to = new toPortal(theme);





    }
    public Portal(String theme, miceWorld world)
    {

        this.MiceWorld = world;
        img = new MayflowerImage(theme+"portal.png");
        setImage(img);
        scale(.9);
        scoreNum =0;
        toPortal to = new toPortal(theme);
    }
    public void act()
    {


    }
    public void teleport(int x, int y)
    {
        for (Head head: getIntersectingObjects(Head.class)) {
            head.setLocation(x-1,y-1);
        }
        for(movableCollectable collect: getIntersectingObjects(movableCollectable.class)) collect.setLocation(x,y);
    }
    public void teleportTwitch(int x, int y)
    {
        for (twitchHead head: getIntersectingObjects(twitchHead.class)) {
            head.setLocation(x-1,y-1);
        }
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
