package Entity;

import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import Main.GamePanel;

public class Feather {
    GamePanel gp;
    
    BufferedImage image;
    private int width;
    private int height;
    private String name;
    private int index;
    public Feather(String name, int index)
    {
        width = 90;
        height = 90;
        this.name=name;
        this.index=index;
        
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
