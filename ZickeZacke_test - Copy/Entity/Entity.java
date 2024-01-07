package Entity;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
public class Entity {
    public BufferedImage image;
    public boolean collision = false;
    public int x, y;
    public int speed;
    public BufferedImage chick1,chick2,chick3,chick4,chick5;
    public BufferedImage feather1, feather2, feather3, feather4, feather5;
    public String direction;
    public int spriteCounter=0;
    public int spriteNum=1;
    
    public Image setPicture(String name)
    {
        try {
           image = ImageIO.read(getClass().getResourceAsStream("/res/chicken animation deluxe/Feather/"+name+".png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return image;
    }
    
}
