import mayflower.World;

import java.util.List;

public abstract class AbstractGameModeManager {
    private List<Snake> snakes;
    private World SnakeWorld;
    public List<Snake> getSnakes()
    {
        return snakes;
    }
    public Snake getSnake(int index)
    {
        return snakes.get(index);

    }
    public World getWorld()
    {
        return SnakeWorld;

    }
    public void addSnake(Snake snake)
    {
        snakes.add(snake);
    }
    public void setWorld(World world)
    {
        SnakeWorld=world;
    }
    public abstract void process(String action);
}
