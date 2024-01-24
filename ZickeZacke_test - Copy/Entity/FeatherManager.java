package Entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import Main.GamePanel;

public class FeatherManager extends Entity{
    public BufferedImage image;
    public int x, y;
    public BufferedImage feather1, feather2, feather3, feather4, feather5;
    public String direction;
    public int spriteCounter=0;
    public int spriteNum=1;
    GamePanel gp;
    PLayer p1;
    
    
    
    public static Feather[] featheranimation1, featheranimation2, featheranimation3, featheranimation4, featheranimation5;
    String[] name = {"bluefeather1","yellowfeather1","whitefeather1","redfeather1",
                     "bluefeather2","yellowfeather2","whitefeather2","redfeather2",
                     "bluefeather3","yellowfeather3","whitefeather3","redfeather3",
                     "bluefeather4","yellowfeather4","whitefeather4","redfeather4"};
    public FeatherManager(GamePanel gp){
        this.gp = gp;
        xy = new MapCoordinate[24];
        featheranimation1 = new Feather[4];
        featheranimation2 = new Feather[4];
        featheranimation3 = new Feather[4];
        featheranimation4 = new Feather[4];
        featheranimation5 = new Feather[4];
        setDefaultValue();
        getFeatherImage();
    }
    public void getFeatherPosition(){
        for(int i=0; i<12; i++){
            xy[i] = new MapCoordinate(i,i);
        }
        xy[0].setX(100);
        xy[0].setY(20);
        xy[1].setX(100+gp.eggwidth+5);
        xy[1].setY(20);
    }  
    public void setDefaultValue(){
        x = 200;
        y = 200;
        direction = "normal";
    }
    public void getFeatherImage(){
        try{
            
            for(int i = 0;i < 4;i++){
                featheranimation1[i] = new Feather(name[i],i);
                featheranimation2[i] = new Feather(name[i+4],i);
                featheranimation3[i] = new Feather(name[i+8],i);
                featheranimation4[i] = new Feather(name[i+12],i);
                featheranimation5[i] = new Feather(name[i+8],i);
            }
            
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
        
        BufferedImage feather1 = null;
        BufferedImage feather2 = null;
        BufferedImage feather3 = null;
        BufferedImage feather4 = null;
        switch (direction) {
            case "normal":
                if(spriteNum==1){
                    feather1 = featheranimation1[0].setPicture(name[0]);
                    feather2 = featheranimation1[1].setPicture(name[1]);
                    feather3 = featheranimation1[2].setPicture(name[2]);
                    feather4 = featheranimation1[3].setPicture(name[3]);
                }
                if(spriteNum==2){
                    feather1 = featheranimation2[0].setPicture(name[0+4]);
                    feather2 = featheranimation2[1].setPicture(name[1+4]);
                    feather3 = featheranimation2[2].setPicture(name[2+4]);
                    feather4 = featheranimation2[3].setPicture(name[3+4]);
                }
                if(spriteNum==3){
                    feather1 = featheranimation3[0].setPicture(name[0+8]);
                    feather2 = featheranimation3[1].setPicture(name[1+8]);
                    feather3 = featheranimation3[2].setPicture(name[2+8]);
                    feather4 = featheranimation3[3].setPicture(name[3+8]);
                }
                if(spriteNum==4){
                    feather1 = featheranimation4[0].setPicture(name[0+12]);
                    feather2 = featheranimation4[1].setPicture(name[1+12]);
                    feather3 = featheranimation4[2].setPicture(name[2+12]);
                    feather4 = featheranimation4[3].setPicture(name[3+12]);
                }
                if(spriteNum==5){
                    feather1 = featheranimation5[0].setPicture(name[0+8]);
                    feather2 = featheranimation5[1].setPicture(name[1+8]);
                    feather3 = featheranimation5[2].setPicture(name[2+8]);
                    feather4 = featheranimation5[3].setPicture(name[3+8]);
                }
                if(spriteNum>=6 &&spriteNum<=8){
                    feather1 = featheranimation1[0].setPicture(name[0]);
                    feather2 = featheranimation1[1].setPicture(name[1]);
                    feather3 = featheranimation1[2].setPicture(name[2]);
                    feather4 = featheranimation1[3].setPicture(name[3]);
                }
                break;
        
            default:
                break;
        }
       
        g2.drawImage(feather1, xy[playerposition].getX(),xy[playerposition].getY(), gp.chickensize, gp.chickensize, null);
        g2.drawImage(feather2, xy[playerposition].getX(),xy[playerposition].getY(), gp.chickensize, gp.chickensize, null);
        g2.drawImage(feather3, xy[playerposition].getX(),xy[playerposition].getY(), gp.chickensize, gp.chickensize, null);
        g2.drawImage(feather4, xy[playerposition].getX(),xy[playerposition].getY(), gp.chickensize, gp.chickensize, null);
        
    
    }
}   
