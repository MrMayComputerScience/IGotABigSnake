import java.util.List;

public class SnakeManager {
    //list of snakes,
    public SnakeManager(Snake snake, String action)
    {
        if(action.equals("goUp"))snake.goUp();
        System.out.println("ran");
        if(action.equals("goDown"))snake.goDown();
        if(action.equals("goLeft"))snake.goLeft();
        if(action.equals("goRight"))snake.goRight();
        System.out.print("worked");

    }
    public SnakeManager(List<Snake> snakeList)
    {
        System.out.print("running");
    }

    

}
