package Main;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import Main.GamePanel;
import javax.imageio.ImageIO;
import javax.swing.JLabel;

import Entity.Entity;
import Entity.Feather;
import Entity.FeatherManager;
import Entity.PLayerManager;
import Tiles.Tile;

public class UI extends Entity{
    GamePanel gp;
    Graphics2D g2;
    Tile[] title;
    Font MaruMonika, purisaB;

    public int commandNum = 0;
    public Rectangle playButton = new Rectangle(261,303, 240, 48);
    public Rectangle ExitButton = new Rectangle(261,303 + 48, 240, 48);
    public Rectangle questionButton = new Rectangle(758,10, 48, 70);
    public Rectangle chooseButton2 = new Rectangle(261,303, 240, 48);
    public Rectangle chooseButton3 = new Rectangle(261,303+48, 240, 48);
    public Rectangle chooseButton4 = new Rectangle(261,303+96, 240, 48);
    public Rectangle BackButton = new Rectangle(261,303+96+48, 240, 48);
    public Rectangle MainMenu = new Rectangle(25,350, 192, 48);
    public Rectangle ExitButton1 = new Rectangle(585,350, 192, 48);

    PLayerManager p;
    FeatherManager f;
    public static Feather[] featheranimation1, featheranimation2, featheranimation3, featheranimation4, featheranimation5;
    String[] name = {"bluefeather1","yellowfeather1","whitefeather1","redfeather1",
                     "bluefeather2","yellowfeather2","whitefeather2","redfeather2",
                     "bluefeather3","yellowfeather3","whitefeather3","redfeather3",
                     "bluefeather4","yellowfeather4","whitefeather4","redfeather4"};
    Feather[] feathers = FeatherManager.getArray();




  
    public UI(GamePanel gp){
        this.gp = gp;
        title = new Tile[10];
        featheranimation1 = new Feather[4];
        featheranimation2 = new Feather[4];
        featheranimation3 = new Feather[4];
        featheranimation4 = new Feather[4];
        featheranimation5 = new Feather[4];
        getTitleImage();
        getHTPImage();
        getFeatherImage();
        try {
            InputStream is = getClass().getResourceAsStream("/res/Font/Purisa Bold.ttf");
            MaruMonika = Font.createFont(Font.TRUETYPE_FONT, is);
            is = getClass().getResourceAsStream("/res/Font/x12y16pxMaruMonica.ttf");
            purisaB = Font.createFont(Font.TRUETYPE_FONT,is);
        } catch (FontFormatException e) {
        
            e.printStackTrace();
        } catch (IOException e) {
            
            e.printStackTrace();
        }
    }
    public void getHTPImage() {
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
            warning = ImageIO.read(getClass().getResourceAsStream("/res/arrow/warning.png"));
            warning2 = ImageIO.read(getClass().getResourceAsStream("/res/arrow/warning2.png"));
        }catch(Exception e){
            e.printStackTrace();
        }
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
        
