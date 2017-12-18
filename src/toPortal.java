import mayflower.Actor;
import mayflower.Mayflower;
import mayflower.MayflowerImage;

import java.util.List;

public class toPortal extends Actor {

    private MayflowerImage img;
    public toPortal(String theme)
    {
        img = new MayflowerImage(theme + "toportal.png");
        setImage(img);
        scale(.9);
    }

    @Override
    public void act() {

    }

}
