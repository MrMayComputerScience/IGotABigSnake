import mayflower.Actor;

public class Body extends Actor {

    private int nextX;
    private int nextY;


    public Body()
    {
        setImage("body.png");


    }
    public void act()
    {
    }
    public void setNextX(int next) {
        nextX = next;
    }

    public void setNextY(int next) { nextY = next; }






}
