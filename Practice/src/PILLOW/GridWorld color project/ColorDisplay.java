import info.gridworld.grid.*;
import java.awt.Color;
import info.gridworld.world.*;

public class ColorDisplay
{
    private World<Color> world;

    public ColorDisplay(Grid<Color> gr)
    {
        world = new World<Color>(gr);
    }
    
    public void display()
    {
        world.show();
    }
}
