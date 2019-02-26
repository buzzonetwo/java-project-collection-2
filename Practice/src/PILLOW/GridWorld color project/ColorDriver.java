import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JFrame;

import info.gridworld.grid.*;
import info.gridworld.grid.Location;

public class ColorDriver
{
  public static void main(String[] args)
  {
    BoundedGrid<Color> gr = new BoundedGrid<Color>(10,10);
    ColorDisplay screen = new ColorDisplay(gr);

    /////////////////// Remove the sample code and put your code here //////
    for (int row=0; row < gr.getNumRows(); row++)
    {
        for (int col = 0; col < gr.getNumCols(); col++)
        {
            gr.put(new Location(row,col), Color.RED);
        }
    }   
    screen.display();
    
    try
    {
        Thread.sleep(3000);
    } catch (InterruptedException ex){};
    
    for (int row=0; row < gr.getNumRows(); row++)
    {
         gr.remove(new Location(row, row));
    }
    screen.display(); 
    ///////////////////   End of your own code   ////////
  }

  
}