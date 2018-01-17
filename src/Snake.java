import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import mayflower.Actor;

import mayflower.Mayflower;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import mayflower.World;

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

    int up, down, left, right;



    
    public Head(String theme,LocalMultiplayerWorld world, int up, int down, int left, int right)
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
    }
    public Head(String theme,growWorld world, int up, int down, int left, int right)
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
    }
    public Head(String theme, miceWorld world, int up, int down, int left, int right)
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
    }
    public void act()
    {
//North - South
        //17
        if(mayflower.wasKeyDown(up)&&!dir.equals("South"))
        {
            nextY = -20;
            nextX = 0;
            spaceY = tempSpace;
            spaceX = tempSpace;
            dir = "North";
        }

        //31
        if(mayflower.wasKeyDown(down)&&!dir.equals("North"))
        {
            nextY = 20;
            nextX = 0;

            spaceY = tempSpace;
            spaceX = tempSpace;
            dir = "South";
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
}