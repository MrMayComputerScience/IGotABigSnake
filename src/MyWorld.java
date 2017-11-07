import mayflower.Mayflower;
import mayflower.Timer;
import mayflower.World;

import java.util.ArrayList;


public class MyWorld extends World {

    private Head head;
    private Mayflower mayflower;
    private Timer time;

    private Collectable collect;
    private ArrayList<Body> order;
    public MyWorld()
    {
        setBackground("Grid.png");

        head = new Head();
        addObject(head,100,100);

        collect = new Collectable(this);
        order = new ArrayList<>();

        time = new Timer(300);
        setPaintOrder(Body.class, Collectable.class, Head.class);

    }

    public void act()
    {
        if(time.isDone())
        {
            head.setLocation(head.getX()+head.getNextX(),head.getY()+head.getNextY());
            move();
            time.reset();
        }
        if(mayflower.isKeyPressed(78)) addTail();
    }

    public void move()
    {

        //System.out.println(order.size());
        if(order.size()>1)
            for(int i = order.size()-1;i>=1;i--) {
                order.get(i).setNextY((head.getY() - head.getNextY())-order.get(i).getY());
                order.get(i).setNextX((head.getX() - head.getNextX())-order.get(i).getX());
                order.get(i).setLocation(order.get(i - 1).getX(), order.get(i - 1).getY());
                //System.out.println(order.get(0).getNextX()+" , "+order.get(0).getNextY());
            }

        if(!order.isEmpty()) {
            order.get(0).setNextY((head.getY() - head.getNextY())-order.get(0).getY());
            order.get(0).setNextX((head.getX() - head.getNextX())-order.get(0).getX());
            order.get(0).setLocation(head.getX() - head.getNextX()-head.getSpaceX(), head.getY() - head.getNextY()-head.getSpaceY());

            //System.out.println("locat1");

        }
    }
    public void addTail()
    {

        if(order.size()>0)
        {
            order.add(new Body());
            addObject(order.get(order.size() - 1),order.get(order.size() - 2).getX(), order.get(order.size() - 2).getY());
            //System.out.println(order.get(order.size()-1).getX()+" , "+order.get(order.size()-1).getY());
        }
        if(order.isEmpty())
        {
            order.add(new Body());
            addObject(order.get(0), head.getX() - head.getNextX()-head.getSpaceX(), head.getY()-head.getNextY()-head.getSpaceY());
            //System.out.println(head.getNextX());

        }

    }


}
