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

public class growWorld extends World {
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


    private Head head1;
    private Head head2;
    private Head head3;
    private Head head4;

    private Mayflower mayflower;
    private Timer time;
    private Timer Tailtime;

    //private static Collectable collect;
    private static ArrayList<Body> order1;
    private static ArrayList<Body> order2;
    private static ArrayList<Body> order3;
    private static ArrayList<Body> order4;
    @FXML
    private static Label label;



    private boolean pause;
    private boolean end;

    @FXML
    int score;

    @FXML private static int S;

    private int players;
    private int tempPlayers;

    private boolean temp1, temp2, temp3,temp4;
    private boolean one, two, three,four;

    private boolean tempCollect;


    private Portal portal;
    private toPortal toportal;

    private int overScreen;
    private boolean isPortal;

    private String theme;

    public growWorld(String theme, boolean portal, boolean one, boolean two, boolean three, boolean four)
    {
        this.theme = theme;
        isPortal = portal;
        tempCollect = true;
        tempPlayers = 0;
        end = false;
        temp1 = true;
        temp2 = true;
        temp3 = true;
        temp4 = true;

        this.one = one;
        this.two = two;
        this.three = three;
        this.four = four;




        if(one)this.players++;
        if(two)this.players++;
        if(three)this.players++;
        if(four)this.players++;

        //score = 0;
        highscore = new ArrayList<String>();

        setBackground(theme+"Grid.png");


        //get key codes
        //this.players = 4;
        head4 = new Head(theme, this, 200, 208, 203, 205);
        head4.setImage(theme+"head4.png");
        head3 = new Head(theme, this, 25, 39, 38, 40);
        head3.setImage(theme+"head3.png");
        head2 = new Head(theme, this, 21, 35, 34, 36);
        head2.setImage(theme+"head2.png");
        head1 = new Head(theme, this, 17, 31, 30, 32);
        head1.setImage(theme+"head.png");

        if(this.players==1) {
            if(four) {

                addObject(head4, 680, 480);
            }
            if(three) {

                addObject(head3, 100, 480);
            }
            if(two) {

                addObject(head2, 680, 100);
            }
            if(one) {

                addObject(head1, 100, 100);
            }

        }
        if(this.players==2) {
            //yhgj
            if(four) {

                addObject(head4, 680, 480);
            }
            if(three) {

                addObject(head3, 100, 480);
            }
            if(two) {

                addObject(head2, 680, 100);
            }
            if(one) {

                addObject(head1, 100, 100);
            }
        }
        if(this.players==3) {
            //p;l'
            if(four) {

                addObject(head4, 680, 480);
            }
            if(three) {

                addObject(head3, 100, 480);
            }
            if(two) {

                addObject(head2, 680, 100);
            }
            if(one) {

                addObject(head1, 100, 100);
            }
        }
        if(this.players==4) {
            if(four) {

                addObject(head4, 680, 480);
            }
            if(three) {

                addObject(head3, 100, 480);
            }
            if(two) {

                addObject(head2, 680, 100);
            }
            if(one) {

                addObject(head1, 100, 100);
            }
        }



        order1 = new ArrayList<>();
        order2 = new ArrayList<>();
        order3 = new ArrayList<>();
        order4 = new ArrayList<>();


        time = new Timer(75);
        Tailtime = new Timer(75);
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
        if(tempPlayers>=players)
        if(time.isDone()&&!pause) {
            if(isPortal)
                portal.teleport(toportal.getX(),toportal.getY());
            //if(players==1) {

//
//            addTail(order4, head4);
//            addTail(order3, head3);
//            addTail(order2, head2);
//            addTail(order1, head1);
//
            if (four) {
                //addTail(order4, head4);

                head4.setLocation(head4.getX() + head4.getNextX(), head4.getY() + head4.getNextY());
                move(order4, head4);


            }
            if (three) {
                //addTail(order3, head3);
                head3.setLocation(head3.getX() + head3.getNextX(), head3.getY() + head3.getNextY());

                move(order3, head3);
            }
            if (two) {
                //addTail(order2, head2);
                head2.setLocation(head2.getX() + head2.getNextX(), head2.getY() + head2.getNextY());

                move(order2, head2);
            }
            if (one) {
                //addTail(order1, head1);


                head1.setLocation(head1.getX() + head1.getNextX(), head1.getY() + head1.getNextY());
                move(order1, head1);


            }

//            if (four) addTail(order4, head4);
//            if (three) addTail(order3, head3);
//            if (two) addTail(order2, head2);
//            if (one) addTail(order1, head1);



           /* }
            if(players==2) {
                head4.setLocation(head4.getX()+head4.getNextX(),head4.getY()+head4.getNextY());
                move(order4,head4);
                head3.setLocation(head3.getX()+head3.getNextX(),head3.getY()+head3.getNextY());
                move(order3,head3);
                head2.setLocation(head2.getX()+head2.getNextX(),head2.getY()+head2.getNextY());
                move(order2,head2);
                head1.setLocation(head1.getX()+head1.getNextX(),head1.getY()+head1.getNextY());
                move(order1,head1);
            }
            if(players==3) {
                head4.setLocation(head4.getX()+head4.getNextX(),head4.getY()+head4.getNextY());
                move(order4,head4);
                head3.setLocation(head3.getX()+head3.getNextX(),head3.getY()+head3.getNextY());
                move(order3,head3);
                head2.setLocation(head2.getX()+head2.getNextX(),head2.getY()+head2.getNextY());
                move(order2,head2);
                head1.setLocation(head1.getX()+head1.getNextX(),head1.getY()+head1.getNextY());
                move(order1,head1);
            }
            if(players==4) {
                head4.setLocation(head4.getX()+head4.getNextX(),head4.getY()+head4.getNextY());
                move(order4,head4);
                head3.setLocation(head3.getX()+head3.getNextX(),head3.getY()+head3.getNextY());
                move(order3,head3);
                head2.setLocation(head2.getX()+head2.getNextX(),head2.getY()+head2.getNextY());
                move(order2,head2);
                head1.setLocation(head1.getX()+head1.getNextX(),head1.getY()+head1.getNextY());
                move(order1,head1);
            }
*/
            repaint();
            //if (tempCollect)
                for (Head tempHead : getObjects(Head.class)) {
//                    if(tempCollect) {tempCollect=false;}
//                    else
                    if (getObjects(Head.class).size() > 1) {
                        if ((!tempHead.getIntersectingBody().isEmpty()) || (!(tempHead.getX() > 5 && tempHead.getX() < 780)) || (!(tempHead.getY() > 5 && tempHead.getY() < 565))) {
                            removeObject(tempHead);

                            /*if (tempHead.equals(head1)) {
                                removeObjects(order1);
                            }
                            if (tempHead.equals(head2)) {
                                removeObjects(order2);
                            }
                            if (tempHead.equals(head3)) {
                                removeObjects(order3);

                            }
                            if (tempHead.equals(head4)) {
                                removeObjects(order4);
                            }
                            */
                        }
                    }



                }
            if(getObjects(Head.class).size()<2&&end ==false)
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
                    //System.out.println("touch wall");


                }
                catch(Exception E)
                {

                }
                end = true;
            }
            //tempCollect = true;
            if(tempCollect)
            {
                Tailtime.reset();
                tempCollect = false;
            }

