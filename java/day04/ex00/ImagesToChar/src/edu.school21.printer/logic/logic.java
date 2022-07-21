package ImagesToChar.src.edu.school21.printer.logic;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class logic {
    private String _name;
    public logic(String NameFile)
    {
        _name = NameFile;
    }

    public void print()
    {
        try {
            BufferedImage image = ImageIO.read(new File(_name));
            for(int i = 0; i < image.getWidth(); i++)
            {
                for (int j = 0; j < image.getHeight(); j++)
                {
                    if (image.getRGB(j, i) == Color.BLACK.getRGB())
                        System.out.print("0");
                    else
                        System.out.print(".");

                }
                System.out.println();
            }
        }
        catch (Exception e)
        {
            System.out.println(e.toString());
        }

    }

}
