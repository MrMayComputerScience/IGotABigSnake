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

public class miceWorld extends World {
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


    private Head head;


    private Mayflower mayflower;
    private Timer time;

    private static movableCollectable collect1, collect2, collect3, collect4;
    private static ArrayList<Body> order;

    @FXML
    private static Label label;



    private boolean pause;
    private boolean end;

    @FXML
    int score;

    @FXML private static int S;

    private int players;


    private boolean one, two, three, four;
    private boolean oneHead, twoHead, threeHead, fourHead;
    private int X;
    Wall leftWall;
    Wall rightWall;
    Wall topWall;
    Wall bottomWall;

    private Portal portal;
    private toPortal toportal;

    private int overScreen;
    private boolean isPortal;

    private boolean temp1, temp2, temp3,temp4;
    private int tempPlayers;

    private String theme;

    private boolean portals;

    public miceWorld(String theme, boolean portal, boolean one, boolean two, boolean three, boolean four)
    {
        this.portals = portal;
        this.theme = theme;
        tempPlayers = 0;
        temp1 = true;
        temp2 = true;
        temp3 = true;
        temp4 = true;

        isPortal = portal;

        this.one = one;
        this.two = two;
        this.three = three;
        this.four = four;


        end = false;

        if(one)this.players++;
        if(two)this.players++;
        if(three)this.players++;
        if(four)this.players++;
        oneHead = twoHead = threeHead = fourHead = false;



        //score = 0;
        highscore = new ArrayList<String>();

        setBackground(theme+"Grid.png");


        //get key codes
        //this.players = 4;
        //head = new twitchHead(this, one,two,three,four);

        //addObject(head,100,100);
    System.out.println(theme);
    System.out.println(theme+"collectable.png");
         collect1 = new movableCollectable(this, 17, 31, 30, 32);
         collect1.setImage(theme+"collectable.png");

         collect2 = new movableCollectable(this, 21, 35, 34, 36);
        collect2.setImage(theme+"collectable2.png");

         collect3 = new movableCollectable(this, 25, 39, 38, 40);
        collect3.setImage(theme+"collectable3.png");

         collect4 = new movableCollectable(this, 200, 208, 203, 205);
        collect4.setImage(theme+"collectable4.png");







        //collect = new Collectable(this);



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
        repaint();



       /*if(this.players==1) {
            X = mayflower.getRandomNumber(0);
            System.out.println(X);

            if(four) {
                if(X==3) {
                    System.out.println(X);
                    head = new Head(this, 200, 208, 203, 205);
                    addObject(head, 680,480);
                    fourHead = true;
                }
                else addObject(collect4, 680, 480);
            }
            if(three) {
                if(X==2) {
                    head = new Head(this, 25, 39, 38, 40);
                    addObject(head, 100,480);
                    threeHead =true;
                }
                else addObject(collect3, 100, 480);
            }
            if(two) {
                if(X==1) {
                    head = new Head(this, 21, 35, 34, 36);
                    addObject(head, 680,100);
                    twoHead = true;
                }
                else addObject(collect2, 680, 100);
            }
            if(one) {
                if(X==0) {
                    head = new Head( this, 17, 31, 30, 32);
                    addObject(head, 100,100);
                    oneHead = true;
                }
                else addObject(collect1, 100, 100);
            }

        }
        */
        if(this.players==2) {
            //yhgj

            while(getObjects(Head.class).size()==0 && !(getObjects(movableCollectable.class).size()==(this.players-1))) {
                X = mayflower.getRandomNumber(3);


                if (four) {
                    if (X == 3) {
                        head = new Head(theme, this, 200, 208, 203, 205);
                        addObject(head, 680, 480);
                        fourHead = true;
                    } else addObject(collect4, 680+1, 480+1);
                }
                if (three) {
                    if (X == 2) {
                        head = new Head(theme, this, 25, 39, 38, 40);
                        addObject(head, 100, 480);
                        threeHead = true;
                    } else addObject(collect3, 100+1, 480+1);
                }
                if (two) {
                    if (X == 1) {
                        head = new Head(theme, this, 21, 35, 34, 36);
                        addObject(head, 680, 100);
                        twoHead = true;
                    } else addObject(collect2, 680+1, 100+1);
                }
                if (one) {
                    if (X == 0) {
                        head = new Head(theme, this, 17, 31, 30, 32);
                        addObject(head, 100, 100);
                        oneHead = true;
                    } else addObject(collect1, 100+1, 100+1);
                }
            }
        }
        else
        if(this.players==3) {
            //p;l'
            while(getObjects(Head.class).size()==0 && !(getObjects(movableCollectable.class).size()==(this.players-1))) {
                X = mayflower.getRandomNumber(3);

                if (four) {
                    if (X == 3) {
                        head = new Head(theme, this, 200, 208, 203, 205);
                        addObject(head, 680, 480);
                        fourHead = false;
                    } else addObject(collect4, 680, 480);
                }
                if (three) {
                    if (X == 2) {
                        head = new Head(theme, this, 25, 39, 38, 40);
                        addObject(head, 100, 480);
                        threeHead = true;
                    } else addObject(collect3, 100, 480);
                }
                if (two) {
                    if (X == 1) {
                        head = new Head(theme, this, 21, 35, 34, 36);
                        addObject(head, 680, 100);
                        twoHead = true;
                    } else addObject(collect2, 680, 100);
                }
                if (one) {
                    if (X == 0) {
                        head = new Head(theme, this, 17, 31, 30, 32);
                        addObject(head, 100, 100);
                        oneHead = true;
                    } else addObject(collect1, 100, 100);
                }
            }
            if(portal) {
                this.portal = new Portal(theme,this);
                this.toportal = new toPortal(theme);

                addObject(this.portal, 20 * 20 + 1, 20 * 20 + 1);
                addObject(this.toportal, 5 * 20 + 1, 5 * 20 + 1);
                portalPlacement();
                toportalPlacement();
            }

        }
        else
        if(this.players==4) {
            while (getObjects(Head.class).size() == 0 && !(getObjects(movableCollectable.class).size() == (this.players - 1))) {
                X = mayflower.getRandomNumber(3);

                if (four) {
                    if (X == 3) {
                        head = new Head(theme, this, 200, 208, 203, 205);
                        addObject(head, 680, 480);
                        fourHead = false;
                    } else addObject(collect4, 680, 480);
                }
                if (three) {
                    if (X == 2) {
                        head = new Head(theme, this, 25, 39, 38, 40);
                        addObject(head, 100, 480);
                        threeHead = true;
                    } else addObject(collect3, 100, 480);
                }
                if (two) {
                    if (X == 1) {
                        head = new Head(theme, this, 21, 35, 34, 36);
                        addObject(head, 680, 100);
                        twoHead = true;
                    } else addObject(collect2, 680, 100);
                }
                if (one) {
                    if (X == 0) {
                        head = new Head(theme, this, 17, 31, 30, 32);
                        addObject(head, 100, 100);
                        oneHead = true;
                    } else addObject(collect1, 100, 100);
                }
            }
        }

    }

