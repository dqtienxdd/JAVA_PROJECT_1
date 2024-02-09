package Octagons;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class Octagon {
    private int x;
    private int y;
    private int width;
    private int height;
    private String name;
    private int index;

    public Image image;
    public boolean collision = false;
    public boolean isBackSide = true;

    public Octagon(String name, int index)
    {
        width =70;
        height = 70;
        this.name=name;
        this.index=index;
        setPicture("backside");
    }
    public boolean getIsBackSide()
    {
        return isBackSide;
    }
    public void setIsBackSide(boolean isBackSide)
    {
        this.isBackSide=isBackSide;
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
           image = ImageIO.read(getClass().getResourceAsStream("/res/octagonal_shape/"+name+".png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public boolean collision(int x_cursor, int y_cursor){
        Rectangle octagonRect= new Rectangle(x, y, width, height);
        return octagonRect.contains(x_cursor, y_cursor);
    }

    // public Image getPicture()
    // {
    //     try {
    //        image = ImageIO.read(getClass().getResourceAsStream("/res/octagonal_shape/"+name+".png"));
    //     } catch (Exception e) {
    //         e.printStackTrace();
    //     }
    //     return image;
    // }
    public Image getPicture()
    {
        return image;
    }
    int direction =1;
    public boolean flip()
    {
        width -=  30*direction;
        x += 15*direction;
        if(width <=0)
        {
            direction*=-1;
        }
        if(width==70 && direction == -1)
        {
            direction=1;
            isBackSide= !(isBackSide);
            return false;
        }
        // setWidth(getWidth()-30*direction);
        // setX(getX()+15*direction);
        
        // if(getWidth()<=0 || (getWidth()>=70))
        // {
        //     direction*=-1;
        // }    
        return true;
    }
    


}





