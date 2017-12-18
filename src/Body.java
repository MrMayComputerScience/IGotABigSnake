import mayflower.Actor;

import java.util.List;

public class Body extends Actor {

    private int nextX;
    private int nextY;


    public Body(String theme)
    {
        setImage(theme + "body.png");


    }
    public void act() {
    }
    public void setNextX(int next) {
        nextX = next;
    }

    public void setNextY(int next) { nextY = next; }
    public List<Head> getIntersectingClass(Class Class)
    {
        return getIntersectingObjects(Class);
    }






}
