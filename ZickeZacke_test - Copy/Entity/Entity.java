package Entity;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import Main.GamePanel;
public class Entity {
    GamePanel gp;
    public BufferedImage image;
    public boolean collision = false;
    public int x,y;
    public int x2,y2;
    public int x3,y3;
    public int x4,y4;
    public int speed;
    public BufferedImage chick1,chick2,chick3,chick4,chick5;
    public BufferedImage feather1, feather2, feather3, feather4, feather5;
    public String direction;
    public int spriteCounter=0;
    public int spriteNum=1;
    public MapCoordinate[] xy;
    public int playerposition1=19;
    public int playerposition2=0;
    public int playerposition3=0;
    public int playerposition4=0;
    public void setX(int x)
    {
        this.x=x;
    }
    public void setY(int y)
    {
        this.y=y;
    }
    public int getX() {
        return x;
    }
 
    public int getY() {
        return y;
    }
    
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
