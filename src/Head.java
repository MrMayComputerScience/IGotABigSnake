import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import mayflower.Actor;

import mayflower.Mayflower;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;

import static mayflower.Mayflower.exit;

public class Head extends Actor {
    private Mayflower mayflower;

    private int nextX;
    private int nextY;
    private int spaceX;
    private int spaceY;
    private int tempSpace;
    private boolean gameOver;
    private static MyWorld world;
    private String dir;

    public int score;
    public Head(MyWorld world)
    {
        this.world = world;
        score = 0;
        gameOver = false;
        dir = "";
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
        if(mayflower.wasKeyDown(17)||mayflower.wasKeyDown(200)&&!dir.equals("South"))
        {
            nextY = -20;
            nextX = 0;
            spaceY = tempSpace;
            spaceX = tempSpace;
            dir = "North";
        }
        if(mayflower.wasKeyDown(31)||mayflower.wasKeyDown(208)&&!dir.equals("North"))
        {
            nextY = 20;
            nextX = 0;
            spaceY = tempSpace;
            spaceX = tempSpace;
            dir = "South";
        }
//East - West
        if(mayflower.wasKeyDown(32)||mayflower.wasKeyDown(205)&&!dir.equals("West"))
        {
            nextX = 20;
            nextY = 0;
            spaceX = tempSpace;
            spaceY = tempSpace;
            dir = "East";
        }
        if(mayflower.wasKeyDown(30)||mayflower.wasKeyDown(203)&&!dir.equals("East"))
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

            world.removeObjects(world.getObjects(Body.class));

            setLocation(100,100);
            nextX = 0;
            nextY = 0;
            dir = "";



            Application Gameover = new  Application() {
                @Override
                public void start(Stage stage) throws Exception {
                    //System.out.println("trun");
                    //gameoverController controller = new gameoverController(world);
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("over.fxml"));

                    //loader.setController(controller);
                    Parent root = (Parent)loader.load();
                    //loader.load();


                    //Parent root = FXMLLoader.load(getClass().getResource("over.fxml"));
                    //loader.setController(controller);
                    //GridPane root = loader.load();
                    Scene scene = new Scene(root, 600, 400);
                    gameoverController.loadWorld(world);

                    stage.setTitle("Snake");
                    stage.setScene(scene);
                    stage.show();
                    //launch();
                }

            };
            try {
                Stage stage = new Stage();
                Gameover.start(stage);
                System.out.println("touch wall");


            }
            catch(Exception E)
            {

            }
            world.removeBody();



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
}