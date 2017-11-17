
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableSet;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import mayflower.Mayflower;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class gameoverController{
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
    private static ArrayList<Body> order;
    private static MyWorld thisWorld;


//    public gameoverController(MyWorld world)
//    {
//        thisWorld = world;
//    }
    @FXML
    public static void loadWorld(MyWorld world)
    {
        thisWorld = world;
    }


    @FXML
    public void initialize() throws IOException {

        highscore = new ArrayList<String>();
        order=thisWorld.getOrder();

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



    }
    @FXML
    public void again()
    {

//        thisWorld.removeObjects(thisWorld.getObjects(Body.class));

        //collect.resetScore();
        thisWorld.head.score =0;
        //head.setGameOver(false);
        thisWorld.head.setLocation(100,100);

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
        //System.out.println("SCORE"+thisWorld.score);




        if(!name.isEmpty()) {
            try (
                    FileWriter fw = new FileWriter("highscore.txt", true);
                    BufferedWriter bw = new BufferedWriter(fw);
                    PrintWriter out = new PrintWriter(bw)) {
                out.println(thisWorld.score + " " + name);

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


        //System.out.print(highscore);


    }






}