        if(gp.gameState == gp.HTPState){
            end = "normal";
        }else{
            end = "off";
        }
        if(gp.gameState == gp.HTPState){
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
    public void drawPlayer(Graphics2D g2){
        BufferedImage blue = null;
        BufferedImage yellow = null;
        BufferedImage white = null;
        BufferedImage red = null;
        BufferedImage bluefeather = null;
        BufferedImage yellowfeather = null;
        BufferedImage whitefeather = null;
        BufferedImage redfeather = null;
        switch (end) {
            case "normal":
                if(spriteNum==1){
                    blue = chick1;
                    yellow = chick6;
                    white = chick11;
                    red = chick16;
                    bluefeather = featheranimation1[0].setPicture(name[0]);
                    yellowfeather = featheranimation1[1].setPicture(name[1]);
                    whitefeather = featheranimation1[2].setPicture(name[2]);
                    redfeather = featheranimation1[3].setPicture(name[3]);
                }
                if(spriteNum==2){
                    blue = chick2;
                    yellow = chick7;
                    white = chick12;
                    red = chick17;
                    bluefeather = featheranimation2[0].setPicture(name[0+4]);
                    yellowfeather = featheranimation2[1].setPicture(name[1+4]);
                    whitefeather = featheranimation2[2].setPicture(name[2+4]);
                    redfeather = featheranimation2[3].setPicture(name[3+4]);
                }
                if(spriteNum==3){
                    blue = chick3;
                    yellow = chick8;
                    white = chick13;
                    red = chick18;
                    bluefeather = featheranimation3[0].setPicture(name[0+8]);
                    yellowfeather = featheranimation3[1].setPicture(name[1+8]);
                    whitefeather = featheranimation3[2].setPicture(name[2+8]);
                    redfeather = featheranimation3[3].setPicture(name[3+8]);
                }
                if(spriteNum==4){
                    blue = chick4;
                    yellow = chick9;
                    white = chick14;
                    red = chick19;
                    bluefeather = featheranimation4[0].setPicture(name[0+12]);
                    yellowfeather = featheranimation4[1].setPicture(name[1+12]);
                    whitefeather = featheranimation4[2].setPicture(name[2+12]);
                    redfeather = featheranimation4[3].setPicture(name[3+12]);
                }
                if(spriteNum==5){
                    blue = chick5;
                    yellow = chick10;
                    white = chick15;
                    red = chick20;
                    bluefeather = featheranimation5[0].setPicture(name[0+8]);
                    yellowfeather = featheranimation5[1].setPicture(name[1+8]);
                    whitefeather = featheranimation5[2].setPicture(name[2+8]);
                    redfeather = featheranimation5[3].setPicture(name[3+8]);
                }
                if(spriteNum>=6 &&spriteNum<=8){
                    blue = chick1;
                    yellow = chick6;
                    white = chick11;
                    red = chick16;
                    bluefeather = featheranimation1[0].setPicture(name[0]);
                    yellowfeather = featheranimation1[1].setPicture(name[1]);
                    whitefeather = featheranimation1[2].setPicture(name[2]);
                    redfeather = featheranimation1[3].setPicture(name[3]);
                }
                break;
            default:
                break;
        }
                g2.drawImage(bluefeather,28,70,75,75,null);
                g2.drawImage(blue, 28,70,75,75, null);

                g2.drawImage(yellowfeather,720,70,75,75,null);
                g2.drawImage(yellow, 720 ,70, 75,75, null);

                g2.drawImage(whitefeather,28,530,75,75,null);
                g2.drawImage(white, 28 ,530, 75,75, null);

                g2.drawImage(redfeather,720,530,75,75,null);
                g2.drawImage(red, 720 ,530, 75,75, null);
                
            
        
    }
    public void draw(Graphics2D g2){
        this.g2 = g2;

        g2.setFont(purisaB);
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON); 
        //Title State
        if(gp.gameState == gp.titleState) {
            drawTitleScreen();
        }
        
        if(gp.gameState == gp.HTPState) {
            drawHTPScreen();
        }
        if(gp.gameState == gp.choosePState) {
            drawPlayerScreen();
        }
        if(gp.gameState == gp.endState) {
            drawEndScreen();
        }
    }
    public void getTitleImage(){
        
            title[0] = new Tile("background2", 0);
            title[1] = new Tile("endbackground",1);
            title[2] = new Tile("question",2);
    }
    public void drawTitleScreen(){
        // g2.setFont(g2.getFont().deriveFont(Font.BOLD,66F));
        // String text = "Zicke Zacke Hühnerkacke";
        String text = "xdd";
        int x;
        int y = gp.tileSize*3;
        //Box
        
        // g2.setColor(Color.white);
        // g2.drawString(text, x, y);
        
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON); 
        g2.drawImage(title[0].getPicture(), 0, 0, gp.screenWidth, gp.screenHeight, null);
        g2.drawImage(title[2].getPicture(), 758, 10, 48, 70, null);
        int width = gp.tileSize*5;
        int height = gp.tileSize*2;
        int Xbox = getXforCenteredText(text)-gp.tileSize*3;
        int Ybox = gp.tileSize*6;
        drawSubWindow(286, 303,width,height);
        //Menu
        