            time.reset();


        }
        if((mayflower.isKeyPressed(200)||mayflower.isKeyPressed(208)||mayflower.isKeyPressed(203)||mayflower.isKeyPressed(205))&&temp1) {tempPlayers++; temp1=false;}
        if((mayflower.isKeyPressed(25)||mayflower.isKeyPressed(39)||mayflower.isKeyPressed(38)||mayflower.isKeyPressed(40))&&temp2) {tempPlayers++; temp2=false;}
        if((mayflower.isKeyPressed(21)||mayflower.isKeyPressed(35)||mayflower.isKeyPressed(34)||mayflower.isKeyPressed(36))&&temp3) {tempPlayers++; temp3=false;}
        if((mayflower.isKeyPressed(17)||mayflower.isKeyPressed(31)||mayflower.isKeyPressed(30)||mayflower.isKeyPressed(32))&&temp4) {tempPlayers++; temp4=false;}
        if(Tailtime.isDone()&&!tempCollect)
        {
            if (four) addTail(order4, head4);
            if (three) addTail(order3, head3);
            if (two) addTail(order2, head2);
           if (one) addTail(order1, head1);
           Tailtime.reset();

        }




        //21, 35, 34, 36);
        //head1 = new Head(this, 17, 31, 30, 32);
    }


    public void move(ArrayList<Body> order, Head head)
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
    public void addTail(ArrayList<Body> order, Head head)
    {
        //System.out.print(order.size());

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



        if(four) {

            addObject(head4, 680, 480);
        }
        if(three) {

            addObject(head3, 100, 480);
        }
        if(two) {

            addObject(head2, 680, 100);
        }
        if(one) {

            addObject(head1, 100, 100);
        }


        Stage stage = (Stage) Exit.getScene().getWindow();
        stage.close();
    }



}
