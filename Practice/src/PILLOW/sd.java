package PILLOW;

public class sd {
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
