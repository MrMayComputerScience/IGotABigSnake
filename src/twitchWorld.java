import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableSet;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import mayflower.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class twitchWorld extends World {
    @FXML
    public Button Exit;

    @FXML
    GridPane Over;

    @FXML
    TextField textField;

    @FXML
    ListView<String> names;

    @FXML
    ListView<String> scores;

    @FXML
    private ObservableSet<String> scoreTemp;

    @FXML
    private ObservableSet<String> nameTemp;

    @FXML
    public Button save;
    private static ArrayList<String> highscore;


    private twitchHead head;


    private Mayflower mayflower;
    private Timer time;

    private static Collectable collect;
    private static ArrayList<Body> order;

    @FXML
    private static Label label;



    private boolean pause;
    private boolean end;

    @FXML
    int score;

    @FXML private static int S;

    private int players;

    private Portal portal;
    private toPortal toportal;

    private int overScreen;
    private boolean isPortal;
    private String theme;

    public twitchWorld(String theme, boolean portal, boolean one, boolean two, boolean three, boolean four)
    {
        this.theme = theme;
        isPortal = portal;
        end = false;
        System.out.print("one"+one);
        System.out.print("two"+two);
        System.out.print("three"+three);
        System.out.print("four"+four);
        if(one)this.players++;
        if(two)this.players++;
        if(three)this.players++;
        if(four)this.players++;

        //score = 0;
        highscore = new ArrayList<String>();

        setBackground(theme + "Grid.png");


        //get key codes
        //this.players = 4;
        //head = new twitchHead(this, one,two,three,four);
        head = new twitchHead(theme, this, one,two,three,four);
        addObject(head,100,100);





        collect = new Collectable(theme, this);

        order = new ArrayList<>();



        time = new Timer(75);
        setPaintOrder( Wall.class ,Label.class, Body.class, Collectable.class, Head.class);
        label = new Label("Score: 0", 20, Color.BLUE);
        addObject(label, 10,-5);
        Wall wallLeft= new Wall("left");
        wallLeft.setImage(theme+"wall.png");

        Wall wallRight = new Wall("right");
        wallRight.setImage(theme+"wall.png");

        Wall wallTop= new Wall("top");
        wallTop.setImage(theme+"wall.png");

        Wall wallBottom= new Wall("bottom");
        wallBottom.setImage(theme+"wall.png");

        addObject(wallLeft,390,200);
        addObject(wallRight,-392,200);
        addObject(wallTop,0,-1);
        addObject(wallBottom,0,581);

        pause = false;
        if(portal) {
            this.portal = new Portal(theme, this);
            this.toportal = new toPortal(theme);

            addObject(this.portal, 20 * 20 + 1, 20 * 20 + 1);
            addObject(this.toportal, 5 * 20 + 1, 5 * 20 + 1);
            portalPlacement();
            toportalPlacement();
        }
        repaint();
    }

    public void act()
    {
        if(time.isDone()&&!pause)
        {
            if(isPortal)
                portal.teleportTwitch(toportal.getX(),toportal.getY());
            System.out.println("size of head:"+getObjects(twitchHead.class).size());

                head.setLocation(head.getX()+head.getNextX(),head.getY()+head.getNextY());
                move(order,head);




            repaint();

            time.reset();
        }
        for ( twitchHead head:collect.getIntersectingTwitchHead(twitchHead.class))
        {

                addTail(order, this.head);
                addTail(order, this.head);
                addTail(order, this.head);
            



            placement();
            //collect.scoreNum +=3;

        }




                if ((!head.getIntersectingBody().isEmpty())||(!(head.getX()>5&&head.getX()<780))||(!(head.getY()>5&&head.getY()<565))) {
                    removeObject(head);


                     removeObjects(order);

                     if(end==false)
                     {
                         Application Gameover = new  Application() {
                             @Override
                             public void start(Stage stage) throws Exception {
                                 //System.out.println("trun");
                                 Parent root = FXMLLoader.load(getClass().getResource("test.fxml"));
                                 Scene scene = new Scene(root, 600, 400);
                                 stage.setTitle("Snake");
                                 stage.setScene(scene);
                                 stage.show();
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
                         end = true;
                     }

                }





        //if(mayflower.isKeyPressed(57)) pause=!pause;



        //if(mayflower.isKeyPressed(78)) addTail();
    }
    public void placement()
    {
        int X = mayflower.getRandomNumber(37)+1;
        int Y = mayflower.getRandomNumber(27)+1;
        //System.out.println("TOUCH: COLLECT");
        if(getObjectsAt(X*20+1,Y*20+1).isEmpty())
            collect.setLocation(X*20+1,Y*20+1);
        else placement();

    }
    public void portalPlacement()
    {
        int X = mayflower.getRandomNumber(37)+1;
        int Y = mayflower.getRandomNumber(27)+1;
        //System.out.println("TOUCH: COLLECT");
        if(getObjectsAt(X*20+1,Y*20+1).isEmpty())
            portal.setLocation(X*20+1,Y*20+1);
        else portalPlacement();

    }
    public void toportalPlacement()
    {
        int X = mayflower.getRandomNumber(37)+1;
        int Y = mayflower.getRandomNumber(27)+1;
        //System.out.println("TOUCH: COLLECT");
        if(getObjectsAt(X*20+1,Y*20+1).isEmpty())
            toportal.setLocation(X*20+1,Y*20+1);
        else toportalPlacement();

    }

    public void move(ArrayList<Body> order, twitchHead head)
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
    public void addTail(ArrayList<Body> order, twitchHead head)
    {
        System.out.print(order.size());

        if(order.size()>0)
        {
            order.add(new Body(theme));
            addObject(order.get(order.size() - 1),order.get(order.size() - 2).getX(), order.get(order.size() - 2).getY());
            //System.out.println(order.get(order.size()-1).getX()+" , "+order.get(order.size()-1).getY());
        }
        if(order.isEmpty())
        {
            order.add(new Body(theme));
            addObject(order.get(0), head.getX() - head.getNextX()-head.getSpaceX(), head.getY()-head.getNextY()-head.getSpaceY());
            //System.out.println(head.getNextX());

        }


    }
    @FXML
    public void close(ActionEvent event) throws IOException
    {
        try {
            Stage stage = (Stage) Exit.getScene().getWindow();
            stage.close();
            Mayflower.exit();
        }
        catch(Exception E)
        {

        }

    }
    @FXML
    public void mainLoad(ActionEvent event) throws IOException
    {
        GridPane pane = FXMLLoader.load(getClass().getResource("fakemain.fxml"));
        Over.getChildren().setAll(pane);
    }
    @FXML
    public void saveScore() throws IOException
    {
        String name =textField.getText();
        //score = head.getScore();
        System.out.println("SCORE"+score);




        if(!name.isEmpty()) {
            try (
                    FileWriter fw = new FileWriter("highscore.txt", true);
                    BufferedWriter bw = new BufferedWriter(fw);
                    PrintWriter out = new PrintWriter(bw)) {
                out.println(score + " " + name);

            } catch (IOException E) {

            }

            save.setDisable(true);
        }
        addScore();
        //addScore();  name+" "+
    }
    @FXML
    public void addScore() throws IOException
    {
        Scanner in = new Scanner(new FileReader("highscore.txt"));


        while(in.hasNextLine()) {
            highscore.add(in.nextLine());
        }
        in.close();


        Collections.sort(highscore);
        Collections.reverse(highscore);

        nameTemp = FXCollections.observableSet();
        scoreTemp = FXCollections.observableSet();

        ObservableList<String> nameTemp2 = FXCollections.observableArrayList();
        ObservableList<String> scoreTemp2 = FXCollections.observableArrayList();

        for (String curr:highscore
                ) {
            String[] parts = curr.split(" ");
            nameTemp2.add(parts[1]);
            scoreTemp2.add(parts[0]);

        }

        for(int i = 0;i<scoreTemp2.size();i++)
        {
            for(int q = 0;q<scoreTemp2.size();q++) {


                int temp = Integer.parseInt(scoreTemp2.get(0));
                String stringTemp = nameTemp2.get(i);

                if (Integer.parseInt(scoreTemp2.get(i)) > Integer.parseInt(scoreTemp2.get(q))) {

                    temp = Integer.parseInt(scoreTemp2.get(i));
                    scoreTemp2.set(i, scoreTemp2.get(q));
                    scoreTemp2.set(q, temp+"");

                    nameTemp2.set(i, nameTemp2.get(q));
                    nameTemp2.set(q, stringTemp + "");

                }
            }


        }
        //nameTemp2.addAll(nameTemp);
        //scoreTemp2.addAll(scoreTemp);
        //System.out.println(nameTemp2);
        //System.out.println(scoreTemp2);
        names.setItems(nameTemp2);
        scores.setItems(scoreTemp2);


        System.out.print(highscore);


    }
    @FXML
    public void again()
    {

        removeObjects(getObjects(Body.class));
        removeObjects(getObjects(Head.class));
        collect.setLocation(19*20+1,14*20+1);


        //collect.resetScore();
        score =0;
        //head.setGameOver(false);
        addObject(head, 100,100);

            //head.setLocation(100,100);




        Stage stage = (Stage) Exit.getScene().getWindow();
        stage.close();
    }



}
