package Main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import Main.MouseListen;
import javax.swing.*;

import Entity.Entity;
import Entity.FeatherManager;
import Entity.PLayerManager;
import Entity.Player;
import Entity.PlayerPositon;
import Tile.Tile;
import Tile.TileManager;
import Octagon.Octagon;
import Octagon.OctagonManager;
public class GamePanel extends JPanel implements Runnable, ActionListener , MouseListener {
    final int originalTilesize = 16;
    final int scale = 3;
    public final int tileSize = originalTilesize*scale;
    public final int maxScreenCol= 17;
    public final int maxScreenRow= 13;
    public final int screenWidth = tileSize*maxScreenCol; //768
    public final int screenHeight = tileSize*maxScreenRow; //576
    public final int eggwidth = 63;
    public final int eggheight = 75;
    public final int maprow = 8;
    public final int mapcol = 6;
    public final int octagonSize = 70;
    public final int octagonHeight = 70;
    public final int octagonWidth = 70;
    public final int chickensize = 100;
    public boolean flip=false;
    public int selected;
    public int count=0;
    Timer timer;

    //Game State
    public int gameState;
    public final int titleState = 0;
    public final int playState = 1;
 

    int FPS = 50;
    Entity xdd;
    MouseListen mouse;
    TileManager tileM = new TileManager(this);
    OctagonManager octagonM = new OctagonManager(this);
    FeatherManager featherM = new FeatherManager(this);
    UI ui = new UI(this);
    Thread gameThread;
    PLayerManager player = new PLayerManager(this);
    public int currentPlayer = 0;
     
    public int getGameState() {
        return this.gameState;
    }
    public int setGameState(int gameState) {
        return this.gameState = gameState;
    }
    public int getplayState() {
        return this.playState;
    }

    public GamePanel(){
        addMouseListener(this);
        this.addMouseListener(new MouseListen());
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.setFocusable(true);
        timer = new Timer(50, this);
        timer.start();
        
        }
    
    public void setupGame(){
        gameState = titleState;
    }
    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }
    //Basically how fps workds
    @Override
    // public void run() {
    //     double drawInterval = 1000000000/60;
    //     double nextDrawTime = System.nanoTime() + drawInterval;
    //     while(gameThread!=null){
            
    //         update();
    //         repaint();
            
    //         try {
    //             double remainingTime = nextDrawTime - System.nanoTime();
    //             remainingTime = remainingTime/1000000;
    //             if(remainingTime<0){
    //                 remainingTime = 0;
    //             }
    //             Thread.sleep((long) remainingTime);
    //             nextDrawTime += drawInterval;
    //         } catch (InterruptedException e) {
                
    //             e.printStackTrace();
    //         }
    //     }
    // }
    public void run(){
        double drawInterval = 1000000000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer=0;
        int drawCount = 0;

        while(gameThread!=null){
            currentTime = System.nanoTime();
            delta+=(currentTime - lastTime)/drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;
            if(delta>=1){
                update();
                repaint();
                delta--;
                drawCount++;
            }
            if(timer>=1000000000){
                // System.out.println("FPS: " + drawCount);
                drawCount = 0;
                timer = 0;
            }
        }
    }
    
    public void update(){
        featherM.update();
        player.update();
        
    }
   
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        //Titlescreen
        if(gameState==titleState){
            ui.draw(g2);
        }
        else{
            tileM.draw(g2);
            octagonM.draw(g2);
            featherM.draw(g2);
            player.draw(g2);
            
        }
        
        g2.dispose();

    }
    int direction =1;
    Octagon[] octagons = OctagonManager.getArray();
    Tile[] egg = TileManager.getArray();
    Player[] players = PLayerManager.getArray();
    int trackcount = 0;
    int playercheck = currentPlayer;
    public void checkChicken(int currentPlayer){
        
        if((players[playercheck].getPosition()+1)%24==players[(playercheck+1)%4].getPosition()){
            trackcount+=1;
            playercheck=(playercheck+1)%4;
            
            checkChicken(currentPlayer);
        }
        if((players[playercheck].getPosition()+1)%24==players[(playercheck+2)%4].getPosition()){
            trackcount+=1;
            playercheck=(playercheck+2)%4;
            
            checkChicken(currentPlayer);
        }
        if((players[playercheck].getPosition()+1)%24==players[(playercheck+3)%4].getPosition()){
            trackcount+=1;
            playercheck=(playercheck+3)%4;
            
            checkChicken(currentPlayer);
        }
        
    
        System.out.println(trackcount);
        
    }
    public void actionPerformed(ActionEvent e) {
        if(gameState==playState)
        {
                if(flip)
            {
                flip=octagons[selected].flip();
                    if(octagons[selected].getWidth() <=0)
                {
                    if(octagons[selected].getIsBackSide()==true)
                    {
                        octagons[selected].setPicture(octagons[selected].getName()); 
                    }
                    else{
                        octagons[selected].setPicture("backside");
                    }
                }
            }  
        }
            
                 
       
       repaint();
        }
    
    

    @Override
    public void mouseClicked(MouseEvent e) {
        
    }
    int dem=0;
    @Override
    
    public void mousePressed(MouseEvent e) {
        
        
        int mx = e.getX();
        int my = e.getY();
        selected=12;
        
        if(gameState==playState){
            dem++;
            count++;      
            flip=true;
            direction=1;
               
            
            for(Octagon oct1: octagons)
            {
                if(oct1.collision(e.getX(), e.getY()))
                {
                    selected=oct1.getIndex();
                    checkChicken(currentPlayer);
                    playercheck = currentPlayer;
                    if(trackcount >= 1){
                        if(octagons[selected].getName()==egg[(players[currentPlayer].getPosition()+trackcount+1)%24].getName()){
                            players[currentPlayer].setPosition((players[currentPlayer].getPosition()+trackcount)%24);
                            
                            if(dem%2==1){
                                player.playermovement(currentPlayer);
                                System.out.println("Player "+currentPlayer+" turn");
                                //System.out.println(players[currentPlayer].getPosition());
                            }
                        }
                        
                            else{
                                if(dem%2==1){
                                currentPlayer=(currentPlayer+1)%4;
                                System.out.println("Player "+currentPlayer+" turn");
                                }
                            }
                            
                    }
                    
                    if(trackcount==0){
                        if(octagons[selected].getName()==egg[(players[currentPlayer].getPosition()+1)%24].getName()){
                        
                        if(dem%2==1){
                            player.playermovement(currentPlayer);
                            System.out.println("Player "+currentPlayer+" turn");
                            //System.out.println(players[currentPlayer].getPosition());
                        }
                    }
                        else{
                            if(dem%2==1){
                            currentPlayer=(currentPlayer+1)%4;
                            System.out.println("Player "+currentPlayer+" turn");
                            }
                        }
                    }
                    trackcount=0;
                    
                }
                count++;
            }
            
        }
    
        if(gameState==titleState){
            if(mx >= 261 && mx<= 261+240){
                if(my >= 303 && my<= 303+48){
                    gameState=playState;
                }
            }
            if(mx >= 261 && mx<= 261+240){
                if(my >= 303+48 && my<= 303+48+48){
                    System.exit(1);
                }
            }
        }
        
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
      
    }

    // public boolean flip()
    // {
    //     width -=30*direction;
    //     x+=17
    // }
        
    
    
}