        g2.setColor(Color.white);
        g2.setFont(g2.getFont().deriveFont(Font.BOLD,30F));
        text = "Start Game";
        x = getXforCenteredText(text);
        y += gp.tileSize*4;
        g2.drawString(text, x, y);
        if(commandNum == 1){
            g2.drawString(">", x - gp.tileSize, y);
        }
        
        
        text = "Exit Game";
        x = getXforCenteredText(text);
        y += gp.tileSize;
        g2.drawString(text, x, y);
        if(commandNum == 2){
            g2.drawString(">", x - gp.tileSize, y);
        }
        g2.setColor(new Color(255,255,255, 0));
        g2.draw(playButton);
        g2.draw(ExitButton);

        
    }
    public void drawHTPScreen(){
        // g2.setFont(g2.getFont().deriveFont(Font.BOLD,66F));
        // String text = "Zicke Zacke Hühnerkacke";
        String text = "xdd";
        int x;
        int y = gp.tileSize + 72;
        //Box
        
        // g2.setColor(Color.white);
        // g2.drawString(text, x, y);
        
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON); 
        g2.drawImage(title[1].getPicture(), 0, 0, gp.screenWidth, gp.screenHeight, null);
        g2.drawImage(title[2].getPicture(), 758, 10, 48, 70, null);
        int width = gp.tileSize*15;
        int height = gp.tileSize*10;
        int Xbox = getXforCenteredText(text)-gp.tileSize*3;
        int Ybox = gp.tileSize*6;
        drawSubWindow(48, 100, width, height);
        //Menu
        

        g2.setColor(Color.white);
        g2.setFont(g2.getFont().deriveFont(Font.BOLD,20F));
        text = "Taking Turns:";
        x = 96;
        y += gp.tileSize;
        g2.drawString(text, x, y);
       
           
        text = "Players take turns by looking at the next space in front of their chicken. The current \nplayer then choose an octagonal tile. If the picture on the tile matches, the player \ncan move their chicken to that space. If the picture does not match, the current \nplayer stays on the tile it has reached, and the next player takes a turn.";
        x = 72;
        y += 25;
        for(String line : text.split("\n")){
            g2.drawString(line, x, y);
            y += 25;
        };
        text = "Overtaking:";
        x = 96;
        y += gp.tileSize/2;
        g2.drawString(text, x, y);

        text = "If a chicken catches up to another chicken, it can attempt to overtake by finding the \nmatching tile for the space in front of the other chicken. If successful, the \novertaking chicken jumps in front and steals all the feathers. The player's turn\ncontinues. A chicken can overtake multiple chickens in one go if they are standing\nin an unbroken row.";
        x = 72;
        y += 25;
        for(String line : text.split("\n")){
            g2.drawString(line, x, y);
            y += 25;
        };
        
        text = "Winning Condition:";
        x = 96;
        y += gp.tileSize/2;
        g2.drawString(text, x, y);
        
        text = "The first chicken to collect all feathers of other players is the winner.";
        x = 72;
        y += 25;
        g2.drawString(text, x, y);
        
        
        g2.setColor(new Color(255,255,255, 0));
        
    }
    public void drawPlayerScreen(){
        // g2.setFont(g2.getFont().deriveFont(Font.BOLD,66F));
        // String text = "Zicke Zacke Hühnerkacke";
        String text = "xdd";
        int x;
        int y = gp.tileSize*3;
        //Box
        
        // g2.setColor(Color.white);
        // g2.drawString(text, x, y);
        
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON); 
        g2.drawImage(title[0].getPicture(), 0, 0, gp.screenWidth, gp.screenHeight, null);
        int width = gp.tileSize*5;
        int height = gp.tileSize*3;
        int Xbox = getXforCenteredText(text)-gp.tileSize*3;
        int Ybox = gp.tileSize*6;
        drawSubWindow(286, 303,width,height);
        drawSubWindow(286, 447,width,gp.tileSize);
        //Menu
        

        g2.setColor(Color.white);
        g2.setFont(g2.getFont().deriveFont(Font.BOLD,30F));
        text = "2 Players";
        x = getXforCenteredText(text);
        y += gp.tileSize*4;
        g2.drawString(text, x, y);
        if(commandNum == 3){
            g2.drawString(">", x - gp.tileSize, y);
        }
        
        text = "3 Players";
        x = getXforCenteredText(text);
        y += gp.tileSize;
        g2.drawString(text, x, y);
        if(commandNum == 4){
            g2.drawString(">", x - gp.tileSize, y);
        }

        text = "4 Players";
        x = getXforCenteredText(text);
        y += gp.tileSize;
        g2.drawString(text, x, y);
        if(commandNum == 5){
            g2.drawString(">", x - gp.tileSize, y);
        }
        text = "Back";
        x = getXforCenteredText(text);
        y += gp.tileSize;
        g2.drawString(text, x, y);
        if(commandNum == 6){
            g2.drawString(">", x - gp.tileSize, y);
        }
        g2.setColor(new Color(255,255,255, 0));
        g2.draw(chooseButton2);
        g2.draw(chooseButton3);
        g2.draw(chooseButton4);
        g2.draw(BackButton);
    }
    public void drawEndScreen() {
        String text = "xdd";
        int x;
        int y = gp.tileSize*3;

        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON); 
        g2.drawImage(title[1].getPicture(), 0, 0, gp.screenWidth, gp.screenHeight, null);
        int width = gp.tileSize*4;
        int height = gp.tileSize;
        int Xbox = getXforCenteredText(text)-gp.tileSize*3;
        int Ybox = gp.tileSize*6;
        drawSubWindow(573, 350,width,height);
        drawSubWindow(53, 350,width,height);

        g2.setColor(Color.white);
        g2.setFont(g2.getFont().deriveFont(Font.BOLD,30F));
        text = "Main Menu";
        x = 80;
        y = gp.tileSize * 8;
        g2.drawString(text, x, y);
        if(commandNum == 7){
            g2.drawString(">", x - gp.tileSize, y);
        }

        text = "Exit Game";
        x = 610;
        y = gp.tileSize*8;
        g2.drawString(text, x, y);
        if(commandNum == 8){
            g2.drawString(">", x - gp.tileSize, y);
        }
        g2.setColor(new Color(255,255,255, 0));
        g2.draw(MainMenu);
        g2.draw(ExitButton1);

    }
    public void drawWarning(Graphics2D g2){
        this.g2 = g2;
        drawSubWindow(60, 573,720,43);
        g2.drawImage(warning2, 70, 580, 700, 31, null);
    }
    public void drawSubWindow(int x, int y, int width, int height){
        Color c = new Color(0,0,0,200);
        g2.setColor(c);
        g2.fillRoundRect(x, y, width, height, 35, 35);

        c = new Color(150, 203, 217);
        g2.setColor(c);
        g2.setStroke(new BasicStroke(3));
        g2.drawRoundRect(x+3, y+3, width-6, height-6, 29, 29);
    }
    
    public int getXforCenteredText(String text){
        int length = (int)g2.getFontMetrics().getStringBounds(text,g2).getWidth();
        int x = gp.screenWidth/2 - length/2;
        return x;
    }
}
