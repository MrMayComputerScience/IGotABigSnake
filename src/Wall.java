import mayflower.Actor;

public class Wall extends Actor {



    public Wall(String side)
    {
        setImage("Wall.png");
        if(side.equals("left") || side.equals("right"))
            setRotation(90);
        if(side.equals("top") || side.equals("bottom"))
            setRotation(0);



    }
    public void act()
    {
    }





}
