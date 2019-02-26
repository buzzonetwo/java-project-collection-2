package x;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.imageio.ImageIO;

public class PrintPixels
{
  public static void main(String[] paramArrayOfString)
    throws Exception
  {
    String str = null;
    if (paramArrayOfString.length == 0)
    {
      System.out.print("Image: ");
      str = new Scanner(System.in).nextLine();
    }
    else
    {
      str = paramArrayOfString[0];
    }
    PrintWriter localPrintWriter = new PrintWriter("out.txt");
    localPrintWriter.println(ppm(ImageIO.read(new File(str))));
    localPrintWriter.close();
    System.out.println("Saved to out.txt");
  }
  
  public static String ppm(BufferedImage paramBufferedImage)
  {
    String str = "";
    for (int i = 0; i < paramBufferedImage.getHeight(); i++) {
      for (int j = 0; j < paramBufferedImage.getWidth(); j++)
      {
        Color localColor = new Color(paramBufferedImage.getRGB(i, j));
        str = str + "[" + i + ", " + j + "] :: (" + localColor.getRed() + " " + localColor.getGreen() + " " + localColor.getBlue() + ")\n";
      }
    }
    return str;
  }
}
