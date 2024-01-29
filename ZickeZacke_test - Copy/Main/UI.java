package Main;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;
import java.io.IOException;
import java.io.InputStream;
import Main.GamePanel;
import javax.imageio.ImageIO;
import javax.swing.JLabel;

import Tile.Tile;

public class UI {
    GamePanel gp;
    Graphics2D g2;
    Tile[] title;
    Font MaruMonika, purisaB;
    JLabel label;
    public int commandNum = 0;
    public Rectangle playButton = new Rectangle(261,303, 240, 48);
    public Rectangle ExitButton = new Rectangle(261,303 + 48, 240, 48);
    public Rectangle questionButton = new Rectangle(758,10, 48, 70);
    public Rectangle chooseButton2 = new Rectangle(261,303, 240, 48);
    public Rectangle chooseButton3 = new Rectangle(261,303+48, 240, 48);
    public Rectangle chooseButton4 = new Rectangle(261,303+96, 240, 48);
    public Rectangle MainMenu1 = new Rectangle(261,303+96+48, 240, 48);
    public Rectangle MainMenu = new Rectangle(25,350, 192, 48);
    public Rectangle ExitButton1 = new Rectangle(585,350, 192, 48);
    public int getcommandNum(){
        return this.commandNum;
    }
    public int setcommandNum(int commandNum){
        return this.commandNum;
    }
    public UI(GamePanel gp){
        this.gp = gp;
        title = new Tile[10];
        getTitleImage();
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
        int y = gp.tileSize*3;
        //Box
        
        // g2.setColor(Color.white);
        // g2.drawString(text, x, y);
        
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON); 
        g2.drawImage(title[1].getPicture(), 0, 0, gp.screenWidth, gp.screenHeight, null);
        g2.drawImage(title[2].getPicture(), 758, 10, 48, 70, null);
        int width = gp.tileSize*5;
        int height = gp.tileSize*2;
        int Xbox = getXforCenteredText(text)-gp.tileSize*3;
        int Ybox = gp.tileSize*6;
        //Menu
        

        g2.setColor(Color.white);
        g2.setFont(g2.getFont().deriveFont(Font.BOLD,30F));
        
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
        text = "Main Menu";
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
        g2.draw(MainMenu1);
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