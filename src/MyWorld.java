import mayflower.*;

import java.util.ArrayList;


public class MyWorld extends World {

    private Head head;
    private Mayflower mayflower;
    private Timer time;

    private Collectable collect;
    private ArrayList<Body> order;

    private Label score;
    public MyWorld()
    {
        setBackground("Grid.png");

        head = new Head();
        addObject(head,100,100);



        collect = new Collectable(this);
        order = new ArrayList<>();

        time = new Timer(75);
        setPaintOrder(Body.class, Collectable.class, Head.class);
        addObject(new Wall("left"),389,200);
        addObject(new Wall("right"),-392,200);
        addObject(new Wall("top"),0,0);
        addObject(new Wall("bottom"),0,581);

        score = new Label("Score: 0",20, Color.BLUE);

        addObject(score, 0,  -5);




    }

    public void act()
    {
        if(time.isDone())
        {
            head.setLocation(head.getX()+head.getNextX(),head.getY()+head.getNextY());
            move();
            time.reset();
        }
        score.setText("Score: "+collect.getScoreNum());
        //if(mayflower.isKeyPressed(78)) addTail();
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
