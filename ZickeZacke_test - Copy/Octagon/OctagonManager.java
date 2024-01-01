package Octagon;

import java.awt.Graphics2D;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Random;

import javax.imageio.ImageIO;

import Main.GamePanel;
public class OctagonManager {
    GamePanel gp;
    Octagon[] octagons;
    int mapOctagonNum[][];

    public static void shuffleArray(Octagon[] array) {
        Random random = new Random();
        int n = array.length;
        
        for (int i = 0; i < n; i++) {
            int randomIndex = i + random.nextInt(n - i);
            Octagon temp = array[i];
            array[i] = array[randomIndex];
            array[randomIndex] = temp;
        }
    }

    public OctagonManager(GamePanel gp)
    {
        this.gp = gp;
        octagons = new Octagon[13];
    
        // mapTileNum = new int[gp.maxScreenCol][gp.maxScreenRow];
        
        getOctagonImage();
        // loadMap("/res/Map/map1.txt");
    }

    public void getOctagonImage(){
        try {
            octagons[0] = new Octagon();
            octagons[0].image = ImageIO.read(getClass().getResourceAsStream("/res/Tile/chick.png"));

            octagons[1] = new Octagon();
            octagons[1] .image = ImageIO.read(getClass().getResourceAsStream("/res/Tile/chick.png"));

            octagons[2] = new Octagon();
            octagons[2].image = ImageIO.read(getClass().getResourceAsStream("/res/Tile/connhim.png"));

            octagons[3] = new Octagon();
            octagons[3].image = ImageIO.read(getClass().getResourceAsStream("/res/Tile/eggs.png"));

            octagons[4] = new Octagon();
            octagons[4].image = ImageIO.read(getClass().getResourceAsStream("/res/Tile/feather.png"));

            octagons[5] = new Octagon();
            octagons[5].image = ImageIO.read(getClass().getResourceAsStream("/res/Tile/flower.png"));

            octagons[6] = new Octagon();
            octagons[6].image = ImageIO.read(getClass().getResourceAsStream("/res/Tile/hotvitlon.png"));

            octagons[7] = new Octagon();
            octagons[7].image = ImageIO.read(getClass().getResourceAsStream("/res/Tile/omelette.png"));

            octagons[8] = new Octagon();
            octagons[8].image = ImageIO.read(getClass().getResourceAsStream("/res/Tile/rabbit.png"));

            octagons[9] = new Octagon();
            octagons[9].image = ImageIO.read(getClass().getResourceAsStream("/res/Tile/sadchick.png"));

            octagons[10] = new Octagon();
            octagons[10].image = ImageIO.read(getClass().getResourceAsStream("/res/Tile/snail.png"));

            octagons[11] = new Octagon();
            octagons[11].image = ImageIO.read(getClass().getResourceAsStream("/res/Tile/worm.png"));

            octagons[12] = new Octagon();
            octagons[12].image = ImageIO.read(getClass().getResourceAsStream("/res/Tile/worm7mau.png"));

            
            shuffleArray(octagons);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void draw(Graphics2D g2){
        g2.drawImage(octagons[0].image, 300, 140 , gp.octagonSize, gp.octagonSize, null);
        g2.drawImage(octagons[0].image, 396, 140 , gp.octagonSize, gp.octagonSize, null);
        g2.drawImage(octagons[0].image, 300, 215 , gp.octagonSize, gp.octagonSize, null);
        g2.drawImage(octagons[0].image, 396, 215 , gp.octagonSize, gp.octagonSize, null);
        g2.drawImage(octagons[0].image, 300, 290 , gp.octagonSize, gp.octagonSize, null);
        g2.drawImage(octagons[0].image, 396, 290 , gp.octagonSize, gp.octagonSize, null);
        g2.drawImage(octagons[0].image, 300, 365 , gp.octagonSize, gp.octagonSize, null);
        g2.drawImage(octagons[0].image, 396, 365 , gp.octagonSize, gp.octagonSize, null);

        g2.drawImage(octagons[0].image, 204, 215 , gp.octagonSize, gp.octagonSize, null);
        g2.drawImage(octagons[0].image, 492, 215 , gp.octagonSize, gp.octagonSize, null);
        g2.drawImage(octagons[0].image, 204, 290 , gp.octagonSize, gp.octagonSize, null);
        g2.drawImage(octagons[0].image, 492, 290 , gp.octagonSize, gp.octagonSize, null);
    
        
        // g2.drawImage(octagons[1].image, x, y, gp.tileSize, gp.tileSize, null);
        // g2.drawImage(octagons[2].image, x, y, gp.tileSize, gp.tileSize, null);
        // g2.drawImage(octagons[3].image, x, y, gp.tileSize, gp.tileSize, null);
        // g2.drawImage(octagons[4].image, x, y, gp.tileSize, gp.tileSize, null);
        // g2.drawImage(octagons[5].image, x, y, gp.tileSize, gp.tileSize, null);
        // g2.drawImage(octagons[6].image, x, y, gp.tileSize, gp.tileSize, null);
        // g2.drawImage(octagons[7].image, x, y, gp.tileSize, gp.tileSize, null);
        // g2.drawImage(octagons[8].image, x, y, gp.tileSize, gp.tileSize, null);
        // g2.drawImage(octagons[9].image, x, y, gp.tileSize, gp.tileSize, null);
        // g2.drawImage(octagons[10].image, x, y, gp.tileSize, gp.tileSize, null);
        // g2.drawImage(octagons[11].image, x, y, gp.tileSize, gp.tileSize, null);
    }
}







