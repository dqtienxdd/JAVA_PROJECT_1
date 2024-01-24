package Entity;
import Main.GamePanel;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;



public class PLayerManager extends Entity {
    GamePanel gp;
    
    public MapCoordinate[] xy;
    
    public PLayerManager(GamePanel gp ){
        this.gp = gp;
        
        xy = new MapCoordinate[24];

        setDefaultValue();
        getPlayerImage();
    }
    public void setDefaultValue(){
        x = 100;
        y = 20;
        direction = "normal";
        for(int i=0; i<24; i++){
            xy[i] = new MapCoordinate(i,i);
            
        }
        for(int i=0; i<7; i++){
            xy[i].setX(x);
            xy[i].setY(y);
            x += 5 + gp.eggwidth;
        }
        for(int i=7; i>=7 &&i<12;i++){
            xy[i].setX(x);
            xy[i].setY(y);
            y += 5 + gp.eggheight;
        }   
        for(int i=12; i>=12 && i<19; i++){
            xy[i].setX(x);
            xy[i].setY(y);
            x -= 5 + gp.eggwidth;
        }
        for(int i=19; i>=19 &&i<=23;i++){
            xy[i].setX(x);
            xy[i].setY(y);
            y -= 5 + gp.eggheight;
        }  
    }
        
    public void getPlayerPosition(){
        
        
    }  
    public void getPlayerImage(){
        try{
            chick1 = ImageIO.read(getClass().getResourceAsStream("/res/chicken animation deluxe/BlueChicken/chickenpixel.png"));
            chick2 = ImageIO.read(getClass().getResourceAsStream("/res/chicken animation deluxe/BlueChicken/chickenpixel2.png"));
            chick3 = ImageIO.read(getClass().getResourceAsStream("/res/chicken animation deluxe/BlueChicken/chickenpixel3.png"));
            chick4 = ImageIO.read(getClass().getResourceAsStream("/res/chicken animation deluxe/BlueChicken/chickenpixel4.png"));
            chick5 = ImageIO.read(getClass().getResourceAsStream("/res/chicken animation deluxe/BlueChicken/chickenpixel3.png"));
            chick6 = ImageIO.read(getClass().getResourceAsStream("/res/chicken animation deluxe/YellowChicken/chickenpixel.png"));
            chick7 = ImageIO.read(getClass().getResourceAsStream("/res/chicken animation deluxe/YellowChicken/chickenpixel2.png"));
            chick8 = ImageIO.read(getClass().getResourceAsStream("/res/chicken animation deluxe/YellowChicken/chickenpixel3.png"));
            chick9 = ImageIO.read(getClass().getResourceAsStream("/res/chicken animation deluxe/YellowChicken/chickenpixel4.png"));
            chick10 = ImageIO.read(getClass().getResourceAsStream("/res/chicken animation deluxe/YellowChicken/chickenpixel3.png"));
            chick11 = ImageIO.read(getClass().getResourceAsStream("/res/chicken animation deluxe/WhiteChicken/chickenpixel.png"));
            chick12 = ImageIO.read(getClass().getResourceAsStream("/res/chicken animation deluxe/WhiteChicken/chickenpixel2.png"));
            chick13 = ImageIO.read(getClass().getResourceAsStream("/res/chicken animation deluxe/WhiteChicken/chickenpixel3.png"));
            chick14 = ImageIO.read(getClass().getResourceAsStream("/res/chicken animation deluxe/WhiteChicken/chickenpixel4.png"));
            chick15 = ImageIO.read(getClass().getResourceAsStream("/res/chicken animation deluxe/WhiteChicken/chickenpixel3.png"));
            chick16 = ImageIO.read(getClass().getResourceAsStream("/res/chicken animation deluxe/RedChicken/chickenpixel.png"));
            chick17 = ImageIO.read(getClass().getResourceAsStream("/res/chicken animation deluxe/RedChicken/chickenpixel2.png"));
            chick18 = ImageIO.read(getClass().getResourceAsStream("/res/chicken animation deluxe/RedChicken/chickenpixel3.png"));
            chick19 = ImageIO.read(getClass().getResourceAsStream("/res/chicken animation deluxe/RedChicken/chickenpixel4.png"));
            chick20 = ImageIO.read(getClass().getResourceAsStream("/res/chicken animation deluxe/RedChicken/chickenpixel3.png"));
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void playermovement(){
        playerposition1=(playerposition1+1)%24;
        bluefeathertrack = playerposition1;
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
        BufferedImage blue = null;
        BufferedImage yellow = null;
        BufferedImage white = null;
        BufferedImage red = null;
        switch (direction) {
            case "normal":
                if(spriteNum==1){
                    blue = chick1;
                    yellow = chick6;
                    white = chick11;
                    red = chick16;
                }
                if(spriteNum==2){
                    blue = chick2;
                    yellow = chick7;
                    white = chick12;
                    red = chick17;
                }
                if(spriteNum==3){
                    blue = chick3;
                    yellow = chick8;
                    white = chick13;
                    red = chick18;
                }
                if(spriteNum==4){
                    blue = chick4;
                    yellow = chick9;
                    white = chick14;
                    red = chick19;
                }
                if(spriteNum==5){
                    blue = chick5;
                    yellow = chick10;
                    white = chick15;
                    red = chick20;
                }
                if(spriteNum>=6 &&spriteNum<=8){
                    blue = chick1;
                    yellow = chick6;
                    white = chick11;
                    red = chick16;
                }
                break;
        
            default:
                break;
        }
        
        g2.drawImage(blue, xy[playerposition1].getX() , xy[playerposition1].getY(), gp.chickensize, gp.chickensize, null);
        g2.drawImage(yellow, xy[playerposition2].getX() , xy[playerposition2].getY(), gp.chickensize, gp.chickensize, null);
        g2.drawImage(white, xy[playerposition3].getX() , xy[playerposition3].getY(), gp.chickensize, gp.chickensize, null);
        g2.drawImage(red, xy[playerposition4].getX() , xy[playerposition4].getY(), gp.chickensize, gp.chickensize, null);
        
    }
}
