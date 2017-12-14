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

public class LocalMultiplayerWorld extends World {
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

    private static Collectable collect;
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

    public LocalMultiplayerWorld(boolean one, boolean two, boolean three, boolean four)
    {
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

        setBackground("Grid.png");


        //get key codes
        //this.players = 4;
        head4 = new Head(this, 200, 208, 203, 205);

        head3 = new Head(this, 25, 39, 38, 40);
        head2 = new Head(this, 21, 35, 34, 36);
        head1 = new Head(this, 17, 31, 30, 32);


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

        collect = new Collectable(this);

        order1 = new ArrayList<>();
        order2 = new ArrayList<>();
        order3 = new ArrayList<>();
        order4 = new ArrayList<>();


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
            if(players==1) {
                head4.setLocation(head4.getX()+head4.getNextX(),head4.getY()+head4.getNextY());
                move(order4,head4);
                head3.setLocation(head3.getX()+head3.getNextX(),head3.getY()+head3.getNextY());
                move(order3,head3);
                head2.setLocation(head2.getX()+head2.getNextX(),head2.getY()+head2.getNextY());
                move(order2,head2);
                head1.setLocation(head1.getX()+head1.getNextX(),head1.getY()+head1.getNextY());
                move(order1,head1);
            }
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

            repaint();

            time.reset();
        }
        for (Head head:collect.getIntersectingHead(Head.class))
        {
            if(head.equals(head1))
            {
                addTail(order1, head);
                addTail(order1, head);
                addTail(order1, head);
            }
            if(head.equals(head2))
            {
                addTail(order2, head);
                addTail(order2, head);
                addTail(order2, head);
            }
            if(head.equals(head3))
            {
                addTail(order3, head);
                addTail(order3, head);
                addTail(order3, head);
            }
            if(head.equals(head4))
            {
                addTail(order4, head);
                addTail(order4, head);
                addTail(order4, head);
            }


            placement();
            //collect.scoreNum +=3;

        }

        for (Head tempHead :getObjects(Head.class))
        {
            //System.out.println("size of head:"+getObjects(Head.class).size());
            if(getObjects(Head.class).size()>1) {
                if ((!tempHead.getIntersectingBody().isEmpty())||(!(tempHead.getX()>5&&tempHead.getX()<780))||(!(tempHead.getY()>5&&tempHead.getY()<565))) {
                    removeObject(tempHead);

                    if(tempHead.equals(head1))
                    {
                     removeObjects(order1);
                    }
                    if(tempHead.equals(head2))
                    {
                        removeObjects(order2);

                    }
                    if(tempHead.equals(head3))
                    {
                        removeObjects(order3);

                    }
                    if(tempHead.equals(head4))
                    {
                        removeObjects(order4);

                    }



                }

            }
            if(getObjects(Head.class).size()<2&&end ==false)
            {
                Application Gameover = new  Application() {
                    @Override
                    public void start(Stage stage) throws Exception {
                        //System.out.println("trun");
                        Parent root = FXMLLoader.load(getClass().getResource("over.fxml"));
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

        //collect.resetScore();
        score =0;
        //head.setGameOver(false);
        if(players==1) {
            head1.setLocation(100,100);

        }
        if(players==2) {
            head2.setLocation(700,100);

            head1.setLocation(100,100);

        }
        if(players==3) {
            head3.setLocation(100,500);

            head2.setLocation(700,100);

            head1.setLocation(100,100);

        }
        if(players==4) {
            head4.setLocation(700,500);

            head3.setLocation(100,500);

            head2.setLocation(700,100);

            head1.setLocation(100,100);

        }


        Stage stage = (Stage) Exit.getScene().getWindow();
        stage.close();
    }



}
