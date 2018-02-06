import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import mayflower.Actor;

import mayflower.Mayflower;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import mayflower.World;

import java.util.ArrayList;
import java.util.List;

public class Snake extends Actor {
    private Mayflower mayflower;

    private int nextX;
    private int nextY;
    private int spaceX;
    private int spaceY;
    private int tempSpace;
    private boolean gameOver;
    private World world;
    private String dir;
    private boolean multi;

    private int score;

    private static ArrayList<Body> order;

    int up, down, left, right;


    public Snake(String theme,LocalMultiplayerWorld world, int up, int down, int left, int right)
    {
        this.up = up;
        this.down = down;
        this.left = left;
        this.right = right;
        this.world = world;
        score = 0;
        gameOver = false;
        dir = "";
        //BLUE
        setImage(theme+"head.png");

        nextX = 0;
        nextY = 0;
        tempSpace = -1;

        order = new ArrayList<>();
    }
    public Snake(String theme,growWorld world, int up, int down, int left, int right)
    {
        this.up = up;
        this.down = down;
        this.left = left;
        this.right = right;
        this.world = world;
        score = 0;
        gameOver = false;
        dir = "";
        //BLUE
        setImage(theme+"head.png");

        nextX = 0;
        nextY = 0;
        tempSpace = -1;

        order = new ArrayList<>();
    }
    public Snake(String theme, miceWorld world, int up, int down, int left, int right)
    {
        this.up = up;
        this.down = down;
        this.left = left;
        this.right = right;
        //this.world = world;
        this.world = world;
        score = 0;
        gameOver = false;
        dir = "";
        //BLUE
        setImage(theme+"head.png");

        nextX = 0;
        nextY = 0;
        tempSpace = -1;

        order = new ArrayList<>();
    }

   
    public void act()
    {
//North - South
        //17
        if(mayflower.wasKeyDown(up)&&!dir.equals("South"))
        {

        }

        //31
        if(mayflower.wasKeyDown(down)&&!dir.equals("North"))
        {

        }
//East - West
        //32
        if(mayflower.wasKeyDown(right)&&!dir.equals("West"))
        {
            nextX = 20;
            nextY = 0;

            spaceX = tempSpace;
            spaceY = tempSpace;
            dir = "East";
        }
        //30
        if(mayflower.wasKeyDown(left)&&!dir.equals("East"))
        {
            nextX = -20;
            nextY = 0;

            spaceX = tempSpace;
            spaceY = tempSpace;
            dir = "West";
        }
        if(isTouching(Collectable.class))score+=3;
        if(isTouching(Body.class)||isTouching(Wall.class))
        {
            nextX = 0;
            nextY = 0;
            dir = "";
        }




    }

    public int getNextX() {
        return nextX;
    }

    public int getNextY() {
        return nextY;
    }

    public int getSpaceX() {
        return spaceX;
    }

    public int getSpaceY() {
        return spaceY;
    }

    public int getScore() {
        return score;
    }
    public List<Body> getIntersectingBody()
    {
        return getIntersectingObjects(Body.class);
    }
    public List<movableCollectable> getIntersectingMovable()
    {
        return getIntersectingObjects(movableCollectable.class);
    }
    public void goUp()
    {
        nextY = -20;
        nextX = 0;
        spaceY = tempSpace;
        spaceX = tempSpace;
        dir = "North";

        setLocation(getX()+getNextX(),getY()+getNextY());
        updateBody();
    }
    public void goDown()
    {
        nextY = 20;
        nextX = 0;

        spaceY = tempSpace;
        spaceX = tempSpace;
        dir = "South";
        setLocation(getX()+getNextX(),getY()+getNextY());
        updateBody();

    }
    public void goRight()
    {
        nextX = -20;
        nextY = 0;

        spaceX = tempSpace;
        spaceY = tempSpace;
        dir = "West";
        setLocation(getX()+getNextX(),getY()+getNextY());
        updateBody();
    }
    public void goLeft()
    {
        nextX = 20;
        nextY = 0;

        spaceX = tempSpace;
        spaceY = tempSpace;
        dir = "East";
        setLocation(getX()+getNextX(),getY()+getNextY());
        updateBody();
    }


    public void grow()
    {
        if(order.size()>0)
        {
            order.add(new Body("Theme1/"));
            world.addObject(order.get(order.size() - 1),order.get(order.size() - 2).getX(), order.get(order.size() - 2).getY());
            //System.out.println(order.get(order.size()-1).getX()+" , "+order.get(order.size()-1).getY());
        }
        if(order.isEmpty())
        {
            order.add(new Body("Theme1/"));
            world.addObject(order.get(0), getX() - getNextX()-getSpaceX(), getY()-getNextY()-getSpaceY());
            //System.out.println(head.getNextX());

        }
    }
    public void deGrowBody(){
        
        for(int i = order.size()-1; i>0; i--){
            world.removeObject(order.get(i));
        }
        world.removeObjects(order);
    }
/*    public void addBody(){
        System.out.print(order.size());

        if (order.size() > 0) {
            order.add(new Body(theme));
            addObject(order.get(order.size() - 1), order.get(order.size() - 2).getX(), order.get(order.size() - 2).getY());
            //System.out.println(order.get(order.size()-1).getX()+" , "+order.get(order.size()-1).getY());
        }
        if (order.isEmpty()) {
            order.add(new Body(theme));
            addObject(order.get(0), getX() - getNextX() - getSpaceX(), getY() -getNextY() - getSpaceY());
            //System.out.println(head.getNextX());

        }
    }*/

    public void updateBody(){

        if(order.size()>1)
            for(int i = order.size()-1;i>=1;i--) {
                order.get(i).setNextY((getY() - getNextY())-order.get(i).getY());
                order.get(i).setNextX((getX() - getNextX())-order.get(i).getX());
                order.get(i).setLocation(order.get(i - 1).getX(), order.get(i - 1).getY());

            }
        if(order.size()>0) {
            order.get(0).setNextY((getY() - getNextY())-order.get(0).getY());
            order.get(0).setNextX((getX() - getNextX())-order.get(0).getX());
            order.get(0).setLocation(getX() - getNextX()-getSpaceX(), getY() - getNextY()-getSpaceY());



        }


    }
    public Boolean isTouchingCollectable(){
       return isTouching(Collectable.class);
    }
    public Boolean isDead(){

        List<Actor> obj = getIntersectingObjects(Actor.class);
        System.out.println(obj.size());
        for(Actor actor : obj){

            if(!((actor instanceof Collectable )||(actor instanceof Portal )))
                return true;
        }

        return false;

    }
    public void placement(Collectable collect)
    {
        int X = mayflower.getRandomNumber(37)+1;
        int Y = mayflower.getRandomNumber(27)+1;
        //System.out.println("TOUCH: COLLECT");
        if(world.getObjectsAt(X*20+1,Y*20+1).isEmpty())
            collect.setLocation(X*20+1,Y*20+1);
        else placement(collect);

    }


}