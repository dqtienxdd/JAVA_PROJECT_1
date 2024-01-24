package Entity;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import Main.GamePanel;
public class Entity {
    GamePanel gp;
    public BufferedImage image;
    public int playerposition=0;
    public boolean collision = false;
    public int x, y;
    public int speed;
    public BufferedImage chick1,chick2,chick3,chick4,chick5;
    public BufferedImage feather1, feather2, feather3, feather4, feather5;
    public String direction;
    public int spriteCounter=0;
    public int spriteNum=1;
    public MapCoordinate[] xy;
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
    public void getPlayerPosition(){
        for(int i=0; i<12; i++){
            xy[i] = new MapCoordinate(i,i);
        }
        xy[0].setX(100);
        xy[0].setY(20);
        xy[1].setX(100+gp.eggwidth+5);
        xy[1].setY(20);
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
