package Octagons;

import java.awt.Graphics2D;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Random;

import javax.imageio.ImageIO;

import Entity.Player;
import Main.GamePanel;
public class OctagonManager {
    GamePanel gp;
    public static Octagon[] octagons;
    int mapOctagonNum[][];
    Octagon backside;
    Octagon backside2;
    public static Octagon[] getArray()
    {
        return octagons;
    }
    public static void shuffleArray(String[] array) {
        Random random = new Random();
        int n = array.length;
        
        for (int i = 0; i < n; i++) {
            int randomIndex = i + random.nextInt(n - i);
            String temp = array[i];
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
        String[] name={"chick", "connhim", "eggs", "feather", "flower", "hotvitlon", "omelette", "rabbit", "sadchick", "snail", "worm", "worm7mau"};
        try {
            // octagons[0] = new Octagon();
            // octagons[0].image = ImageIO.read(getClass().getResourceAsStream("/res/octagonal_shape/chick.png"));

            // octagons[1] = new Octagon();
            // octagons[1].image = ImageIO.read(getClass().getResourceAsStream("/res/octagonal_shape/chick.png"));

            // octagons[2] = new Octagon();
            // octagons[2].image = ImageIO.read(getClass().getResourceAsStream("/res/octagonal_shape/connhim.png"));

            // octagons[3] = new Octagon();
            // octagons[3].image = ImageIO.read(getClass().getResourceAsStream("/res/octagonal_shape/eggs.png"));

            // octagons[4] = new Octagon();
            // octagons[4].image = ImageIO.read(getClass().getResourceAsStream("/res/octagonal_shape/feather.png"));

            // octagons[5] = new Octagon();
            // octagons[5].image = ImageIO.read(getClass().getResourceAsStream("/res/octagonal_shape/flower.png"));

            // octagons[6] = new Octagon();
            // octagons[6].image = ImageIO.read(getClass().getResourceAsStream("/res/octagonal_shape/hotvitlon.png"));

            // octagons[7] = new Octagon();
            // octagons[7].image = ImageIO.read(getClass().getResourceAsStream("/res/octagonal_shape/omelette.png"));

            // octagons[8] = new Octagon();
            // octagons[8].image = ImageIO.read(getClass().getResourceAsStream("/res/octagonal_shape/rabbit.png"));

            // octagons[9] = new Octagon();
            // octagons[9].image = ImageIO.read(getClass().getResourceAsStream("/res/octagonal_shape/sadchick.png"));

            // octagons[10] = new Octagon();
            // octagons[10].image = ImageIO.read(getClass().getResourceAsStream("/res/octagonal_shape/snail.png"));

            // octagons[11] = new Octagon();
            // octagons[11].image = ImageIO.read(getClass().getResourceAsStream("/res/octagonal_shape/worm.png"));

            backside = new Octagon("backside",12);
            backside.image = ImageIO.read(getClass().getResourceAsStream("/res/octagonal_shape/backside.png"));

            // backside2 = new Octagon();
            // backside2.image = ImageIO.read(getClass().getResourceAsStream("/res/octagonal_shape/backside2.png"));
            shuffleArray(name);
            
            for(int i=0; i<12; i++)
            {
                octagons[i] = new Octagon(name[i],i);
            }
            octagons[12] = new Octagon("worm", 12);
            
            octagons[0].setX(300 + 48/2);
            octagons[0].setY(140 + 48/2);

            octagons[1].setX(396 + 48/2);
            octagons[1].setY(140 + 48/2);

            octagons[2].setX(300 + 48/2);
            octagons[2].setY(215 + 48/2);

            octagons[3].setX(396 + 48/2);
            octagons[3].setY(215 + 48/2);

            octagons[4].setX(300 + 48/2);
            octagons[4].setY(290 + 48/2);

            octagons[5].setX(396 + 48/2);
            octagons[5].setY(290 + 48/2);

            octagons[6].setX(300 + 48/2);
            octagons[6].setY(365 + 48/2);

            octagons[7].setX(396 + 48/2);
            octagons[7].setY(365 + 48/2);

            octagons[8].setX(204 + 48/2);
            octagons[8].setY(215 + 48/2);

            octagons[9].setX(492 + 48/2);
            octagons[9].setY(215 + 48/2);

            octagons[10].setX(204 + 48/2);
            octagons[10].setY(290 + 48/2);

            octagons[11].setX(492 + 48/2);
            octagons[11].setY(290 + 48/2);
            

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void draw(Graphics2D g2){
        // g2.drawImage(backside2.image, 300, 140 , gp.octagonSize, gp.octagonSize, null);
        // g2.drawImage(backside2.image, 396, 140 , gp.octagonSize, gp.octagonSize, null);
        // g2.drawImage(backside2.image, 300, 215 , gp.octagonSize, gp.octagonSize, null);
        // g2.drawImage(backside2.image, 396, 215 , gp.octagonSize, gp.octagonSize, null);
        // g2.drawImage(backside2.image, 300, 290 , gp.octagonSize, gp.octagonSize, null);
        // g2.drawImage(backside2.image, 396, 290 , gp.octagonSize, gp.octagonSize, null);
        // g2.drawImage(backside2.image, 300, 365 , gp.octagonSize, gp.octagonSize, null);
        // g2.drawImage(backside2.image, 396, 365 , gp.octagonSize, gp.octagonSize, null);

        // g2.drawImage(backside2.image, 204, 215 , gp.octagonSize, gp.octagonSize, null);
        // g2.drawImage(backside2.image, 492, 215 , gp.octagonSize, gp.octagonSize, null);
        // g2.drawImage(backside2.image, 204, 290 , gp.octagonSize, gp.octagonSize, null);
        // g2.drawImage(backside2.image, 492, 290 , gp.octagonSize, gp.octagonSize, null);
        for(int i=0; i<12; i++)
        {
            g2.drawImage(octagons[i].getPicture(), octagons[i].getX(), octagons[i].getY() , octagons[i].getWidth(), octagons[i].getHeight(), null);
        }
        
    }
}







