package Main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;
import java.util.Random;

import Main.MouseListen;
import javax.swing.*;

import Entity.EndUI;
import Entity.Entity;
import Entity.Feather;
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
    public final int screenWidth = tileSize*maxScreenCol; //816
    public final int screenHeight = tileSize*maxScreenRow; //624
    public final int eggwidth = 63;
    public final int eggheight = 75;
    public final int maprow = 8;
    public final int mapcol = 6;
    public final int octagonSize = 70;
    public final int octagonHeight = 70;
    public final int octagonWidth = 70;
    public final int chickensize = 100;
    public final int arrowsize = 70;
    public boolean flip=false;
    public int selected;
    public int count=0;
    Timer timer;

    //Game State
    public int gameState;
    public int howManyPlayer=3;
    public final int titleState = 0;
    public final int choosePState = 1;
    public final int playState = 2;
    public final int endState = 3;
   
 

    int FPS = 55;
    Entity xdd;
    MouseListen mouse;
    TileManager tileM = new TileManager(this);
    OctagonManager octagonM = new OctagonManager(this);
    FeatherManager featherM = new FeatherManager(this);
    PLayerManager player = new PLayerManager(this);
    Sound sound = new Sound();
    
    UI ui = new UI(this);
    Thread gameThread;
    
    EndUI endG = new EndUI(this);
    public int currentPlayer = 0;
    public int fraudChicken;
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
        endG.update();
    }
   
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        //Titlescreen
        if(gameState==titleState){
            ui.draw(g2);
        } 
        if(gameState==choosePState){
            ui.draw(g2);
        }
        if(gameState == endState) {
            ui.draw(g2);
            endG.drawVictory(g2);
            // player.drawWinPlayer(g2, currentPlayer);
            // featherM.drawWinFeather(g2, currentPlayer);            
        }
        if(gameState == playState) {
            tileM.draw(g2);
            player.drawArrowTurn(g2,currentPlayer);
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
    Feather[] feathers = FeatherManager.getArray();
    Feather[] drawFeathers = FeatherManager.getDrawArray();
    
    int trackcount = 0;
    int playercheck = currentPlayer;
    int feather1;
    int feather2;
    int feather3;
    public void checkChicken(int currentPlayer){
        //playercheck = currentPlayer;
        if(howManyPlayer==2)
        {
            if((players[playercheck].getPosition()+1)%24==players[(playercheck+1)%howManyPlayer].getPosition()){
                trackcount+=1;
                playercheck=(playercheck+1)%howManyPlayer;
                //fraudChicken = playercheck;
                checkChicken(currentPlayer);
            }
        }
        if(howManyPlayer==3)
        {
            if((players[playercheck].getPosition()+1)%24==players[(playercheck+1)%howManyPlayer].getPosition()){
                trackcount+=1;
                playercheck=(playercheck+1)%howManyPlayer;
                //fraudChicken = playercheck;
                checkChicken(currentPlayer);
            }
            if((players[playercheck].getPosition()+1)%24==players[(playercheck+2)%howManyPlayer].getPosition()){
                trackcount+=1;
                playercheck=(playercheck+2)%howManyPlayer;
                //fraudChicken = playercheck;
                
                checkChicken(currentPlayer);
            }

        }
        
        if(howManyPlayer==4)
        {
            if((players[playercheck].getPosition()+1)%24==players[(playercheck+1)%howManyPlayer].getPosition()){
                trackcount+=1;
                playercheck=(playercheck+1)%4;
                //fraudChicken = playercheck;
                checkChicken(currentPlayer);
            }
            if((players[playercheck].getPosition()+1)%24==players[(playercheck+2)%howManyPlayer].getPosition()){
                trackcount+=1;
                playercheck=(playercheck+2)%4;
                //fraudChicken = playercheck;
                
                checkChicken(currentPlayer);
            }
            if((players[playercheck].getPosition()+1)%24==players[(playercheck+3)%4].getPosition()){
                trackcount+=1;
                playercheck=(playercheck+3)%4;
                //fraudChicken = playercheck;
                
                checkChicken(currentPlayer);
            }

        }
        
        
    }
    public void checkFeather(int currentPlayer){
        //playercheck = currentPlayer;
        if(howManyPlayer==2)
        {
        if((players[playercheck].getPosition()+1)%24==players[(playercheck+1)%howManyPlayer].getPosition()){
            trackcount+=1;
            playercheck=(playercheck+1)%howManyPlayer;
            fraudChicken = playercheck;
            if(dem%2==1){
                takeFeather(currentPlayer, fraudChicken);
            }
            checkFeather(currentPlayer);
        }
        }
        if(howManyPlayer==3)
        {
        if((players[playercheck].getPosition()+1)%24==players[(playercheck+1)%howManyPlayer].getPosition()){
            trackcount+=1;
            playercheck=(playercheck+1)%howManyPlayer;
            fraudChicken = playercheck;
            if(dem%2==1){
                takeFeather(currentPlayer, fraudChicken);
            }
            checkFeather(currentPlayer);
        }
        if((players[playercheck].getPosition()+1)%24==players[(playercheck+2)%howManyPlayer].getPosition()){
            trackcount+=1;
            playercheck=(playercheck+2)%howManyPlayer;
            fraudChicken = playercheck;
            if(dem%2==1){
                takeFeather(currentPlayer, fraudChicken);
            }
            checkFeather(currentPlayer);
        }
    }
        if(howManyPlayer==4)
        {
        if((players[playercheck].getPosition()+1)%24==players[(playercheck+1)%4].getPosition()){
            trackcount+=1;
            playercheck=(playercheck+1)%4;
            fraudChicken = playercheck;
            if(dem%2==1){
                takeFeather(currentPlayer, fraudChicken);
            }
            checkFeather(currentPlayer);
        }
        if((players[playercheck].getPosition()+1)%24==players[(playercheck+2)%4].getPosition()){
            trackcount+=1;
            playercheck=(playercheck+2)%4;
            fraudChicken = playercheck;
            if(dem%2==1){
                takeFeather(currentPlayer, fraudChicken);
            }
            checkFeather(currentPlayer);
        }
        if((players[playercheck].getPosition()+1)%24==players[(playercheck+3)%4].getPosition()){
            trackcount+=1;
            playercheck=(playercheck+3)%4;
            fraudChicken = playercheck;
            if(dem%2==1){
                takeFeather(currentPlayer, fraudChicken);
            }
            checkFeather(currentPlayer);
        }
    }
}
    public void playSE(int i){
        sound.setFile(i);
        sound.play();
    }
    public Feather temp;
    public int feathercheck;
    public void takeFeather(int currentPlayer, int fraudChicken) {
        feathercheck = players[fraudChicken].getIndex();
        if(feathercheck!=0){
            if(players[fraudChicken].getIndex()==1){
                feathers[fraudChicken]= drawFeathers[currentPlayer];
            }
            if(players[fraudChicken].getIndex()>=1){
                if(howManyPlayer==4)
                {
                    if(feathers[fraudChicken].getPosition()==players[fraudChicken].getPosition()){
                        feathers[fraudChicken]= drawFeathers[currentPlayer];
                    }
                    if(feathers[(fraudChicken+1)%4].getPosition()==players[fraudChicken].getPosition()){
                        feathers[(fraudChicken+1)%4]= drawFeathers[currentPlayer];
                    }
                    if(feathers[(fraudChicken+2)%4].getPosition()==players[fraudChicken].getPosition()){
                        feathers[(fraudChicken+2)%4]= drawFeathers[currentPlayer];
                    }
                    if(feathers[(fraudChicken+3)%4].getPosition()==players[fraudChicken].getPosition()){
                        feathers[(fraudChicken+3)%4]= drawFeathers[currentPlayer];
                    }
                }
                if(howManyPlayer==3)
                {
                    if(feathers[fraudChicken].getPosition()==players[fraudChicken].getPosition()){
                        feathers[fraudChicken]= drawFeathers[currentPlayer];
                    }
                    if(feathers[(fraudChicken+1)%howManyPlayer].getPosition()==players[fraudChicken].getPosition()){
                        feathers[(fraudChicken+1)%howManyPlayer]= drawFeathers[currentPlayer];
                    }
                    if(feathers[(fraudChicken+2)%howManyPlayer].getPosition()==players[fraudChicken].getPosition()){
                        feathers[(fraudChicken+2)%howManyPlayer]= drawFeathers[currentPlayer];
                    }
                }
                if(howManyPlayer==2)
                {
                    if(feathers[fraudChicken].getPosition()==players[fraudChicken].getPosition()){
                        feathers[fraudChicken]= drawFeathers[currentPlayer];
                    }
                    if(feathers[(fraudChicken+1)%howManyPlayer].getPosition()==players[fraudChicken].getPosition()){
                        feathers[(fraudChicken+1)%howManyPlayer]= drawFeathers[currentPlayer];
                    }
                }
                
            }
            players[currentPlayer].setIndex(players[currentPlayer].getIndex()+players[fraudChicken].getIndex());
            players[fraudChicken].setIndex(players[fraudChicken].getIndex()-players[fraudChicken].getIndex());
        }
        System.out.println("player"+currentPlayer+": "+players[currentPlayer].getIndex());
        System.out.println("player"+fraudChicken+": "+players[fraudChicken].getIndex());
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
        int mx = e.getX();
        int my = e.getY();
        if(gameState==titleState){
            if(mx >= 261 && mx<= 261+240){
                if(my >= 303 && my<= 303+48){
                    gameState=choosePState;
                    playSE(0);
                }
            }
            if(mx >= 261 && mx<= 261+240){
                if(my >= 303+48 && my<= 303+48+48){
                    playSE(0);
                    System.exit(1);
                }
            }
        }
        if(gameState==endState){
            if(mx >= 50 && mx<= 40+192){
                if(my >= 350 && my<= 350+48){
                    playSE(0);
                    setDefault();
                    gameState=titleState;
                }
            }
            if(mx >= 585 && mx<= 565+192){
                if(my >= 350 && my<= 350+48){
                    System.exit(1);
                }
            }
        }
    }
    int dem=0;
    int num=0;
    int trackcount2=0;

    @Override
    
    public void mousePressed(MouseEvent e) {
        
        int mx = e.getX();
        int my = e.getY();
        selected=12;
        
        if(gameState==playState){ 
            flip=true;
            direction=1;
               
            
            for(Octagon oct1: octagons)
            {
                if(oct1.collision(e.getX(), e.getY()))
                {
                    selected=oct1.getIndex();
                    dem++;
                    checkChicken(currentPlayer);
                    
                    playercheck = currentPlayer;
                    if(trackcount >= 1){
                        if(octagons[selected].getName()==egg[(players[currentPlayer].getPosition()+trackcount+1)%24].getName()){
                            trackcount = 0;
                            
                            if(dem%2==1){
                                checkFeather(currentPlayer);
                                if(players[currentPlayer].getIndex()!=0){
                                    playSE(1);
                                    feathers[currentPlayer].setPosition((players[currentPlayer].getPosition()+trackcount+1)%24);
                                    drawFeathers[currentPlayer].setPosition((players[currentPlayer].getPosition()+trackcount+1)%24);
                                }
                                
                                players[currentPlayer].setPosition((players[currentPlayer].getPosition()+trackcount)%24);
                                player.playermovement(currentPlayer);
                                featherM.Feathermovement(currentPlayer);
                                
                                
                                System.out.println("Player "+players[currentPlayer].getName()+" turn");
                                //System.out.println(players[currentPlayer].getPosition());
                            }else dem=0;
                        }
                        
                            else{
                                if(dem%2==1){
                                    playSE(3);
                                    currentPlayer=(currentPlayer+1)%howManyPlayer;
                                    System.out.println("Player "+players[currentPlayer].getName()+" turn");
                                }else dem=0;
                            }
                        
                            
                    }
                    
                    if(trackcount==0){
                        if(octagons[selected].getName()==egg[(players[currentPlayer].getPosition()+1)%24].getName()){
                        
                        if(dem%2==1){
                            if(players[currentPlayer].getIndex()!=0){
                                playSE(2);
                                feathers[currentPlayer].setPosition((feathers[currentPlayer].getPosition()+1)%24);
                                drawFeathers[currentPlayer].setPosition((players[currentPlayer].getPosition()+1)%24);
                            }
                            
                            player.playermovement(currentPlayer);
                            featherM.Feathermovement(currentPlayer);
                            System.out.println("Player "+players[currentPlayer].getName()+" turn");
                            //System.out.println(players[currentPlayer].getPosition());
                        }else dem=0;
                    }
                        else{
                            if(dem%2==1){
                                playSE(3);
                                currentPlayer=(currentPlayer+1)%howManyPlayer;
                                System.out.println("Player "+players[currentPlayer].getName()+" turn");
                            }else dem=0;
                        }  
                    }
                    trackcount=0;
                    if(players[currentPlayer].getIndex() == howManyPlayer) {
                        gameState = endState;
                    }
                }
                
            }   
        }
        if(gameState==choosePState){
            if(mx >= 261 && mx<= 261+240){
                if(my >= 303 && my<= 303+48){
                    howManyPlayer = 2;
                    
                    gameState=playState;
                    playSE(0);
                    System.out.println(howManyPlayer);
                }
            }
            if(mx >= 261 && mx<= 261+240){
                if(my >= 303+48 && my<= 303+48+48){
                    howManyPlayer = 3;
                    
                    gameState=playState;
                    playSE(0);
                    System.out.println(howManyPlayer);
                }
            }
            if(mx >= 261 && mx<= 261+240){
                if(my >= 303+48+48 && my<= 303+48+48+48){
                    howManyPlayer = 4;
                 
                    gameState=playState;
                    playSE(0);
                    System.out.println(howManyPlayer);
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
