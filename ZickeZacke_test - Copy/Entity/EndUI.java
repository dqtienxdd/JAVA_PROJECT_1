package Entity;
import Main.GamePanel;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Arrays;

import javax.imageio.ImageIO;



public class EndUI extends Entity {
    GamePanel gp;
    PLayerManager p;
    FeatherManager f;
  
    public MapCoordinate[] xy;
    Feather[] feathers = FeatherManager.getArray();
    
    public EndUI(GamePanel gp ){
        this.gp = gp;
        
        xy = new MapCoordinate[24];
        
        setDefaultValue();
        getEndImage();
    }
    public static Player[] getArray()
    {
        return players;
    }
    public void setDefaultValue(){
        x = 408;
        y = 100;
        end = "normal";
        
    }

         
    public void getEndImage(){
        try{
            victory_up = ImageIO.read(getClass().getResourceAsStream("/res/victory animation/victory_up.png"));
            victory_down= ImageIO.read(getClass().getResourceAsStream("/res/victory animation/victory_down.png"));
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
    public void update(){
        
        if(gp.gameState == gp.endState){
            end = "normal";
        }else{
            end = "off";
        }
        if(gp.gameState == gp.endState){
            endCounter++;
            spriteCounter++;
        }
        if(endCounter > 20){
            if(endNum==1){
                endNum=2;
            }
            else if(endNum==2){
                endNum=1;
            }
            endCounter = 0;
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
    public void drawWinPlayer(Graphics2D g2, int playerwin){
        BufferedImage blue = null;
        BufferedImage yellow = null;
        BufferedImage white = null;
        BufferedImage red = null;
        switch (end) {
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
        if(playerwin==0){
            g2.drawImage(blue, 270 ,260, gp.playerWinsize, gp.playerWinsize, null);
        }
        if(playerwin==1){
            g2.drawImage(yellow, 270 ,260, gp.playerWinsize, gp.playerWinsize, null);
        }
        if(playerwin==2){
            g2.drawImage(white, 270 ,260, gp.playerWinsize, gp.playerWinsize, null);
        }
        if(playerwin==3){
            g2.drawImage(red, 270 ,260, gp.playerWinsize, gp.playerWinsize, null);
        }
    }
    public void drawVictory(Graphics2D g2) {
        BufferedImage victoryup = null;
        BufferedImage victorydown = null;

        switch (end) {
            case "normal":
                if(endNum==1){
                    victoryup = victory_up;
                }
                if(endNum==2){
                    victorydown = victory_down;
                }
            
                break;
        
            default:
                break;
        }
        g2.drawImage(victoryup, 225 , 5, 355, 270, null);
        g2.drawImage(victorydown, 225 , 5, 355, 270, null);
    }
    
}