import mayflower.Actor;
import mayflower.Mayflower;
import mayflower.World;

import java.util.List;

public class twitchHead extends Actor {
    private Mayflower mayflower;

    private int nextX;
    private int nextY;
    private int spaceX;
    private int spaceY;
    private int tempSpace;
    private boolean gameOver;
    private twitchWorld world;
    private String dir;
    private boolean multi;

    private int score;

    int up, down, left, right;

    int up1 = 17;
    int down1 = 31;
    int left1 = 30;
    int right1 = 32;

    int up2 = 21;
    int down2 = 35;
    int left2 = 34;
    int right2 = 36;

    int up3 = 25;
    int down3 = 39;
    int left3 = 38;
    int right3 = 40;

    int up4 = 200;
    int down4 = 208;
    int left4 = 203;
    int right4 = 205;

    private int players;

    private boolean one,two,three,four;



    public twitchHead(String theme, twitchWorld world, boolean one, boolean two, boolean three, boolean four)
    {
        players=0;
        this.one = one;
        this.two = two;
        this.three = three;
        this.four = four;

        this.world = world;
        setLocation(200,200);
        score = 0;
        gameOver = false;
        dir = "";
        //BLUE
        setImage(theme+"head.png");

        nextX = 0;
        nextY = 0;
        tempSpace = -1;


        if(one)this.players++;
        if(two)this.players++;
        if(three)this.players++;
        if(four)this.players++;

        if(!one)
        {
            if(two)
            {
                up1 = up2;
                down1 = down2;
                left1 = left2;
                right1 = right2;
            }
            if(three)
            {
                up1 = up3;
                down1 = down3;
                left1 = left3;
                right1 = right3;
            }
            if(four)
            {
                up1 = up4;
                down1 = down4;
                left1 = left4;
                right1 = right4;
            }
        }
        if(!two)
        {
            if(one)
            {
                up2 = up1;
                down2 = down1;
                left2 = left1;
                right2 = right1;
            }
            if(three)
            {
                up2 = up3;
                down2 = down3;
                left2 = left3;
                right2 = right3;
            }
            if(four)
            {
                up2 = up4;
                down2 = down4;
                left2 = left4;
                right2 = right4;
            }
        }
        if(!three)
        {
            if(two)
            {
                up3 = up2;
                down3 = down2;
                left3 = left2;
                right3 = right2;
            }
            if(one)
            {
                up3 = up1;
                down3 = down1;
                left3 = left1;
                right3 = right1;
            }
            if(four)
            {
                up3 = up4;
                down3 = down4;
                left3 = left4;
                right3 = right4;
            }
        }
        if(!four)
        {
            if(two)
            {
                up4 = up2;
                down4 = down2;
                left4 = left2;
                right4 = right2;
            }
            if(three)
            {
                up4 = up3;
                down4 = down3;
                left4 = left3;
                right4 = right3;
            }
            if(one)
            {
                up4 = up1;
                down4 = down1;
                left4 = left1;
                right4 = right1;
            }
        }








    }
    public void act()
    {
//North - South
        //17


        if((mayflower.wasKeyDown(up1))&&(mayflower.wasKeyDown(up2))&&(mayflower.wasKeyDown(up3))&&(mayflower.wasKeyDown(up4))&&!dir.equals("South"))
        {
            nextY = -20;
            nextX = 0;
            spaceY = tempSpace;
            spaceX = tempSpace;
            dir = "North";
        }

        //31
        if(mayflower.wasKeyDown(down1)&&mayflower.wasKeyDown(down2)&&mayflower.wasKeyDown(down3)&&mayflower.wasKeyDown(down4)&&!dir.equals("North"))
        {
            nextY = 20;
            nextX = 0;

            spaceY = tempSpace;
            spaceX = tempSpace;
            dir = "South";
        }
//East - West
        //32
        if(mayflower.wasKeyDown(right1)&&mayflower.wasKeyDown(right2)&&mayflower.wasKeyDown(right3)&&mayflower.wasKeyDown(right4)&&!dir.equals("West"))
        {
            nextX = 20;
            nextY = 0;

            spaceX = tempSpace;
            spaceY = tempSpace;
            dir = "East";
        }
        //30
        if(mayflower.wasKeyDown(left1)&&mayflower.wasKeyDown(left2)&&mayflower.wasKeyDown(left3)&&mayflower.wasKeyDown(left4)&&!dir.equals("East"))
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
}