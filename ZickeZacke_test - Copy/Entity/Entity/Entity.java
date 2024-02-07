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
    public BufferedImage warning, warning2;
    public BufferedImage chick1,chick2,chick3,chick4,chick5;
    public BufferedImage chick6,chick7,chick8,chick9,chick10;
    public BufferedImage chick11,chick12,chick13,chick14,chick15;
    public BufferedImage chick16,chick17,chick18,chick19,chick20;
    public BufferedImage feather1, feather2, feather3, feather4, feather5;
    public BufferedImage arrowdown_down, arrowdown_up,
                         arrowleft_left, arrowleft_right,
                         arrowright_left, arrowright_right,
                         arrowup_down, arrowup_up;
    public BufferedImage victory_up, victory_down;
    public String end;
    public String direction;
    public String direction2;
    public int spriteCounter=0;
    public int spriteNum=1;
    public int arrowCounter=0;
    public int arrowNum=1;
    public int endCounter = 0;
    public int endNum = 1;
    public MapCoordinate[] xy;
    public int playerposition1=0;
    public int playerposition2=6;
    public int playerposition3=12;
    public int playerposition4=18;
    public int bluefeathertrack=0;
    public int yellowfeathertrack=6;
    public int whitefeathertrack=12;
    public int redfeathertrack=18;
    
    
    //list of players
    public static Player[] players;
    public static Feather[] feathers;
    public static Feather[] drawfeathers;
    public boolean start;
    public void setDefault(boolean start){
        if(start==true){
            playerposition1=0;
            playerposition2=6;
            playerposition3=12;
            playerposition4=18;
            bluefeathertrack=0;
            yellowfeathertrack=6;
            whitefeathertrack=12;
            redfeathertrack=18;
    }
        }
        
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
