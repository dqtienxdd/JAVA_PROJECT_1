package Entity;
import Main.GamePanel;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import javax.imageio.ImageIO;
public class PLayerManager extends Entity {
    GamePanel gp;
    Graphics2D g2;
    public MapCoordinate[] xy;
    Feather[] feathers = FeatherManager.getArray();
    
    public PLayerManager(GamePanel gp){
        this.gp = gp;
        xy = new MapCoordinate[24];    
    }
    public void setUpPlayerManager()
    {
        setUpPlayer();
        setDefaultValue();
        getPlayerImage();
    }
    public static Player[] getArray()
    {
        return players;
    }
    public void setDefaultValue(){
        x = 120;
        y = 37;
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
    public void setUpPlayer()
    {
        if(gp.howManyPlayer==2)
        {
            players = new Player[2];
            players[0]= new Player("Blue", playerposition1, 1);
            players[1]= new Player("Yellow", playerposition3, 1);
        }
        if(gp.howManyPlayer==3)
        {
            players = new Player[3];
            players[0]= new Player("Blue", 0, 1);
            players[1]= new Player("Yellow", 8, 1);
            players[2]= new Player("White", 16 , 1);
        }
        if(gp.howManyPlayer==4)
        {
            players = new Player[4];
            players[0]= new Player("Blue", playerposition1, 1);
            players[1]= new Player("Yellow", playerposition2, 1);
            players[2]= new Player("White", playerposition3, 1);
            players[3]= new Player("Red", playerposition4, 1);
        }
        //System.out.println(players[0].getName());
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
            arrowdown_down = ImageIO.read(getClass().getResourceAsStream("/res/arrow/arrowdown_down.png"));
            arrowdown_up = ImageIO.read(getClass().getResourceAsStream("/res/arrow/arrowdown_up.png"));
            arrowleft_left = ImageIO.read(getClass().getResourceAsStream("/res/arrow/arrowleft_left.png"));
            arrowleft_right = ImageIO.read(getClass().getResourceAsStream("/res/arrow/arrowleft_right.png"));
            arrowright_left = ImageIO.read(getClass().getResourceAsStream("/res/arrow/arrowright_left.png"));
            arrowright_right = ImageIO.read(getClass().getResourceAsStream("/res/arrow/arrowright_right.png"));
            arrowup_down = ImageIO.read(getClass().getResourceAsStream("/res/arrow/arrowup_down.png"));
            arrowup_up= ImageIO.read(getClass().getResourceAsStream("/res/arrow/arrowup_up.png"));
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void playermovement(int currentPlayer){
        players[currentPlayer].setPosition((players[currentPlayer].getPosition()+1)%24);
        //System.out.println(players[currentPlayer].getPosition());
        
    }
    public void update(){
        if(gp.gameState == gp.playState){
            direction = "normal";
            direction2 = "normal";
        }else{
            direction = "off";
            direction2 = "off";
        }
        if(gp.gameState == gp.playState){
            spriteCounter++;
            arrowCounter++;
        }
        if(arrowCounter > 23){
            if(arrowNum==1){
                arrowNum=2;
            }
            else if(arrowNum==2){
                arrowNum=1;
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
        }
    }
    public void drawArrowTurn(Graphics2D g2, int currentPlayer){
        BufferedImage arrowup = null;
        BufferedImage arrowleft = null;
        BufferedImage arrowright = null;
        BufferedImage arrowdown = null;
        

        switch(direction2){
            case "normal":
            if(arrowNum==1){
                arrowup = arrowup_down;
                arrowleft = arrowleft_left;
                arrowright = arrowright_left;
                arrowdown = arrowdown_down;
            }
            if(arrowNum==2){
                arrowup = arrowup_up;
                arrowleft = arrowleft_right;
                arrowright = arrowright_right;
                arrowdown = arrowdown_up;
            }  
            break;
            
            default:
                break;
        }
        if(players[currentPlayer].getPosition()>=7&&players[currentPlayer].getPosition()<=12){
            g2.drawImage(arrowleft, xy[players[currentPlayer].getPosition()].getX()+gp.eggwidth+10, xy[players[currentPlayer].getPosition()].getY()+gp.eggwidth/2, gp.arrowsize, gp.arrowsize, null);
        }
        if(players[currentPlayer].getPosition()>=1&&players[currentPlayer].getPosition()<=6){
            g2.drawImage(arrowdown, xy[players[currentPlayer].getPosition()].getX()+13, xy[players[currentPlayer].getPosition()].getY()-gp.eggheight/2-15, gp.arrowsize, gp.arrowsize, null);
        }
        if(players[currentPlayer].getPosition()>=13&&players[currentPlayer].getPosition()<=18){
            g2.drawImage(arrowup, xy[players[currentPlayer].getPosition()].getX()+13, xy[players[currentPlayer].getPosition()].getY()+gp.eggheight+25, gp.arrowsize, gp.arrowsize, null);
        }
        if((players[currentPlayer].getPosition()>=19&&players[currentPlayer].getPosition()<=23)||players[currentPlayer].getPosition()==0){
            g2.drawImage(arrowright, xy[players[currentPlayer].getPosition()].getX()-gp.eggwidth/2-18, xy[players[currentPlayer].getPosition()].getY()+gp.eggwidth/2, gp.arrowsize, gp.arrowsize, null);
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

        if(gp.howManyPlayer==2)
        {
            g2.drawImage(blue, xy[players[0].getPosition()].getX() , xy[players[0].getPosition()].getY(), gp.chickensize, gp.chickensize, null);
            g2.drawImage(yellow, xy[players[1].getPosition()].getX() , xy[players[1].getPosition()].getY(), gp.chickensize, gp.chickensize, null);
        }
        if(gp.howManyPlayer==3)
        {
            g2.drawImage(blue, xy[players[0].getPosition()].getX() , xy[players[0].getPosition()].getY(), gp.chickensize, gp.chickensize, null);
            g2.drawImage(yellow, xy[players[1].getPosition()].getX() , xy[players[1].getPosition()].getY(), gp.chickensize, gp.chickensize, null);
            g2.drawImage(white, xy[players[2].getPosition()].getX() , xy[players[2].getPosition()].getY(), gp.chickensize, gp.chickensize, null);
        }
        if(gp.howManyPlayer==4)
        {
            g2.drawImage(blue, xy[players[0].getPosition()].getX() , xy[players[0].getPosition()].getY(), gp.chickensize, gp.chickensize, null);
            g2.drawImage(yellow, xy[players[1].getPosition()].getX() , xy[players[1].getPosition()].getY(), gp.chickensize, gp.chickensize, null);
            g2.drawImage(white, xy[players[2].getPosition()].getX() , xy[players[2].getPosition()].getY(), gp.chickensize, gp.chickensize, null);
            g2.drawImage(red, xy[players[3].getPosition()].getX() , xy[players[3].getPosition()].getY(), gp.chickensize, gp.chickensize, null);
        }
    }
}
