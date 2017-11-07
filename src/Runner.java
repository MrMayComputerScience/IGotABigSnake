
import mayflower.Mayflower;
import mayflower.World;

public class Runner extends Mayflower{

    private World world;
    public Runner()
    {
        super("Snake",800,600);


    }
    public void init()
    {
       setWorld(new MyWorld());
       // showBounds(true);

    }
    public static void main(String args[])
    {
        new Runner();
        //setWorld(new MyWorld());
    }
//    public void update(org.newdawn.slick.GameContainer arg0, int arg1)
//    {
//        //setWorld(new MyWorld());
//
//    }

}
