import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import mayflower.Actor;

import mayflower.Mayflower;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;

import static mayflower.Mayflower.exit;
import static mayflower.Mayflower.stop;

public class Head extends Actor {
    private Mayflower mayflower;

    private int nextX;
    private int nextY;
    private int spaceX;
    private int spaceY;
    private int tempSpace;
    private boolean gameOver;
    private boolean Stop;
    public Head()
    {
        gameOver = false;
        //BLUE

//        try {
//            BufferedImage img = ImageIO.read(new File("head.png"));
//            Graphics g = img.createGraphics();
//            g.drawRect(0,0,20,20);
//            setImage("head.png");
//        } catch (IOException e) {
//            setImage("head.png");
//            e.printStackTrace();
//        }
//        for(int x =0; x<=20;x++)
//            for(int y =0; y<=20;y++)
//            head.setColorAt(x,y, Color.BLACK);
        setImage("head.png");

        nextX = 0;
        nextY = 0;
        tempSpace = -1;
    }

    public void act()
    {
//North - South
        if(mayflower.wasKeyDown(17)||mayflower.wasKeyDown(200))
        {
            nextY = -20;
            nextX = 0;
            spaceY = tempSpace;
            spaceX = tempSpace;
        }
        if(mayflower.wasKeyDown(31)||mayflower.wasKeyDown(208))
        {
            nextY = 20;
            nextX = 0;
            spaceY = tempSpace;
            spaceX = tempSpace;
        }
//East - West
        if(mayflower.wasKeyDown(32)||mayflower.wasKeyDown(205))
        {
            nextX = 20;
            nextY = 0;
            spaceX = tempSpace;
            spaceY = tempSpace;
        }
        if(mayflower.wasKeyDown(30)||mayflower.wasKeyDown(203))
        {
            nextX = -20;
            nextY = 0;
            spaceX = tempSpace;
            spaceY = tempSpace;
        }
        if((isTouching(Body.class)||isTouching(Wall.class)) && !gameOver)
        {
            System.out.println("touch wall");
            //exit();



            Application Gameover = new  Application() {
                @Override
                public void start(Stage stage) throws Exception {
                    //System.out.println("trun");
                    Parent root = FXMLLoader.load(getClass().getResource("gameover.fxml"));
                    Scene scene = new Scene(root, 400, 300);
                    stage.setTitle("Snake");
                    stage.setScene(scene);
                    stage.show();
                }

            };
            try {
                Stage stage = new Stage();
                Gameover.start(stage);
            }
            catch(Exception E)
            {

            }
            gameOver=true;
            Stop = true;


        }
        if(Stop)stop();


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



}
