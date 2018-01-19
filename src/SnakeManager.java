import java.util.List;

public class SnakeManager {
    //list of snakes,
    public SnakeManager(Snake snake, String action)
    {
        if(action.equals("goUp"))snake.goUp();
        if(action.equals("goDown"))snake.goDown();
        if(action.equals("goLeft"))snake.goLeft();
        if(action.equals("goRight"))snake.goRight();

    }
    public SnakeManager(List<Snake> snakeList)
    {

    }

    

}
