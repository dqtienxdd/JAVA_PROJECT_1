package Entity;
import Main.GamePanel;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Arrays;

import javax.imageio.ImageIO;



public class EndUI extends Entity {
    GamePanel gp;
    
    
  
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
            arrowCounter = 0;
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
            endCounter = 0;
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