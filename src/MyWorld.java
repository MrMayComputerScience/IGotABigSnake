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


public class MyWorld extends World {

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

    private static Collectable collect;
    private static ArrayList<Body> order;
    @FXML
    private static Label label;



    private boolean pause;

    @FXML
    int score;

    @FXML private static int S;

    public MyWorld()
    {
        //score = 0;
        highscore = new ArrayList<String>();

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
            System.out.println(score);
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
    @FXML
    public void again()
    {
        for (Body body : order) {
            order.remove(body);
        }
        removeObjects(getObjects(Body.class));

        //collect.resetScore();
        score =0;
        //head.setGameOver(false);
        head.setLocation(100,100);

        Stage stage = (Stage) Exit.getScene().getWindow();
        stage.close();
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








}
