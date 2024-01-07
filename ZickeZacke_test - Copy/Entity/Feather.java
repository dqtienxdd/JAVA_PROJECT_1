package Entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import Main.GamePanel;

public class Feather extends Entity {
    GamePanel gp;
    

    public Feather(GamePanel gp ){
        this.gp = gp;
        

        setDefaultValue();
        getFeatherImage();
    }
    public void setDefaultValue(){
        x = 200;
        y = 200;
        direction = "normal";
    }
    public void getFeatherImage(){
        try{
            chick1 = ImageIO.read(getClass().getResourceAsStream("/res/chicken animation/chickenpixel.png"));
            chick2 = ImageIO.read(getClass().getResourceAsStream("/res/chicken animation/chickenpixel2.png"));
            chick3 = ImageIO.read(getClass().getResourceAsStream("/res/chicken animation/chickenpixel3.png"));
            chick4 = ImageIO.read(getClass().getResourceAsStream("/res/chicken animation/chickenpixel4.png"));
            chick5 = ImageIO.read(getClass().getResourceAsStream("/res/chicken animation/chickenpixel3.png"));
        }catch(Exception e){
            e.printStackTrace();
        }
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
       
        if(spriteCounter > 32){
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
       
        g2.drawImage(image, 100 , 180 , gp.chickensize, gp.chickensize, null);
    
    }
}   
