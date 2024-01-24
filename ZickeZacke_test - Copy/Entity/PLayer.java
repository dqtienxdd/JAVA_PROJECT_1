package Entity;
import Main.GamePanel;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;



public class PLayer extends Entity {
    GamePanel gp;
    int x,y;
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
    
    public PLayer(GamePanel gp ){
        this.gp = gp;
        
        xy = new MapCoordinate[24];

        setDefaultValue();
        getPlayerImage();
    }
    public void setDefaultValue(){
        
        direction = "normal";
    }
    public void getPlayerImage(){
        try{
            chick1 = ImageIO.read(getClass().getResourceAsStream("/res/chicken animation deluxe/BlueChicken/chickenpixel.png"));
            chick2 = ImageIO.read(getClass().getResourceAsStream("/res/chicken animation deluxe/BlueChicken/chickenpixel2.png"));
            chick3 = ImageIO.read(getClass().getResourceAsStream("/res/chicken animation deluxe/BlueChicken/chickenpixel3.png"));
            chick4 = ImageIO.read(getClass().getResourceAsStream("/res/chicken animation deluxe/BlueChicken/chickenpixel4.png"));
            chick5 = ImageIO.read(getClass().getResourceAsStream("/res/chicken animation deluxe/BlueChicken/chickenpixel3.png"));
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public MapCoordinate[] getArray(){
        return xy;
    }
    public void update(){
        if(gp.gameState == gp.playState){
            direction = "normal";
        }else{
            direction = "off";
        }
        if(gp.gameState == gp.playState){
            spriteCounter++;
        }
       
        if(spriteCounter > 20){
            if(spriteNum == 1){
                spriteNum=2;
            }
            else if(spriteNum == 2){
                spriteNum=3;
            }
            else if(spriteNum == 3){
                spriteNum=4;
            }
            else if(spriteNum == 4){
                spriteNum=5;
            }
            else if(spriteNum == 5){
                spriteNum=6;
            }
            else if(spriteNum == 6){
                spriteNum=7;
            }
            else if(spriteNum == 7){
                spriteNum=8;
            }
            else if(spriteNum == 8){
                spriteNum=1;
            }
            spriteCounter = 0;
            
        }
        
    }
    public void draw(Graphics2D g2){
        int num;
        BufferedImage image = null;
        switch (direction) {
            case "normal":
                if(spriteNum==1){
                    image = chick1;
                }
                if(spriteNum==2){
                    image = chick2;
                }
                if(spriteNum==3){
                    image = chick3;
                }
                if(spriteNum==4){
                    image = chick4;
                }
                if(spriteNum==5){
                    image = chick5;
                }
                if(spriteNum>=6 &&spriteNum<=8){
                    image = chick1;
                }
                break;
        
            default:
                break;
        }
        num=1;
        g2.drawImage(image, xy[num].getX() , xy[num].getY(), gp.chickensize, gp.chickensize, null);
    
    }
}