    public void act()
    {
        if(tempPlayers>=players)
        if(time.isDone()&&!pause)
        {
            if(isPortal)
                portal.teleport(toportal.getX(),toportal.getY());

            head.setLocation(head.getX()+head.getNextX(),head.getY()+head.getNextY());
            for (movableCollectable temp:getObjects(movableCollectable.class)) {

                temp.setLocation(temp.getX() + temp.getNextX(), temp.getY() + temp.getNextY());

                if(temp.getY()<5)
                    temp.setLocation(temp.getX(), temp.getY() + 20);
                if(temp.getY()>580)
                    temp.setLocation(temp.getX(), temp.getY() - 20);
                if(temp.getX()<5)
                    temp.setLocation(temp.getX() + 20, temp.getY());
                if(temp.getX()>780)
                    temp.setLocation(temp.getX() - 20, temp.getY());

            }
            move(order,head);
            repaint();

            time.reset();
        }
        if((mayflower.isKeyPressed(200)||mayflower.isKeyPressed(208)||mayflower.isKeyPressed(203)||mayflower.isKeyPressed(205))&&temp1) {tempPlayers++; temp1=false;}
        if((mayflower.isKeyPressed(25)||mayflower.isKeyPressed(39)||mayflower.isKeyPressed(38)||mayflower.isKeyPressed(40))&&temp2) {tempPlayers++; temp2=false;}
        if((mayflower.isKeyPressed(21)||mayflower.isKeyPressed(35)||mayflower.isKeyPressed(34)||mayflower.isKeyPressed(36))&&temp3) {tempPlayers++; temp3=false;}
        if((mayflower.isKeyPressed(17)||mayflower.isKeyPressed(31)||mayflower.isKeyPressed(30)||mayflower.isKeyPressed(32))&&temp4) {tempPlayers++; temp4=false;}
        for (  movableCollectable collectable:head.getIntersectingMovable())
        {
                removeObject(collectable);
                addTail(order, this.head);
                addTail(order, this.head);
                addTail(order, this.head);
        }
        if ((!head.getIntersectingBody().isEmpty())||(!(head.getX()>5&&head.getX()<780))||(!(head.getY()>5&&head.getY()<565))) {
                removeObject(head);
                removeObjects(order);
                System.out.println("removed");

        }
        if(end==false && getObjects(Head.class).size()<1 )
        {
            //System.out.println("exit");

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


        if(this.players==2) {
            //yhgj

            while(getObjects(Head.class).size()==0 && !(getObjects(movableCollectable.class).size()==(this.players-1))) {
                X = mayflower.getRandomNumber(3);


                if (four) {
                    if (X == 3) {
                        head = new Head(theme, this, 200, 208, 203, 205);
                        addObject(head, 680, 480);
                        fourHead = true;
                    } else addObject(collect4, 680+1, 480+1);
                }
                if (three) {
                    if (X == 2) {
                        head = new Head(theme, this, 25, 39, 38, 40);
                        addObject(head, 100, 480);
                        threeHead = true;
                    } else addObject(collect3, 100+1, 480+1);
                }
                if (two) {
                    if (X == 1) {
                        head = new Head(theme, this, 21, 35, 34, 36);
                        addObject(head, 680, 100);
                        twoHead = true;
                    } else addObject(collect2, 680+1, 100+1);
                }
                if (one) {
                    if (X == 0) {
                        head = new Head(theme, this, 17, 31, 30, 32);
                        addObject(head, 100, 100);
                        oneHead = true;
                    } else addObject(collect1, 100+1, 100+1);
                }
            }
        }
        else
        if(this.players==3) {
            //p;l'
            while(getObjects(Head.class).size()==0 && !(getObjects(movableCollectable.class).size()==(this.players-1))) {
                X = mayflower.getRandomNumber(3);

                if (four) {
                    if (X == 3) {
                        head = new Head(theme, this, 200, 208, 203, 205);
                        addObject(head, 680, 480);
                        fourHead = false;
                    } else addObject(collect4, 680, 480);
                }
                if (three) {
                    if (X == 2) {
                        head = new Head(theme, this, 25, 39, 38, 40);
                        addObject(head, 100, 480);
                        threeHead = true;
                    } else addObject(collect3, 100, 480);
                }
                if (two) {
                    if (X == 1) {
                        head = new Head(theme, this, 21, 35, 34, 36);
                        addObject(head, 680, 100);
                        twoHead = true;
                    } else addObject(collect2, 680, 100);
                }
                if (one) {
                    if (X == 0) {
                        head = new Head(theme, this, 17, 31, 30, 32);
                        addObject(head, 100, 100);
                        oneHead = true;
                    } else addObject(collect1, 100, 100);
                }
            }
            if(portals) {
                this.portal = new Portal(theme,this);
                this.toportal = new toPortal(theme);

                addObject(this.portal, 20 * 20 + 1, 20 * 20 + 1);
                addObject(this.toportal, 5 * 20 + 1, 5 * 20 + 1);
                portalPlacement();
                toportalPlacement();
            }

        }
        else
        if(this.players==4) {
            while (getObjects(Head.class).size() == 0 && !(getObjects(movableCollectable.class).size() == (this.players - 1))) {
                X = mayflower.getRandomNumber(3);

                if (four) {
                    if (X == 3) {
                        head = new Head(theme, this, 200, 208, 203, 205);
                        addObject(head, 680, 480);
                        fourHead = false;
                    } else addObject(collect4, 680, 480);
                }
                if (three) {
                    if (X == 2) {
                        head = new Head(theme, this, 25, 39, 38, 40);
                        addObject(head, 100, 480);
                        threeHead = true;
                    } else addObject(collect3, 100, 480);
                }
                if (two) {
                    if (X == 1) {
                        head = new Head(theme, this, 21, 35, 34, 36);
                        addObject(head, 680, 100);
                        twoHead = true;
                    } else addObject(collect2, 680, 100);
                }
                if (one) {
                    if (X == 0) {
                        head = new Head(theme, this, 17, 31, 30, 32);
                        addObject(head, 100, 100);
                        oneHead = true;
                    } else addObject(collect1, 100, 100);
                }
            }
        }



        //collect.resetScore();
        score =0;
        //head.setGameOver(false);

            head.setLocation(100,100);




        Stage stage = (Stage) Exit.getScene().getWindow();
        stage.close();
    }



}
