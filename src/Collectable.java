import mayflower.Actor;
import mayflower.Mayflower;
import mayflower.MayflowerImage;

public class Collectable extends Actor {
    private MyWorld world;
    private Mayflower mayflower;
    private int X;
    private int Y;
    private MayflowerImage img;

    public Collectable(MyWorld world)
    {

        this.world = world;
        img = new MayflowerImage("collectable.png");
        setImage(img);
        scale(.9);


        world.addObject(this,241,241);
    }
    public void act()
    {
        if(isTouching(Head.class))
        {
            X = mayflower.getRandomNumber(40);
            Y = mayflower.getRandomNumber(30);
            //System.out.println("TOUCH: COLLECT");
            setLocation(X*20+1,Y*20+1);
            world.addTail();

        }

    }

}
