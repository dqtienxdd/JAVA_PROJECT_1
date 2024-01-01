package Main;

import java.awt.*;
import javax.swing.*;
import Entity.PLayer;
import Tile.TileManager;
import Octagon.OctagonManager;
public class GamePanel extends JPanel implements Runnable{
    final int originalTilesize = 16;
    final int scale = 3;
    public final int tileSize = originalTilesize*scale;
    public final int maxScreenCol= 16;
    public final int maxScreenRow= 12;
    public final int screenWidth = tileSize*maxScreenCol; //768
    public final int screenHeight = tileSize*maxScreenRow; //576
    public final int eggwidth = 63;
    public final int eggheight = 75;
    public final int maprow = 8;
    public final int mapcol = 6;
    public final int octagonSize = 70;
    

    int FPS = 10;

    TileManager tileM = new TileManager(this);
    OctagonManager octagonM = new OctagonManager(this);
    
    Thread gameThread;
    PLayer player = new PLayer(this);
    
    

    public GamePanel(){
            this.setPreferredSize(new Dimension(screenWidth, screenHeight));
            this.setBackground(Color.BLACK);
            this.setDoubleBuffered(true);
            this.setFocusable(true);
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
                System.out.println("FPS: " + drawCount);
                drawCount = 0;
                timer = 0;
            }
        }
    }
    public void update(){
        player.update();
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;

        tileM.draw(g2);
        octagonM.draw(g2);
        
        player.draw(g2);
        


        g2.dispose();

    }
    
    
}
