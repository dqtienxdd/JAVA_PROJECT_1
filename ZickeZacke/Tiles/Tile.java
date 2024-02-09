package Tiles;

import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Tile {
    private int x;
    private int y;
    private int width;
    private int height;
    private String name;
    private int index;
    public Image image;

    
    
    public Tile(String name,int index)
    {
        this.index=index;
        this.name=name;
        setPicture(name);
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getX()
    {
        return this.x;
    }
    public int getIndex()
    {
        return this.index;
    }
    public int getY()
    {
        return this.y;
    }
    
    public String getName()
    {
        return name; 
    }
    public void setX(int x)
    {
        this.x=x;
    }
    public void setY(int y)
    {
        this.y=y;
    }
    public void setWidth(int width)
    {
        this.width=width;
    }
    public void setHeight(int height)
    {
        this.height=height;
    }
    public int getWidth()
    {
        return this.width;
    }
    public int getHeight()
    {
        return this.height;
    }
    public void setPicture(String name)
    {
        try {
           image = ImageIO.read(getClass().getResourceAsStream("/res/Tile/"+name+".png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public Image getPicture()
    {
        return image;
    }
    
    public boolean collision = false;

}
