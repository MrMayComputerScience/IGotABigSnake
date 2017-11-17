import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableSet;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import mayflower.Label;
import mayflower.Timer;
import mayflower.*;



import java.io.*;
import java.util.*;


public  class MyWorld extends World {




    public Head head;
    private Mayflower mayflower;
    private Timer time;

    private static Collectable collect;
    private static ArrayList<Body> order;
    @FXML
    private static Label label;



    private boolean pause;


    public int score;

    @FXML private static int S;

    public MyWorld()
    {

        //score = 0;


        setBackground("Grid.png");

        head = new Head(this);
        addObject(head,100,100);

        collect = new Collectable(this);

        order = new ArrayList<>();

        time = new Timer(75);
        setPaintOrder( Wall.class ,Label.class, Body.class, Collectable.class, Head.class);
        label = new Label("Score: 0", 20, Color.BLUE);
        addObject(label, 10,-5);
        addObject(new Wall("left"),390,200);
        addObject(new Wall("right"),-392,200);
        addObject(new Wall("top"),0,-1);
        addObject(new Wall("bottom"),0,581);
        pause = false;
        repaint();





    }

    public void act()
    {
        if(time.isDone()&&!pause)
        {
            head.setLocation(head.getX()+head.getNextX(),head.getY()+head.getNextY());
            move();
            time.reset();
            //System.out.println("score: "+collect.getScore());

            score = head.getScore();

            label.setText("Score: "+head.getScore());

            repaint();
            //System.out.println(head.getX() - head.getNextX()-head.getSpaceX());
            // System.out.println(score);
            //System.out.println(score);
        }
        if(mayflower.isKeyPressed(57)) pause=!pause;



        //if(mayflower.isKeyPressed(78)) addTail();
    }

    public void move()
    {


        if(order.size()>1)
            for(int i = order.size()-1;i>=1;i--) {
                order.get(i).setNextY((head.getY() - head.getNextY())-order.get(i).getY());
                order.get(i).setNextX((head.getX() - head.getNextX())-order.get(i).getX());
                order.get(i).setLocation(order.get(i - 1).getX(), order.get(i - 1).getY());

            }
        if(order.size()>0) {
            order.get(0).setNextY((head.getY() - head.getNextY())-order.get(0).getY());
            order.get(0).setNextX((head.getX() - head.getNextX())-order.get(0).getX());
            order.get(0).setLocation(head.getX() - head.getNextX()-head.getSpaceX(), head.getY() - head.getNextY()-head.getSpaceY());



        }
    }
    public void addTail()
    {
        System.out.print(order.size());

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

    public static ArrayList<Body> getOrder() {
        return order;
    }
    public void removeBody()
    {
        order = new ArrayList<>();

}}
