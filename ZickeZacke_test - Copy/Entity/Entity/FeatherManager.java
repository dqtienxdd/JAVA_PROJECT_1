package Entity;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import Main.GamePanel;
public class FeatherManager extends Entity{
    public BufferedImage image;
    public BufferedImage bluefeather, yellowfeather, whitefeather, redfeather;
    public String direction;
    public int spriteCounter=0;
    public int spriteNum=1;
    GamePanel gp;
    PLayerManager p1;
    public MapCoordinate[] xy;
    
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
    public void setUpFeatherManager()
    {
        setUpFeather();
        setUpDraw();
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
    public static Feather[] getArray()
    {
        return feathers;
    }
    public static Feather[] getDrawArray()
    {
        return drawfeathers;
    }
    public void setUpFeather()
    {
        if(gp.howManyPlayer==2)
        {
            feathers = new Feather[2];
            feathers[0]= new Feather("xdd", 0, 0); 
            feathers[1]= new Feather("xdd", 12, 12);
        }
        if(gp.howManyPlayer==3)
        {
            feathers = new Feather[3];
            feathers[0]= new Feather("xdd", 0, 0); 
            feathers[1]= new Feather("xdd", 8, 8);
            feathers[2]= new Feather("xdd", 16, 16);
        }
        if(gp.howManyPlayer==4)
        {
            feathers = new Feather[4];
            feathers[0]= new Feather("xdd", bluefeathertrack, bluefeathertrack); 
            feathers[1]= new Feather("xdd", yellowfeathertrack, yellowfeathertrack);
            feathers[2]= new Feather("xdd", whitefeathertrack, whitefeathertrack);
            feathers[3]= new Feather("xdd", redfeathertrack, redfeathertrack);
        //System.out.println(players[0].getName());
    }
}
    public void setUpDraw()
    {
        if(gp.howManyPlayer==2)
        {
            drawfeathers = new Feather[2];
            drawfeathers[0]= new Feather("xdd", 0, 0); 
            drawfeathers[1]= new Feather("xdd", 12, 12);
        }
        if(gp.howManyPlayer==3)
        {
            drawfeathers = new Feather[3];
            drawfeathers[0]= new Feather("xdd", 0, 0); 
            drawfeathers[1]= new Feather("xdd", 8, 8);
            drawfeathers[2]= new Feather("xdd", 16, 16);
        }
        if(gp.howManyPlayer==4)
        {
            drawfeathers = new Feather[4];
            drawfeathers[0]= new Feather("xdd", bluefeathertrack, bluefeathertrack); 
            drawfeathers[1]= new Feather("xdd", yellowfeathertrack, yellowfeathertrack);
            drawfeathers[2]= new Feather("xdd", whitefeathertrack, whitefeathertrack);
            drawfeathers[3]= new Feather("xdd", redfeathertrack, redfeathertrack);
    }
        
        //System.out.println(players[0].getName());
    }
    public void getFeatherImage(){
        try{
            
            for(int i = 0;i < 4;i++){
                featheranimation1[i] = new Feather(name[i],i, 0);
                featheranimation2[i] = new Feather(name[i+4],i, 1);
                featheranimation3[i] = new Feather(name[i+8],i, 2);
                featheranimation4[i] = new Feather(name[i+12],i, 3);
                featheranimation5[i] = new Feather(name[i+8],i, 2);
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
    public void setFeather(int feather){
        if(gp.howManyPlayer==2)
        {
            bluefeathertrack = players[0].getPosition();
            yellowfeathertrack = players[1].getPosition();
        }
        if(gp.howManyPlayer==3)
        {
            bluefeathertrack = players[0].getPosition();
            yellowfeathertrack = players[1].getPosition();
            whitefeathertrack = players[2].getPosition();
        }
        if(gp.howManyPlayer==4)
        {
            bluefeathertrack = players[0].getPosition();
            yellowfeathertrack = players[1].getPosition();
            whitefeathertrack = players[2].getPosition();
            redfeathertrack = players[3].getPosition();
        }
    }
    public void Feathermovement(int currentPlayer){
        if(gp.howManyPlayer==2){
            if(feathers[0].getIndex()==players[currentPlayer].getPosition()){
                feathers[currentPlayer].setPosition(players[currentPlayer].getPosition());
                drawfeathers[currentPlayer].setPosition(players[currentPlayer].getPosition());
            }
            if(feathers[1].getIndex()==players[currentPlayer].getPosition()){
                feathers[currentPlayer].setPosition(players[currentPlayer].getPosition());
                drawfeathers[currentPlayer].setPosition(players[currentPlayer].getPosition());
            }
        }
        if(gp.howManyPlayer==3){
            if(feathers[0].getIndex()==players[currentPlayer].getPosition()){
                feathers[currentPlayer].setPosition(players[currentPlayer].getPosition());
                drawfeathers[currentPlayer].setPosition(players[currentPlayer].getPosition());
            }
            if(feathers[1].getIndex()==players[currentPlayer].getPosition()){
                feathers[currentPlayer].setPosition(players[currentPlayer].getPosition());
                drawfeathers[currentPlayer].setPosition(players[currentPlayer].getPosition());
            }
            if(feathers[2].getIndex()==players[currentPlayer].getPosition()){
                feathers[currentPlayer].setPosition(players[currentPlayer].getPosition());
                drawfeathers[currentPlayer].setPosition(players[currentPlayer].getPosition());
            }
        }
        if(gp.howManyPlayer==4){
            if(feathers[0].getIndex()==players[currentPlayer].getPosition()){
                feathers[currentPlayer].setPosition(players[currentPlayer].getPosition());
                drawfeathers[currentPlayer].setPosition(players[currentPlayer].getPosition());
            }
            if(feathers[1].getIndex()==players[currentPlayer].getPosition()){
                feathers[currentPlayer].setPosition(players[currentPlayer].getPosition());
                drawfeathers[currentPlayer].setPosition(players[currentPlayer].getPosition());
            }
            if(feathers[2].getIndex()==players[currentPlayer].getPosition()){
                feathers[currentPlayer].setPosition(players[currentPlayer].getPosition());
                drawfeathers[currentPlayer].setPosition(players[currentPlayer].getPosition());
            }
            if(feathers[3].getIndex()==players[currentPlayer].getPosition()){
                feathers[currentPlayer].setPosition(players[currentPlayer].getPosition());
                drawfeathers[currentPlayer].setPosition(players[currentPlayer].getPosition());
            }   
        }
    }
    public void draw(Graphics2D g2){
        bluefeather = null;
        yellowfeather = null;
        whitefeather = null;
        redfeather = null;
        switch (direction) {
            case "normal":
                if(spriteNum==1){
                    bluefeather = featheranimation1[0].setPicture(name[0]);
                    yellowfeather = featheranimation1[1].setPicture(name[1]);
                    whitefeather = featheranimation1[2].setPicture(name[2]);
                    redfeather = featheranimation1[3].setPicture(name[3]);
                }
                if(spriteNum==2){
                    bluefeather = featheranimation2[0].setPicture(name[0+4]);
                    yellowfeather = featheranimation2[1].setPicture(name[1+4]);
                    whitefeather = featheranimation2[2].setPicture(name[2+4]);
                    redfeather = featheranimation2[3].setPicture(name[3+4]);
                }
                if(spriteNum==3){
                    bluefeather = featheranimation3[0].setPicture(name[0+8]);
                    yellowfeather = featheranimation3[1].setPicture(name[1+8]);
                    whitefeather = featheranimation3[2].setPicture(name[2+8]);
                    redfeather = featheranimation3[3].setPicture(name[3+8]);
                }
                if(spriteNum==4){
                    bluefeather = featheranimation4[0].setPicture(name[0+12]);
                    yellowfeather = featheranimation4[1].setPicture(name[1+12]);
                    whitefeather = featheranimation4[2].setPicture(name[2+12]);
                    redfeather = featheranimation4[3].setPicture(name[3+12]);
                }
                if(spriteNum==5){
                    bluefeather = featheranimation5[0].setPicture(name[0+8]);
                    yellowfeather = featheranimation5[1].setPicture(name[1+8]);
                    whitefeather = featheranimation5[2].setPicture(name[2+8]);
                    redfeather = featheranimation5[3].setPicture(name[3+8]);
                }
                if(spriteNum>=6 &&spriteNum<=8){
                    bluefeather = featheranimation1[0].setPicture(name[0]);
                    yellowfeather = featheranimation1[1].setPicture(name[1]);
                    whitefeather = featheranimation1[2].setPicture(name[2]);
                    redfeather = featheranimation1[3].setPicture(name[3]);
                }
                break;
        
            default:
                break;
        }
        if(gp.howManyPlayer==2)
        {
            g2.drawImage(bluefeather, xy[(feathers[0].getPosition())%24].getX(),xy[(feathers[0].getPosition())%24].getY(), gp.chickensize, gp.chickensize, null);
            g2.drawImage(yellowfeather, xy[(feathers[1].getPosition())%24].getX(),xy[(feathers[1].getPosition())%24].getY(), gp.chickensize, gp.chickensize, null);
        }
        if(gp.howManyPlayer==3)
        {
            g2.drawImage(bluefeather, xy[(feathers[0].getPosition())%24].getX(),xy[(feathers[0].getPosition())%24].getY(), gp.chickensize, gp.chickensize, null);
            g2.drawImage(yellowfeather, xy[(feathers[1].getPosition())%24].getX(),xy[(feathers[1].getPosition())%24].getY(), gp.chickensize, gp.chickensize, null);
            g2.drawImage(whitefeather, xy[(feathers[2].getPosition())%24].getX(),xy[(feathers[2].getPosition())%24].getY(), gp.chickensize, gp.chickensize, null);
        }
        if(gp.howManyPlayer==4)
        {
            g2.drawImage(bluefeather, xy[(feathers[0].getPosition())%24].getX(),xy[(feathers[0].getPosition())%24].getY(), gp.chickensize, gp.chickensize, null);
            g2.drawImage(yellowfeather, xy[(feathers[1].getPosition())%24].getX(),xy[(feathers[1].getPosition())%24].getY(), gp.chickensize, gp.chickensize, null);
            g2.drawImage(whitefeather, xy[(feathers[2].getPosition())%24].getX(),xy[(feathers[2].getPosition())%24].getY(), gp.chickensize, gp.chickensize, null);
            g2.drawImage(redfeather, xy[(feathers[3].getPosition())%24].getX(),xy[(feathers[3].getPosition())%24].getY(), gp.chickensize, gp.chickensize, null); 
        }  
    }
}   
