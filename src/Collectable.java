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


        world.addObject(this,19*20+1,14*20+1);
    }
    public void act()
    {
        if(isTouching(Head.class))
        {
            X = mayflower.getRandomNumber(37)+1;
            Y = mayflower.getRandomNumber(27)+1;
            //System.out.println("TOUCH: COLLECT");
            setLocation(X*20+1,Y*20+1);
            world.addTail();
            world.addTail();
            world.addTail();

        }

    }

}
