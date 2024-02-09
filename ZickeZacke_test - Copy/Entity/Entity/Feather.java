package Entity;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import Main.GamePanel;
public class Feather {
    GamePanel gp;
    int x,y;
    BufferedImage image;
    private int width;
    private int height;
    private String name;
    public int position;
    public int index;
    
    public Feather(String name, int position, int index)
    {
        width = 90;
        height = 90;
        this.name=name;
        this.position=position;
        this.index=index;
    }
    public int getIndex() {
        return index;
    }
    public void setIndex(int index) {
        this.index = index;
    }
    public int getPosition() {
        return position;
    }
    public void setPosition(int position) {
        this.position = position;
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
    public BufferedImage setPicture(String name)
    {
        try {
           image = ImageIO.read(getClass().getResourceAsStream("/res/chicken animation deluxe/Feather/"+name+".png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return image;
    }
}
